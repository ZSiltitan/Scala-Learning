package lectures.part2oop


//抽象类
abstract class Person10 {
  def say = {
    println("hello")
  }
}
//普通类
class Animal10(var name: String, var age: Int) {
  def say = {
    println("hello")
  }
}

object ObjectDemo_10 extends App {
//  def main(args: Array[String]): Unit = {
//    //抽象类不能实例化，如下为错误。实例化需要通过子类进行
//    //    val p0 = new Person10
//    //抽象类的匿名子类对象
    val p1 = new Person10 {
      override def say = {
        println("hello .....")
      }
    }
    p1.say
    println(p1.getClass)

    //普通类的匿名子类对象
    val p2 = new Animal10("lisi", 12) {
      override def say = {
        println("hello...")
      }
    }
    p2.say
    println(p2.getClass)
    //普通类对象
    val p3 = new Animal10("zs", 13)
    println(p3.getClass)
//  }

}
