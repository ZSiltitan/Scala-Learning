package lectures.part3fp

object AnonymousFuction extends App {
  val doubler = new Function1[Int,Int] {
    override def apply(v1: Int) = v1 * 2
  }
  println(doubler(2))

  val doublerNew = (v1: Int) => v1*2
  println(doublerNew(5))

  val mutiplier = (x: Int, y: Int) => x*y
//  val mutiplier: (Int, Int) => Int = (x: Int, y: Int) => x*y
  println(mutiplier(2,3))

  val stringToInt = { (str: String) => str.toInt }
  println(stringToInt("1"))

  val superAdder = (x: Int) => ((y:Int) => x+y)
  println(superAdder(5)(10))
}
