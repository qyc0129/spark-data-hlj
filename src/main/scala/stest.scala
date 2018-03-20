import java.text.SimpleDateFormat
import java.util.Date

object stest {
def main():Unit={
  val lines="1466549982.131000\t1466549984.952000\t8614704501861\t3572250210200901\t460006534349479\t2\t1\t1\tZY201\tG113\tS-1\t86\t221.177.35.67\t221.177.19.135\t18176\t40062\t10.95.80.41\t10.95.80.49\t17\t1082\t1082\t0\t3841\t0\t4\t0\t317\t0\t0\t0\t0\t-\t-\t-\t-\t-\t��һ"
  val l=split.splithour(lines)
  print(l)
//  import java.util.Calendar
//  import java.util.TimeZone
//  val c = Calendar.getInstance
//  System.out.println(c.getTimeZone)
//  System.out.println(c.getTimeInMillis)
//  System.out.println(c.get(Calendar.HOUR_OF_DAY))
//  System.out.println(c.getTime)
//  c.setTimeZone(TimeZone.getTimeZone("GMT+9"))
//  System.out.println(c.getTimeZone)
//  System.out.println(c.getTimeInMillis)
//  System.out.println(c.get(Calendar.HOUR_OF_DAY))
//  System.out.println(c.getTime)
  //val date = utcToBeiJing(1466549982.131000)
  //println(date)
}
  def utcToBeiJing(utcTime:Double):String={
    val df: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val utcTimeStamp = utcTime.toLong * 1000
    val time1=df.format(new Date(utcTimeStamp))
    val month=time1.substring(5,7).toInt
    println(month)
    val day=time1.substring(8,10).toInt
    val hour=time1.substring(11,13).toInt
    println(day)
    println(hour)
    return time1
  }
}
