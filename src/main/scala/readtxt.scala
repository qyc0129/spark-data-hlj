import org.apache.spark.{SparkConf, SparkContext}
object readtxt {


  def main(args:Array[String]): Unit =
  {
    //val conf=new SparkConf().setAppName("wordcount")
    val conf=new SparkConf().setAppName("wordcount").setMaster("spark://127.0.0.1:7077")
    val sc=new SparkContext(conf)
    val input=sc.textFile("/home/qyc0129/Desktop/test1.txt")
      //.map(_.split(" ")).filter(_.length!==3).map(x=>
      //(x(1),1)).reduceByKey(_+_).map(x=>(x._2,x._1)).sortByKey(false).map(x=>(x._2,x._1)).saveAsTextFile("/home/qyc0129/Desktop/hlj-test1")
    val lines=input.flatMap(line=>line.split(" "))
    val count=lines.map(word=>(word,1)).reduceByKey{case(x,y)=>x+y}.map(word=>(word._2,word._1))
    val output=count.repartition(1).saveAsTextFile("/home/qyc0129/Desktop/hlj-txt-test2")
    //把tar.gz中的所有TXT文件中的数据都读取到一个文件中

  }

}
