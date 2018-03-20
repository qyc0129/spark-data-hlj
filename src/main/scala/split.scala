import java.text.SimpleDateFormat
import java.util.Date

object split {
  def split(lines:String):String=
  {
    try {
      val id = lines.substring(36, lines.indexOf("\t", 36))
      //从36位即用户id的第一位开始取至36位后第一个分隔符'\t' 即为用户ID（手机号或IP地址）
      if (id.length() != 13 || id.indexOf(".") != -1) {
        //若不为手机号的逻辑判断，则该用户的id为IP地址
        //println("this is an ip user")
        return ""
      }
      else {
        val startT = lines.substring(0, 10)
        val startTime = Integer.parseInt(startT)
        //直接按位取得开始时间和结束时间
        val endT = lines.substring(18, 28)
        val endTime = Integer.parseInt(endT)
        //修改了获取的位数 取消了小数点后面的数字 转换为Int类
        if (startTime >= 1) //设置开始时间
        {
          val LAC = searchLAC(lines)
          val CI = searchCI(lines)
          val up=searchUp(lines)
          val down=searchDown(lines)
          val total=up+down
          //使用函数提取LAC和CI
          val newres = startTime + ";" + endT + ";" + id + ";" +total+";"+LAC + ";" + CI
          //println(newres)
          return newres
        }
        else {
          //println("time error")
          return ""
        }
      }
    }catch {
      case e: Exception => return ""
    }

  }
  def splithour(lines:String):String=
  {
    try {
      val id = lines.substring(36, lines.indexOf("\t", 36))
      //从36位即用户id的第一位开始取至36位后第一个分隔符'\t' 即为用户ID（手机号或IP地址）
      if (id.length() != 13 || id.indexOf(".") != -1) {
        //若不为手机号的逻辑判断，则该用户的id为IP地址
        //println("this is an ip user")
        return ""
      }
      else {
        val startT = lines.substring(0, 10)
        val startTime = Integer.parseInt(startT)
        val hour=utohour(startTime)
        //直接按位取得开始时间和结束时间
        val endT = lines.substring(18, 28)
        val endTime = Integer.parseInt(endT)
        //修改了获取的位数 取消了小数点后面的数字 转换为Int类
        if (startTime >= 1) //设置开始时间
        {
          val LAC = searchLAC(lines)
          val CI = searchCI(lines)
          val up=searchUp(lines)
          val down=searchDown(lines)
          val total=up+down
          //使用函数提取LAC和CI
          val newres = startTime + ";" + endT + ";" + id + ";" +total+";"+hour+";"+LAC + ";" + CI
          //println(newres)
          return newres
        }
        else {
          //println("time error")
          return ""
        }
      }
    }catch {
      case e: Exception => return ""
    }

  }

