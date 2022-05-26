package lectures.part2oop

object Enum extends App {
  enum access{
    case READ, WRITE, EXECUTE, NONE
  }

  enum accessBits(bits: Int) {
    case READ extends accessBits(4)
    case WRITE extends accessBits(2)
    case EXECUTE extends accessBits(1)
    case NONE extends accessBits(0)
  }

  object accessBits{
    def fromBits(bits: Int):accessBits = accessBits.NONE
  }


  val accessRead = access.READ
  val accessExecute = access.EXECUTE
  println(accessRead.ordinal)
  println(accessExecute.ordinal)


  val allPermission = accessBits.values
  println(allPermission.mkString(" "))

}
