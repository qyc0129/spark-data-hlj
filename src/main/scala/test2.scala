import org.apache.spark.sql._
import org.apache.spark.{SparkConf, SparkContext}
object test2 {
  def main(args:Array[String]): Unit ={

    val conf = new SparkConf().setAppName("simple1").setMaster("spark://127.0.0.1:7077")
    val sc = new SparkContext(conf)
    //val df = spark.read.format("com.databricks.spark.csv").option("header", "false").option("inferSchema", "false").option("delimiter",";").load("/home/qyc0129/Desktop/test222/part-00000")
    val spark=new SQLContext(sc)
    val df1 = spark.read.format("com.databricks.spark.csv")
      .option("header", "true")
      .option("inferSchema", "false")
      .option("delimiter",";")//分隔符；
      .load("/home/qyc0129/Desktop/hljfinal.csv")
    //val df2 = spark.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "false").option("delimiter",";").load("/home/qyc0129/Desktop/hljfinal.csv")

    val df2 = spark.read.format("com.databricks.spark.csv")
      .option("header", "true")
      .option("inferSchema", "false")
      .option("delimiter",";")
      .load("/home/qyc0129/Desktop/res2")
    //val df3=df.join(df2,Seq(df("_3")==df2("lac"),df("_4")==df2("ci")))

    val df3=df2.join(df1,Seq("lac","ci"))

    df3.write.format("csv").save("/home/qyc0129/Desktop/new")

  }
}