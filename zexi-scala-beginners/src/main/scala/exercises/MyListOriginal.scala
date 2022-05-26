package exercises

abstract class MyList[+A]{
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElement: String
  override def toString: String = "[" + printElement + "]"
  def filter(myPredicate: MyPredicate[A]): MyList[A]
  def map[B](transformer: MyTransformer[A,B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

    def ++[B >: A](list: MyList[B]): MyList[B]
  //  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  //  def filter(predicate: MyPredicate[A]): MyList[A]

//  def
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty = true
  def add[B>:Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElement = ""

  def filter(myPredicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  def map[B >: Nothing](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  def ++[B >: Nothing ](list: MyList[B]): MyList[B] = list

//  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  //  def
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head = h
  def tail = t
  def isEmpty = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElement: String = {
    if (t.isEmpty) f"$h"
    else f"$h ${t.printElement}"
  }
  def filter(myPredicate: MyPredicate[A]): MyList[A] = {
    if (myPredicate.test(h)) new Cons(h,t.filter(myPredicate))
    else t.filter(myPredicate)
  }
  def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = {


  }

//  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty


}

trait MyPredicate[-T] {
  def test(element: T) : Boolean
}

trait MyTransformer[-A, B] {
  def transform(element: A): B
}

object testList extends App{
  val listOfIntegers = new Cons(1,Cons(2, Cons(3,Empty)))
  println(listOfIntegers.head)
  println(listOfIntegers.tail)
  println(listOfIntegers.isEmpty)
  println(listOfIntegers.printElement)
  println(listOfIntegers.toString)
  val listOfString = new Cons("1",Cons("B", Cons("D",Empty)))
  println(listOfString.head)
  println(listOfString.isEmpty)
  println(listOfString.toString)

  println(listOfIntegers.map(new MyTransformer[Int, String]{
    override def transform(element: Int): String = element.toString
  }))

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(element: Int): Boolean = {
      if (element %2 ==0) true
      else false
    }
  }))

}
//  val listOfIntegers:MyList[Int] = new Cons[Int](1, Cons(2, Cons(3, EmptyList)))
//  val anotherListOfIntegers:MyList[Int] = new Cons[Int](4, Cons(5, EmptyList))
//  val listOfStrings:MyList[String] = new Cons[String]("Hello", Cons("Scala", Cons("Zexi", EmptyList)))
//  println(listOfIntegers.printElement)
//  println(listOfStrings.printElement)
