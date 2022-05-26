//package exercises
//
//abstract class MyListGeneric[+A]{
//  def head: A
//  def tail: MyListGeneric[A]
//  def isEmpty : Boolean
//  def add[B >: A](element: B): MyListGeneric[B]
//  def printElement: String
//  override def toString: String = "[" + printElement + "]"
//}
//
//object EmptyListGeneric extends MyListGeneric[Nothing] {
//  def head: Nothing = throw new NoSuchElementException
//  def tail: MyListGeneric[Nothing] = throw new NoSuchElementException
//  def isEmpty : Boolean = true
//  def add[B >: Nothing](element: B): MyListGeneric[B] = new ConsGeneric(h = element, EmptyListGeneric)
//  def printElement: String = ""
//}
//
//class ConsGeneric[+A](h: A, t: MyListGeneric[A]) extends MyListGeneric[A] {
//  def head: A = h
//  def tail: MyListGeneric[A] = t
//  def isEmpty : Boolean = false
//  def add[B >: A](element: B): MyListGeneric[B] = new ConsGeneric(element, this)
//  def printElement: String = {
//    if (t.isEmpty) "" + h
//    else s"$h ${t.printElement}"
//  }
//}
//
//object testListGeneric extends App{
//  val listOfIntegers:MyListGeneric[Int] = new ConsGeneric[Int](1, ConsGeneric(2, ConsGeneric(3, EmptyListGeneric)))
//  val listOfStrings:MyListGeneric[String] = new ConsGeneric[String]("Hello", ConsGeneric("Scala", ConsGeneric("Zexi", EmptyListGeneric)))
//  println(listOfIntegers.printElement)
//  println(listOfStrings.printElement)
//
//}