

object hello {
  def main( ) : String = {

    //val lines="1466550007.367000\t1466550010.047000\t8614745739392\t3572240241001202\t460026046184361\t2\t1\t1\t3208C\tG113\tS-1\t86\t221.177.35.66\t221.177.181.40\t39366\t23541\t192.168.29.195\t192.168.29.213\t17\t1082\t1082\t0\t3841\t0\t4\t0\t304\t0\t0\t0\t0\t-\t-\t-\t-\t-\tŵ����"
    //val lines="1466549982.131000\t1466549984.952000\t8614704501861\t3572250210200901\t460006534349479\t2\t1\t1\tZY201\tG113\tS-1\t86\t221.177.35.67\t221.177.19.135\t18176\t40062\t10.95.80.41\t10.95.80.49\t17\t1082\t1082\t0\t3841\t0\t4\t0\t317\t0\t0\t0\t0\t-\t-\t-\t-\t-\t��һ"
    val lines="(1,1466549982.131000\t1466549984.952000\t8614704501861\t3572250210200901\t460006534349479\t2\t1\t1\tZY201\tG113\tS-1\t86\t221.177.35.67\t221.177.19.135\t18176\t40062\t10.95.80.41\t10.95.80.49\t17\t1082\t1082\t0\t3841\t0\t4\t0\t317\t0\t0\t0\t0\t-\t-\t-\t-\t-\t��һ)"

    //val lines="1466549970.874000\t1466550028.167000\t125.39.207.13\t-\t-\t0\t0\t0\t-1\tG-1\tS-1\t86\t-\t-\t-\t-\t125.39.207.13\t218.203.61.90\t1\t2048\t0\t11\t2840\t4\t0\t336\t0\t0\t0\t0\t0\t-\t-\t-\t-\t-\t-1"
    //测试单条话单数据

    val id=lines.substring(39,lines.indexOf("\t",39))
    //从36位即用户id的第一位开始取至36位后第一个分隔符'\t' 即为用户ID（手机号或IP地址）
    if(id.length()!=13&id.indexOf('.')!= -1)
      {
        //若不为手机号的逻辑判断，则该用户的id为IP地址
        println("this is an ip user")
        return "fff"
      }
    else
      {
        val startT=lines.substring(3,13)
        val startTime=Integer.parseInt(startT)
        //直接按位取得开始时间和结束时间
        val endT=lines.substring(21,31)
        val endTime=Integer.parseInt(endT)
        //修改了获取的位数 取消了小数点后面的数字 转换为Int类
        if(startTime>=1)//设置开始时间
          {
            val LAC=searchLAC(lines)
            val CI=searchCI(lines)
            //使用函数提取LAC和CI
            val newres=startTime+" "+endT+" "+id+" "+LAC+" "+CI
            println(newres)
            return newres
          }
        else
          {
            println("time error")
            return "fff"
          }

      }

    //println(startT+"---"+endT+"--"+id)

    //return startT
  }
  def addInt( a:Int, b:Int ) : Int = {
    var sum:Int = 0
    sum = a + b

    return sum
  }
  def multInt(a:Int,b:Int):Int={
    var mul:Int=0
    mul=a*b
    return mul
  }
  def searchCI(lines:String):Int = {
    import java.util.regex.Pattern
    val re1 = ".*?" // Non-greedy match on filler

    val re2 = "\\d+" // Uninteresting: int

    val re3 = ".*?"
    val re4 = "\\d+"
    val re5 = ".*?"
    val re6 = "\\d+"
    val re7 = ".*?"
    val re8 = "\\d+"
    val re9 = ".*?"
    val re10 = "\\d+"
    val re11 = ".*?"
    val re12 = "\\d+"
    val re13 = ".*?"
    val re14 = "\\d+"
    val re15 = ".*?"
    val re16 = "\\d+"
    val re17 = ".*?"
    val re18 = "\\d+"
    val re19 = ".*?"
    val re20 = "\\d+"
    val re21 = ".*?"
    val re22 = "\\d+"
    val re23 = ".*?"
    val re24 = "\\d+"
    val re25 = ".*?"
    val re26 = "\\d+"
    val re27 = ".*?"
    val re28 = "\\d+"
    val re29 = ".*?"
    val re30 = "\\d+"
    val re31 = ".*?"
    val re32 = "\\d+"
    val re33 = ".*?"
    val re34 = "\\d+"
    val re35 = ".*?"
    val re36 = "\\d+"
    val re37 = ".*?"
    val re38 = "\\d+"
    val re39 = ".*?"
    val re40 = "\\d+"
    val re41 = ".*?"
    val re42 = "\\d+"
    val re43 = ".*?"
    val re44 = "\\d+"
    val re45 = ".*?"
    val re46 = "\\d+"
    val re47 = ".*?"
    val re48 = "\\d+"
    val re49 = ".*?"
    val re50 = "(\\d+)" // Integer Number 1
    val p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11 + re12 + re13 + re14 + re15 + re16 + re17 + re18 + re19 + re20 + re21 + re22 + re23 + re24 + re25 + re26 + re27 + re28 + re29 + re30 + re31 + re32 + re33 + re34 + re35 + re36 + re37 + re38 + re39 + re40 + re41 + re42 + re43 + re44 + re45 + re46 + re47 + re48 + re49 + re50, Pattern.CASE_INSENSITIVE | Pattern.DOTALL)
    val m = p.matcher(lines)
    if (m.find) {
      val int1 = m.group(1)
      //System.out.print(int1.toString + "\n")
      return int1.toInt
    }
    else
    {return 0}
  }

  def searchLAC(lines:String):Int = {
    import java.util.regex.Pattern
    val re1 = ".*?"
    // Non-greedy match on filler
    val re2 = "\\d+"
    // Uninteresting: int
    val re3 = ".*?"
    val re4 = "\\d+"
    val re5 = ".*?"
    val re6 = "\\d+"
    val re7 = ".*?"
    val re8 = "\\d+"
    val re9 = ".*?"
    val re10 = "\\d+"
    val re11 = ".*?"
    val re12 = "\\d+"
    val re13 = ".*?"
    val re14 = "\\d+"
    val re15 = ".*?"
    val re16 = "\\d+"
    val re17 = ".*?"
    val re18 = "\\d+"
    val re19 = ".*?"
    val re20 = "\\d+"
    val re21 = ".*?"
    val re22 = "\\d+"
    val re23 = ".*?"
    val re24 = "\\d+"
    val re25 = ".*?"
    val re26 = "\\d+"
    val re27 = ".*?"
    val re28 = "\\d+"
    val re29 = ".*?"
    val re30 = "\\d+"
    val re31 = ".*?"
    val re32 = "\\d+"
    val re33 = ".*?"
    val re34 = "\\d+"
    val re35 = ".*?"
    val re36 = "\\d+"
    val re37 = ".*?"
    val re38 = "\\d+"
    val re39 = ".*?"
    val re40 = "\\d+"
    val re41 = ".*?"
    val re42 = "\\d+"
    val re43 = ".*?"
    val re44 = "\\d+"
    val re45 = ".*?"
    val re46 = "\\d+"
    val re47 = ".*?"
    val re48 = "(\\d+)" // Integer Number 1

    val p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11 + re12 + re13 + re14 + re15 + re16 + re17 + re18 + re19 + re20 + re21 + re22 + re23 + re24 + re25 + re26 + re27 + re28 + re29 + re30 + re31 + re32 + re33 + re34 + re35 + re36 + re37 + re38 + re39 + re40 + re41 + re42 + re43 + re44 + re45 + re46 + re47 + re48, Pattern.CASE_INSENSITIVE | Pattern.DOTALL)
    val m = p.matcher(lines)
    if (m.find) {
      val int1 = m.group(1)
      //System.out.print(int1.toString + "\n")
      return int1.toInt
    }
    else
      {return 0}
  }

  //def searchMAP(a:Int,b:Int):String={
//
//}
}
