//package exercises
//
//import lectures.part2oop.Generics.MyList
//
//abstract class MyList[+A]{
//  def head: A
//  def tail: MyList[A]
//  def isEmpty : Boolean
//  def add[B >: A](element: B): MyList[B]
//  def printElement: String
//  override def toString: String = "[" + printElement + "]"
//  def map[B](transformer: MyTransformer[A, B]): MyList[B]
//  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
//  def filter(predicate: MyPredicate[A]): MyList[A]
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
//  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = EmptyList
//  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = EmptyList
//  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = EmptyList
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
//  def filter(predicate: MyPredicate[A]): MyList[A] =
//    if (predicate.test(h)) new Cons(h, t.filter(predicate))
//    else t.filter(predicate)
//
//  def map[B](transformer: MyTransformer[A, B]): MyList[B] =
//    new Cons(transformer.transform(h), t.map(transformer))
//
//  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
//  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
//    transformer.transform(h) ++ t.flatMap(transformer)
//
//}
//
//trait MyPredicate[-T] {
//  def test(element: T) : Boolean
//}
//
//trait MyTransformer[-A, B]{
//  def transform(element:A) : B
//}
//
//
//
//object testList extends App{
//  val listOfIntegers:MyList[Int] = new Cons[Int](1, Cons(2, Cons(3, EmptyList)))
//  val anotherListOfIntegers:MyList[Int] = new Cons[Int](4, Cons(5, EmptyList))
//  val listOfStrings:MyList[String] = new Cons[String]("Hello", Cons("Scala", Cons("Zexi", EmptyList)))
//  println(listOfIntegers.printElement)
//  println(listOfStrings.printElement)
//
//  println(listOfIntegers.map(new MyTransformer[Int,Int] {
//    override def transform(element: Int): Int = element * 2
//  }).toString)
//
//  println(listOfIntegers.filter(new MyPredicate[Int] {
//    override def test(element: Int): Boolean = element % 2 == 0
//  }).toString)
//
//  println((listOfIntegers ++ anotherListOfIntegers).toString)
//  println(listOfIntegers.flatMap(new MyTransformer[Int,MyList[Int]] {
//    override def transform(element: Int): MyList[Int] = new Cons[Int](element, new Cons[Int](element+1, EmptyList))
//  }).toString)
//
//
//}