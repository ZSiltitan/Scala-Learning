package lectures.part2oop

object ooBasics extends App{

  val author = new Writer("zexi","zeng",1994)
  val book = new Novel("Zexibook",2021, author)
  println(author.fullName())
  println(book.authorAge())
  println(book.isWrittenBy(author))

  val count = new Counter()
  count.inc(3).print()



  class Writer(firstName: String, lastName: String, var year: Int) {
    def fullName():String = {
      s"$firstName $lastName"
    }

  }

  class Novel(name: String, releaseYear: Int, author: Writer) {
    def authorAge(): Int = {
      this.releaseYear - this.author.year
    }

    def isWrittenBy(author: Writer): Boolean = {
      this.author == author
    }

    def copy(newReleaseYear: Int): Novel ={
      new Novel(name=this.name, releaseYear = newReleaseYear, author = this.author)
    }
  }

  class Counter(count: Int=0){

    def inc = {
      println("increasing")
      new Counter(count + 1)
    }

    def dec = {
      println("decreasing")
      new Counter(count - 1)
    }

    def inc(n: Int): Counter = {
//      println("increasing")
      if(n<=0) this
      else inc.inc(n-1)
    }

    def dec(n: Int): Counter = {
//      println("decreasing")
      if(n<=0) this
      else dec.dec(n-1)
    }

    def print() = println(count)

  }
}
