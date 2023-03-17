package u02.exercises

import scala.math.{Pi, abs}

object LabTasks extends App{

  //Task 2a, svolto da solo

  val posFun: Int => String = _ match
    case n if n >= 0 => "positive"
    case _ => "negative"

  def posMeth(x: Int): String = x match
    case x if x >= 0 => "positive"
    case _ => "negative"

  /*
  println(posFun(4))
  println(posFun(-4))

  println(posMeth(4))
  println(posMeth(-4))
  */

  def neg[X](p: X => Boolean): (X => Boolean) = !p(_)

  /*
  println(neg(_ == "")("Hello"))
  */

  //------------------------------------

  //Task 2b, svolto da solo

  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z
  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z


  def compose[X](f: X => X, g: X => X): (X => X) = x => f(g(x))
  /*
  println(compose[Int](_ - 1, _ * 2)(5))
  */

  //------------------------------------

  //Task 3, svolto da solo

  def gcd(a: Int, b: Int): Int = b match
    case 0 => a
    case _ => gcd(b, a % b)

  /*
  println(gcd(14, 7))
  */

  //----------------------------------------

  //Task 4, svolto da solo

  enum Shape:
    case Rectangle(b: Double, h: Double)
    case Circle(r: Double)
    case Square(l: Double)


  def perimeter(shape: Shape): Double = shape match
    case Shape.Rectangle(b, h) => 2 * (b + h)
    case Shape.Circle(r) => 2 * Pi * r
    case Shape.Square(l) => 4 * l

  def contains(shape: Shape, point: (Double, Double)): Boolean = shape match
    case Shape.Rectangle(b, h) => point._1 >= 0 && point._1 <= h && point._2 >= 0 && point._2 <= b
    case Shape.Circle(r) => abs(point._1) <= r && abs(point._2) <= r
    case Shape.Square(l) => point._1 >= 0 && point._1 <= l && point._2 >= 0 && point._2 <= l


  /*
  println(perimeter(Shape.Rectangle(3, 4)))
  println(perimeter(Shape.Circle(3)))
  println(perimeter(Shape.Square(4)))


  println(contains(Shape.Circle(3), (4, 3)))
  println(contains(Shape.Rectangle(3,2), (1, 2)))
  */

  //-------------------------------------------------------------

  //Task 5, svolto da solo

  enum Option[A]:
    case Some(a: A)
    case None()

  object Option:

    def filter[A](x: Option[A])(pred: A => Boolean): Option[A] = x match
      case Option.Some(a) => pred(a) match
        case true => Option.Some(a)
        case false => Option.None()
      case Option.None() => Option.None()

    def map[A, B](x: Option[A])(mapp: A => B): Option[B] = x match
      case Option.Some(a) => Option.Some(mapp(a))
      case Option.None() => Option.None()

    def fold[A](x: Option[A])(d: A)(mapp: A => A): A = x match
      case Option.Some(a) => mapp(a)
      case Option.None() => d


  /*
  println(Option.filter(Option.Some(5))(_ > 2)) // Some(5)
  println(Option.filter(Option.Some(5))(_ > 8)) // None
  println(Option.filter(Option.None[Int]())(_ > 2)) // None


  println(Option.map(Option.Some(5))(_ > 2)) // Some(5)
  println(Option.map(Option.Some(5))(_ > 8)) // None
  println(Option.map(Option.None[Int]())(_ > 2)) // None
  println(Option.map(Option.Some(4))(_ + 10))


  println(Option.fold(Option.Some(5))(1)(_ + 1)) // 6
  println(Option.fold(Option.None())(1)(_ + 1)) // 1
  */
}
