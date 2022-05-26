package lectures.part2oop

object Exception extends App {
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException
    else 42
  val potentialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => 30
  } finally {
    println("finally")
  }
//  throw new RuntimeException

//    class MyException extends Exception
//    val exception = new MyException
//    throw exception
  println(getInt(false))
//  val array = Array.ofDim[Int](Int.MaxValue)
//  def infinite: Int = 1 + infinite
//  val noLimit = infinite

  class OverFlowException extends RuntimeException
  class UnderFlowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator{
    def add(x:Int, y:Int):Int = {
      if (x>0 && y>0 && x+y <0)
        throw new OverFlowException
      else if (x>0 && y>0 && x+y <0)
        throw new UnderFlowException
      else x+y
    }
    def substract(x:Int, y:Int):Int = {
      val result = x-y
      if (x<0 && y>0 && result >0)
        throw new UnderFlowException
      else if (x>0 && y<0 && result <0)
        throw new OverFlowException
      else result
    }

    def multiply(x:Int, y:Int):Int = {
      if ((x<0 && y>0 && x*y >0) || (x>0 && y<0 && x*y >0))
        throw new UnderFlowException
      else if ((x>0 && y>0 && x*y <0) || (x<0 && y<0 && x*y <0))
        throw new OverFlowException
      else x*y
    }

    def division(x:Int, y:Int):Int = {
      if (y==0)
        throw new MathCalculationException
      else x/y
    }
  }

//    println(PocketCalculator.add(1,Int.MaxValue))
//    println(PocketCalculator.substract(-10,Int.MaxValue))
//    println(PocketCalculator.multiply(2,3))
    println(PocketCalculator.division(4,0))




}
