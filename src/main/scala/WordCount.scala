import org.apache.spark.{SparkContext,SparkConf}
object WordCount {
  def main(args:Array[String]): Unit =
  {
    //val conf=new SparkConf().setAppName("wordcount")
    val conf=new SparkConf().setAppName("wordcount").setMaster("spark://127.0.0.1:7077")
    val sc=new SparkContext(conf)
    /*val input=sc.textFile("/home/qyc0129/Desktop/hellospark")
    val lines=input.flatMap(line=>line.split(" "))
    val count=lines.map(word=>(word,1)).reduceByKey{case(x,y)=>x+y}*/
    val input=sc.parallelize((List(1,2,3,4,5,2,3,4,5,6)))
    val reslut=input.map(x=>x+1)
    val output=reslut.repartition(1).saveAsTextFile("/home/qyc0129/Desktop/hellosparkRes1-count1")

    val reslut1=input.flatMap(x=>x.to(3))
    val output1=reslut1.repartition(1).saveAsTextFile("/home/qyc0129/Desktop/hellosparkRes1-count2")

    val reslut2=input.filter(x=>x!=2)
    val output2=reslut2.repartition(1).saveAsTextFile("/home/qyc0129/Desktop/hellosparkRes1-count3")

    val reslut3=input.distinct()
    val output3=reslut3.repartition(1).saveAsTextFile("/home/qyc0129/Desktop/hellosparkRes1-count4")

    val reslut4=input.sample(false,0.5)
    val output4=reslut4.repartition(1).saveAsTextFile("/home/qyc0129/Desktop/hellosparkRes1-count5")
  }
}
