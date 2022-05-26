//package exercises
//
//abstract class MyList[+A]{
//  def head: A
//  def tail: MyList[A]
//  def isEmpty : Boolean
//  def add[B >: A](element: B): MyList[B]
//  def printElement: String
//  override def toString: String = "[" + printElement + "]"
//  def map[B](transformer: A => B): MyList[B]
//  def flatMap[B](transformer: Function1[A,MyList[B]]): MyList[B]
//  def filter(predicate: A => Boolean): MyList[A]
//  def ++[B >: A](list: MyList[B]): MyList[B]
//
//}
//
//object EmptyList extends MyList[Nothing] {
//  def head: Nothing = throw new NoSuchElementException
//  def tail: MyList[Nothing] = throw new NoSuchElementException
//  def isEmpty : Boolean = true
//  def add[B >: Nothing](element: B): MyList[B] = new Cons(h = element, EmptyList)
//  def printElement: String = ""
//
//  def map[B](transformer: Function1[Nothing, B]): MyList[B] = EmptyList
//  def flatMap[B](transformer: Function1[Nothing, MyList[B]]): MyList[B] = EmptyList
//  def filter(predicate: Function1[Nothing,Boolean]): MyList[Nothing] = EmptyList
//
//  def ++[B >: Nothing](list: MyList[B]) = list
//}
//
//class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
//  def head: A = h
//  def tail: MyList[A] = t
//  def isEmpty : Boolean = false
//  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
//  def printElement: String = {
//    if (t.isEmpty) "" + h
//    else s"$h ${t.printElement}"
//  }
//  def filter(predicate: Function1[A,Boolean]): MyList[A] =
//    if (predicate.apply(h)) new Cons(h, t.filter(predicate))
//    else t.filter(predicate)
//
//  def map[B](transformer: Function1[A, B]): MyList[B] =
//    new Cons(transformer.apply(h), t.map(transformer))
//
//  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
//  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
//    transformer.apply(h) ++ t.flatMap(transformer)
//
//}
//
//
//object testList extends App{
//  val listOfIntegers:MyList[Int] = new Cons[Int](1, Cons(2, Cons(3, EmptyList)))
//  val anotherListOfIntegers:MyList[Int] = new Cons[Int](4, Cons(5, EmptyList))
//  val listOfStrings:MyList[String] = new Cons[String]("Hello", Cons("Scala", Cons("Zexi", EmptyList)))
//  println(listOfIntegers.printElement)
//  println(listOfStrings.printElement)
//
//  println(listOfIntegers.map[Int]((elem: Int) => elem *2).toString)
//
//  println(listOfIntegers.filter(element =>element % 2 == 0).toString)
//
//  println((listOfIntegers ++ anotherListOfIntegers).toString)
//  //  println((listOfIntegers ++ anotherListOfIntegers).toString)
//  //  println(listOfIntegers.flatMap[Int](new Function1[Int,MyList[Int]] {
//  //    override def apply(element: Int): MyList[Int] = new Cons[Int](element, new Cons[Int](element+1, EmptyList))
//  //  }).toString)
//  println(listOfIntegers.flatMap[Int](element => new Cons[Int](element, new Cons[Int](element+1, EmptyList))).toString)
//
//
//}