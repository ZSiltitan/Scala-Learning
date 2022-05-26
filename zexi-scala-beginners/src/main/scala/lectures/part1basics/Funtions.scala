package lectures.part1basics

object Funtions extends App {

//  def greetingFunc(name: String, number: Int) : String = {
//    "My name is " + name + " and I'm " + number + " years old"
//  }
//  println(greetingFunc("zexi",22))

//  def factorialFunc(n: Int): BigInt = {
//    if(n<=1) 1
//    else n * factorialFunc(n-1)
//  }
//  println(factorialFunc(4))

//  def fibonacciFunc(n: Int): Int = {
//    if(n<=1) 1
//    else fibonacciFunc(n-1) + fibonacciFunc(n-2)
//  }
//  println(fibonacciFunc(4))

  def isPrimeFunc(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t<=1) true
      else n % t != 0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(n/2)
  }
  println(isPrimeFunc(5))

}
