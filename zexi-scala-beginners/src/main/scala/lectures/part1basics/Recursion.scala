package lectures.part1basics

import scala.Int
import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App {
//  @tailrec
//  def concatenateTailsec(s: String, n: Int, accmulator: String): String= {
//
//    if(n<=0) accmulator // 初始值
//    else concatenateTailsec(s, n-1, s+accmulator) // s: 参数
//
//  }
//  println(concatenateTailsec("hello", 0, ""))
//    def isPrimeTailsec(x: Int): Boolean = {
//      @tailrec
//      def isPrimeHelper(t: Int, accumulator: Boolean): Boolean = {
////        if (!accumulator) false
////        else
//          if (t<=1) accumulator
//        else {
//            println("t value is "+ t)
////            println("t-1 value is "+ t-1)
//            println(x % t)
//            println((x % t != 0) && accumulator)
//            isPrimeHelper(t - 1, (x % t != 0) && accumulator)
//          }
//      }
//      isPrimeHelper(x/2, true)
//    }
//    println(isPrimeTailsec(25))

    def fibonacciFunc(n: Int): Int = {
      def fiboTailRec(i:Int, last: Int, secLast: Int): Int = {
        if (i>=n) last
        else fiboTailRec(i+1,last +secLast, last)
      }
      fiboTailRec(2,1,1)
    }
    println(fibonacciFunc(3))



}
