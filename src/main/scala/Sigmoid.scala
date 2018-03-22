

object Sigmoid {
    def sigmoidT(inX: Int):Double = {
      var inXX=inX.toDouble
      return 1.0 / (1.0 + math.exp(-(inXX-320.0)/60.0))
    }
  def sigmoidN(inY: Int):Double = {
    var inYY=inY.toDouble
    return 1.0 / (1.0 + math.exp(-(inYY-7.0)/1.0))
  }
  def Sigmoid(a:Int,b:Int):Double={
    val q=sigmoidT(a)//总流量归一化
    val p=sigmoidN(b)//流量次数归一化
    val res=(p+q)/2
    println(q)
    println(p)
    return res
  }
}
