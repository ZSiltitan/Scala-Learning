package lectures.part2oop

object syntaxSugar extends App {
  class Person(val name: String, favorateMovie: String, var age: Int = 18){
    def +(person: Person): String = s"${this.name} is hanging out with "
    def +(job: String): Person = new Person(s"${this.name} (${job})", this.favorateMovie)

    def unary_! : String = s"$name, what the heck?"

    def unary_+ : Person = new Person(this.name, this.favorateMovie,this.age+1)

    def learns(subject: String): String = s"Mary learns $subject"
    def learnsScala(): String = this.learns("Scala")

    def apply() : String = s"Hi, my name is $name and I like $favorateMovie"
    def apply(times: Int) : String = s"Mary watched Inception $times times"

  }

  var Mary:Person = new Person("mary","lanbo", 23)
  println(!Mary)
  println(Mary())
  println((Mary+"rockstar")())
  println((+Mary).age)
  println(Mary.learnsScala())
  println(Mary(3))

}
