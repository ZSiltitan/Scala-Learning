package lectures.part3fp

object HOFsCurries extends App  {
  def nTimes(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0)  (x: Int) => x
    else (x: Int) => (nTimes(f, n-1)(f(x)))
  }

  val add1 = (x:Int) => x + 1

  println(nTimes(add1, 10)(3))

  // Curried function
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => (x+y)
  println(superAdder(4)(3))

  val curriedFormatter: String => Double => String = (formatter: String) => (x: Double) => formatter.format(x)
  val StandardFormatter = (curriedFormatter("%4.2f"))
  val presiceFormatter = (curriedFormatter("%9.9f"))

  println(StandardFormatter(Math.PI))
  println(presiceFormatter(Math.PI))

  //  Curried function 2 param list

  def trueCurriedFormatter(formatter: String)(v1: Double): String = formatter.format(v1)

  val trueStandardFormatter = trueCurriedFormatter("%4.2f")
  val truePresiceFormatter = trueCurriedFormatter("%9.9f")

  println(trueStandardFormatter(Math.PI))
  println(truePresiceFormatter(Math.PI))


}
