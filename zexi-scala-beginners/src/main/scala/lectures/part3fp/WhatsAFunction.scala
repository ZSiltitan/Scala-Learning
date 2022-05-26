package lectures.part3fp

object WhatsAFunction extends App {
  val ConcatStr = new Function2[String,String,String] {
    override def apply(a: String, b:String): String = f"$a$b"
  }
  println(ConcatStr("fuck ", "you"))
//    :specialFunction[Int, Function1[Int, Int]]
  val superAdder = new Function1[Int, Function1[Int, Int]] {
//    override def apply(v1: Int): Int => Int = ???
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x*y
    }
  }
  def adder5 = superAdder(3)
  println(superAdder(3)(6))



}
