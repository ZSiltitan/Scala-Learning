package lectures.part2oop

object Generics extends App {
  class MyList[+A]{
    def add[B>:A] (element: B): MyList[B] = ???

  }
  val IntList = new MyList[Int]
  val StringList = new MyList[String]

  object MyList {
    def empty[A]:MyList[A] = ???
  }

  val EmptyIntList = MyList.empty[Int]

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  class InvariantList[A]
  val InvariantanimalList: InvariantList[Animal] = new InvariantList[Animal]

  class Trainer[-A]
  val TrainerList: Trainer[Cat] = new Trainer[Animal]



}
