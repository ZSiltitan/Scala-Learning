package lectures.part1basics

object Expression extends App {
  val someValue = {
    2<3
  }

  val someOtherValue = {
    if(someValue) 233 else 111
    42
  }
  println(someValue)
  println(someOtherValue)

}
