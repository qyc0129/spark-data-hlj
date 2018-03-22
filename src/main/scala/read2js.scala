import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object read2js {


  def main(args:Array [String]): Unit =
  {
    //val conf=new SparkConf().setAppName("wordcount").setMaster("spark://127.0.0.1:7077")
    val conf=new SparkConf().setAppName("wordcount")//由于实验室集群的设置问题，不再需要设置Master
    val sc=new SparkContext(conf)
    val spark=new SQLContext(sc)
    val spark2 = new org.apache.spark.sql.SQLContext(sc)
    //val hlj="/import_data/heilongjiang_v3/20160622/userflow_20160622_018086.tar.bz2"
//    val path2="test-1"
    //val path3="test-2"
    val hlj=args(0)
    val path2=args(1)
    val path3=args(2)
    val path4=args(3)
    //输入原始话单数据，下次可以尝试直接用整个文件夹中的所有压缩文件
    //val input=sc.textFile("/home/qyc0129/Desktop/test1.tar.bz2")
    val input=sc.textFile(hlj)
    val lines=input.flatMap(line=>line.split(" "))//按行分割
    val lines2=lines.map((f:String)=>split.splithours(f)).filter((m:String)=>m!="")//用细化过的split函数进行筛选
    //val output2=lines2.saveAsTextFile("/home/qyc0129/Desktop/test222")
    //val lines3=lines2.map((f:String)=>(f.split(";")(2)+";"+f.split(";")(4)+";"+f.split(";")(5),f.split(";")(0)+";"+f.split(";")(1)+";"+f.split(";")(3)))
    //val lines3=lines2.map((f:String)=>(f.split(";")(2)+";"+f.split(";")(4)+";"+f.split(";")(5),f.split(";")(3)))  //按天聚合

    val lines3=lines2.map((f:String)=>(f.split(";")(4)+";"+f.split(";")(5)+";"+f.split(";")(6),f.split(";")(3)))//按小时聚合 +total -time X 2

    //把用户id+lac+ci当作主键进行聚合，由于已经是一天之内的数据，相当于直接按天聚合
    //可以在split中增加"小时"，以后可以加入这一主键进行聚合，即按小时聚合
    val lines4=lines3.groupByKey().mapValues((f:Iterable[String])=>d(f)).map((f:(String,String))=>f._1+";"+f._2)
    val output2=lines4.saveAsTextFile(path2)//储存筛选后的话单数据
    val df = spark2.read.format("com.databricks.spark.csv")
      .option("header", "false")
      .option("inferSchema", "false")
      .option("delimiter",";")//分隔符；　
      .load(path2)
      //.load("test")//重新载入话单数据
    //val df2=df.toDF("sT","eT","id","total","lac","ci")//给话单数据设置表头
    //val df2=df.toDF("sT","eT","id","total","lac","ci")//给话单数据设置表头
    val df2=df.toDF("hour","lac","ci","total","num")//给话单数据设置表头
    val df1 = spark2.read.format("com.databricks.spark.csv")
      .option("header", "true")
      .option("inferSchema", "false")
      .option("delimiter",";")//分隔符；
      .load("hljfinal.csv")//载入哈尔滨基站对应表
  val df3=df2.join(df1,Seq("lac","ci")).toDF("lac","ci","hour","total","count","lng","lat")//两表按"lac"与"ci"两键值进行内链接

    val dfh0=df3.where("hour = 0")
    val dfh1=df3.where("hour = 1")
    val dfh2=df3.where("hour = 2")
    val dfh3=df3.where("hour = 3")
    //val df4=dfh0.select(df3("lng").cast("Double"),df3("lat").cast("Double"),df3("count").cast("Int"),df3("hour").cast("Int"))
    // df4.write.format("csv").save(path3)//储存最终结果
    val dffh4=dfh0.select(dfh0("lng").cast("Double"),dfh0("lat").cast("Double"),dfh0("count").cast("Int"))
    dffh4.write.mode("append").json(path3+"/h0")//json
  val dffh5=dfh1.select(dfh1("lng").cast("Double"),dfh1("lat").cast("Double"),dfh1("count").cast("Int"))
    dffh5.write.mode("append").json(path3+"/h1")//json
  val dffh6=dfh2.select(dfh2("lng").cast("Double"),dfh2("lat").cast("Double"),dfh2("count").cast("Int"))
    dffh6.write.mode("append").json(path3+"/h2")//json
  val dffh7=dfh3.select(dfh3("lng").cast("Double"),dfh3("lat").cast("Double"),dfh3("count").cast("Int"))
    dffh7.write.mode("append").json(path3+"/h3")//json

    val input2=sc.textFile(path3+"/h0")
    val linesd2=input2.map((f:String)=>f+",")
    val outputd2=linesd2.saveAsTextFile(path4+"/h0")

    val input3=sc.textFile(path3+"/h1")
    val linesd3=input3.map((f:String)=>f+",")
    val outputd3=linesd3.saveAsTextFile(path4+"/h1")

    val input4=sc.textFile(path3+"/h2")
    val linesd4=input4.map((f:String)=>f+",")
    val outputd4=linesd4.saveAsTextFile(path4+"/h2")

    val input5=sc.textFile(path3+"/h3")
    val linesd5=input5.map((f:String)=>f+",")
    val outputd5=linesd5.saveAsTextFile(path4+"/h3")
  }
  def d(f:Iterable[String]):String={//取得聚合后的键值，分别得到其长度与总和
    val size=f.size
    var sum=0
    for(va <- f){
      sum+=va.toInt
    }
    val count=Sigmoid.Sigmoid(sum,size)
    return count+";"+size
  }
}
