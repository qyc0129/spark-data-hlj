import java.io.{File, PrintWriter}

import org.apache.spark.{SparkConf, SparkContext}

import scala.io.Source
object test {
  def main(args:Array[String]):Unit={
    //val sparkConf=new SparkConf().setAppName("test").setMaster("").
    val conf=new SparkConf().setAppName("wordcount").setMaster("spark://127.0.0.1:7077")
    val sc=new SparkContext(conf)
//    val path="/mnt/buffer/heilongjiang_v3/20160607/userflow_20160607_018083.tar.bz2"
//    val path2="/home/qiuyuchen/testres1"
    val path="/home/qyc0129/Desktop/test1.tar.bz2"
    val path2="/home/qyc0129/Desktop/test1res1"
    val file=Source.fromFile(path)
    val writer = new PrintWriter(new File(path2))
    for(line <- file.getLines)
    {
      val output=split.split(line)
      if(output.length>1)
        {println(output)
        writer.println(output)}

    }
    file.close
    writer.close()
  }
  def first(a:String):String=
  {
    return a
  }
}
