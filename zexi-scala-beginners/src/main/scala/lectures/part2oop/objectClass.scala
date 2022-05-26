package lectures.part2oop

object objectClass extends App {
  object Person{
    val N_Eyes = 2
    def canFly():Boolean = false
    def apply(mother: Person, father: Person): Person = new Person("bobbie")
  }

  class Person(name: String){
    def printName() = println(this.name + " is the name")
  }

  val jimmy = Person
  val penny = Person
  println(jimmy == penny)

  val peter = new Person("peter")
  val mary = new Person("mary")
  peter.printName()
  val bobbie = Person.apply(peter,mary)


}