  def splithours(lines:String):String=
  {
    try {
      val id = lines.substring(36, lines.indexOf("\t", 36))
      //从36位即用户id的第一位开始取至36位后第一个分隔符'\t' 即为用户ID（手机号或IP地址）
      if (id.length() != 13 || id.indexOf(".") != -1) {
        //若不为手机号的逻辑判断，则该用户的id为IP地址
        //println("this is an ip user")
        return ""
      }
      else {
        val startT = lines.substring(0, 10)
        val startTime = Integer.parseInt(startT)
        var hours=0
        val hour=utohour(startTime)
        if(hour>=0&&hour<=6)
          {
            hours=0
          }
        else if(hour>=7&&hour<=12)
          {
            hours=1
          }
        else if(hour>=13&&hour<=18)
        {
          hours=2
        }
        else if(hour>=19&&hour<=23)
        {
          hours=3
        }
        //直接按位取得开始时间和结束时间
        val endT = lines.substring(18, 28)
        val endTime = Integer.parseInt(endT)
        val durT=endTime-startTime
        //修改了获取的位数 取消了小数点后面的数字 转换为Int类
        if (startTime >= 1) //设置开始时间
        {
          val LAC = searchLAC(lines)
          val CI = searchCI(lines)
          val up=searchUp(lines)
          val down=searchDown(lines)
          val total=up+down
          //使用函数提取LAC和CI
          val newres = startTime + ";" + durT + ";" + id + ";" +total+";"+hours+";"+LAC + ";" + CI
          //println(newres)
          return newres
        }
        else {
          //println("time error")
          return ""
        }
      }
    }catch {
      case e: Exception => return ""
    }

  }
  def searchUp(lines:String):Int = {
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
    val re50 = "\\d+"
    val re51 = ".*?"
    val re52 = "\\d+"
    val re53 = ".*?"
    val re54 = "\\d+"
    val re55 = ".*?"
    val re56 = "\\d+"
    val re57 = ".*?"
    val re58 = "\\d+"
    val re59 = ".*?"
    val re60 = "\\d+"
    val re61 = ".*?"
    val re62 = "\\d+"
    val re63 = ".*?"
    val re64 = "\\d+"
    val re65 = ".*?"
    val re66 = "\\d+"
    val re67 = ".*?"
    val re68 = "\\d+"
    val re69 = ".*?"
    val re70 = "\\d+"
    val re71 = ".*?"
    val re72 = "\\d+"
    val re73 = ".*?"
    val re74 = "\\d+"
    val re75 = ".*?"
    val re76 = "\\d+"
    val re77 = ".*?"
    val re78 = "\\d+"
    val re79 = ".*?"
    val re80 = "(\\d+)" // Integer Number 1


    val p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11 + re12 + re13 + re14 + re15 + re16 + re17 + re18 + re19 + re20 + re21 + re22 + re23 + re24 + re25 + re26 + re27 + re28 + re29 + re30 + re31 + re32 + re33 + re34 + re35 + re36 + re37 + re38 + re39 + re40 + re41 + re42 + re43 + re44 + re45 + re46 + re47 + re48 + re49 + re50 + re51 + re52 + re53 + re54 + re55 + re56 + re57 + re58 + re59 + re60 + re61 + re62 + re63 + re64 + re65 + re66 + re67 + re68 + re69 + re70 + re71 + re72 + re73 + re74 + re75 + re76 + re77 + re78 + re79 + re80, Pattern.CASE_INSENSITIVE | Pattern.DOTALL)
    val m = p.matcher(lines)
    if (m.find) {
      val int1 = m.group(1)
      //System.out.print(int1.toString + "\n")
      return int1.toInt
    }
    else
    {return 0}
  }
  def searchDown(lines:String):Int = {
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
    val re50 = "\\d+"
    val re51 = ".*?"
    val re52 = "\\d+"
    val re53 = ".*?"
    val re54 = "\\d+"
    val re55 = ".*?"
    val re56 = "\\d+"
    val re57 = ".*?"
    val re58 = "\\d+"
    val re59 = ".*?"
    val re60 = "\\d+"
    val re61 = ".*?"
    val re62 = "\\d+"
    val re63 = ".*?"
    val re64 = "\\d+"
    val re65 = ".*?"
    val re66 = "\\d+"
    val re67 = ".*?"
    val re68 = "\\d+"
    val re69 = ".*?"
    val re70 = "\\d+"
    val re71 = ".*?"
    val re72 = "\\d+"
    val re73 = ".*?"
    val re74 = "\\d+"
    val re75 = ".*?"
    val re76 = "\\d+"
    val re77 = ".*?"
    val re78 = "\\d+"
    val re79 = ".*?"
    val re80 = "\\d+"
    val re81 = ".*?"
    val re82 = "(\\d+)" // Integer Number 1
    val p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11 + re12 + re13 + re14 + re15 + re16 + re17 + re18 + re19 + re20 + re21 + re22 + re23 + re24 + re25 + re26 + re27 + re28 + re29 + re30 + re31 + re32 + re33 + re34 + re35 + re36 + re37 + re38 + re39 + re40 + re41 + re42 + re43 + re44 + re45 + re46 + re47 + re48 + re49 + re50 + re51 + re52 + re53 + re54 + re55 + re56 + re57 + re58 + re59 + re60 + re61 + re62 + re63 + re64 + re65 + re66 + re67 + re68 + re69 + re70 + re71 + re72 + re73 + re74 + re75 + re76 + re77 + re78 + re79 + re80 + re81 + re82, Pattern.CASE_INSENSITIVE | Pattern.DOTALL)
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
    val re46 = "(\\d+)" // Integer Number 1


    val p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11 + re12 + re13 + re14 + re15 + re16 + re17 + re18 + re19 + re20 + re21 + re22 + re23 + re24 + re25 + re26 + re27 + re28 + re29 + re30 + re31 + re32 + re33 + re34 + re35 + re36 + re37 + re38 + re39 + re40 + re41 + re42 + re43 + re44 + re45 + re46, Pattern.CASE_INSENSITIVE | Pattern.DOTALL)
    val m = p.matcher(lines)
    if (m.find) {
      val int1 = m.group(1)
      //System.out.print(int1.toString + "\n")
      return int1.toInt
    }
    else
    {return 0}
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
//  def searchCI(lines:String):Int = {
//    import java.util.regex.Pattern
//    val re1 = ".*?" // Non-greedy match on filler
//
//    val re2 = "\\d+" // Uninteresting: int
//
//    val re3 = ".*?"
//    val re4 = "\\d+"
//    val re5 = ".*?"
//    val re6 = "\\d+"
//    val re7 = ".*?"
//    val re8 = "\\d+"
//    val re9 = ".*?"
//    val re10 = "\\d+"
//    val re11 = ".*?"
//    val re12 = "\\d+"
//    val re13 = ".*?"
//    val re14 = "\\d+"
//    val re15 = ".*?"
//    val re16 = "\\d+"
//    val re17 = ".*?"
//    val re18 = "\\d+"
//    val re19 = ".*?"
//    val re20 = "\\d+"
//    val re21 = ".*?"
//    val re22 = "\\d+"
//    val re23 = ".*?"
//    val re24 = "\\d+"
//    val re25 = ".*?"
//    val re26 = "\\d+"
//    val re27 = ".*?"
//    val re28 = "\\d+"
//    val re29 = ".*?"
//    val re30 = "\\d+"
//    val re31 = ".*?"
//    val re32 = "\\d+"
//    val re33 = ".*?"
//    val re34 = "\\d+"
//    val re35 = ".*?"
//    val re36 = "\\d+"
//    val re37 = ".*?"
//    val re38 = "\\d+"
//    val re39 = ".*?"
//    val re40 = "\\d+"
//    val re41 = ".*?"
//    val re42 = "\\d+"
//    val re43 = ".*?"
//    val re44 = "\\d+"
//    val re45 = ".*?"
//    val re46 = "\\d+"
//    val re47 = ".*?"
//    val re48 = "\\d+"
//    val re49 = ".*?"
//    val re50 = "(\\d+)" // Integer Number 1
//    val p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11 + re12 + re13 + re14 + re15 + re16 + re17 + re18 + re19 + re20 + re21 + re22 + re23 + re24 + re25 + re26 + re27 + re28 + re29 + re30 + re31 + re32 + re33 + re34 + re35 + re36 + re37 + re38 + re39 + re40 + re41 + re42 + re43 + re44 + re45 + re46 + re47 + re48 + re49 + re50, Pattern.CASE_INSENSITIVE | Pattern.DOTALL)
//    val m = p.matcher(lines)
//    if (m.find) {
//      val int1 = m.group(1)
//      //System.out.print(int1.toString + "\n")
//      return int1.toInt
//    }
//    else
//    {return 0}
//  }
//  def searchLAC(lines:String):Int = {
//    import java.util.regex.Pattern
//    val re1 = ".*?"
//    // Non-greedy match on filler
//    val re2 = "\\d+"
//    // Uninteresting: int
//    val re3 = ".*?"
//    val re4 = "\\d+"
//    val re5 = ".*?"
//    val re6 = "\\d+"
//    val re7 = ".*?"
//    val re8 = "\\d+"
//    val re9 = ".*?"
//    val re10 = "\\d+"
//    val re11 = ".*?"
//    val re12 = "\\d+"
//    val re13 = ".*?"
//    val re14 = "\\d+"
//    val re15 = ".*?"
//    val re16 = "\\d+"
//    val re17 = ".*?"
//    val re18 = "\\d+"
//    val re19 = ".*?"
//    val re20 = "\\d+"
//    val re21 = ".*?"
//    val re22 = "\\d+"
//    val re23 = ".*?"
//    val re24 = "\\d+"
//    val re25 = ".*?"
//    val re26 = "\\d+"
//    val re27 = ".*?"
//    val re28 = "\\d+"
//    val re29 = ".*?"
//    val re30 = "\\d+"
//    val re31 = ".*?"
//    val re32 = "\\d+"
//    val re33 = ".*?"
//    val re34 = "\\d+"
//    val re35 = ".*?"
//    val re36 = "\\d+"
//    val re37 = ".*?"
//    val re38 = "\\d+"
//    val re39 = ".*?"
//    val re40 = "\\d+"
//    val re41 = ".*?"
//    val re42 = "\\d+"
//    val re43 = ".*?"
//    val re44 = "\\d+"
//    val re45 = ".*?"
//    val re46 = "\\d+"
//    val re47 = ".*?"
//    val re48 = "(\\d+)" // Integer Number 1
//
//    val p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11 + re12 + re13 + re14 + re15 + re16 + re17 + re18 + re19 + re20 + re21 + re22 + re23 + re24 + re25 + re26 + re27 + re28 + re29 + re30 + re31 + re32 + re33 + re34 + re35 + re36 + re37 + re38 + re39 + re40 + re41 + re42 + re43 + re44 + re45 + re46 + re47 + re48, Pattern.CASE_INSENSITIVE | Pattern.DOTALL)
//    val m = p.matcher(lines)
//    if (m.find) {
//      val int1 = m.group(1)
//      //System.out.print(int1.toString + "\n")
//      return int1.toInt
//    }
//    else
//    {return 0}
//  }
  def searchid(lines:String):Int = {
    import java.util.regex.Pattern
    val re1=".*?";	// Non-greedy match on filler
    val re2="\\d+";	// Uninteresting: int
    val re3=".*?";	// Non-greedy match on filler
    val re4="\\d+";	// Uninteresting: int
    val re5=".*?";	// Non-greedy match on filler
    val re6="\\d+";	// Uninteresting: int
    val re7=".*?";	// Non-greedy match on filler
    val re8="\\d+";	// Uninteresting: int
    val re9=".*?";	// Non-greedy match on filler
    val re10="\\d+";	// Uninteresting: int
    val re11=".*?";	// Non-greedy match on filler
    val re12="(\\d+)";	// Integer Number 1

    val p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re8+re9+re10+re11+re12,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);val m = p.matcher(lines)
    if (m.find) {
      val int1 = m.group(1)
      //System.out.print(int1.toString + "\n")
      return int1.toInt
    }
    else
    {return 0}
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
  def utohour(utcTime:Double):Int={
    val df: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val utcTimeStamp = utcTime.toLong * 1000
    val time1=df.format(new Date(utcTimeStamp))
    val month=time1.substring(5,7).toInt
    //println(month)
    val day=time1.substring(8,10).toInt
    val hour=time1.substring(11,13).toInt
    //println(day)
    //println(hour)
    return hour
  }
}
