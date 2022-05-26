package lectures.part2oop

object Inheritance extends App {
  class Animal(name: String){
    def eat = println("num num")
    final def callname = println("the name is "+ this.name)
  }

  class cat(name:String) extends Animal(name){
    def speak = println("meow")
  }

  class dog(name:String) extends Animal(name){
    def speak = println("bark")
    override def eat = println("chum chum")


  }

  val cat = new cat("Timmy")

  val dog = new dog("jack")
  dog.speak
  dog.eat
  dog.callname


}
