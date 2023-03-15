package u02.exercises

object OptionExtension extends App{

  enum Option[A]:
    case Some(a: A)
    case None()

  object Option:

    //def filter(x: Int)(pred: Int => Boolean): Boolean = pred(x)

    def filter[A](x: Option[A])(pred: A => Boolean): Option[A] = x match
      case Option.Some(a) => pred(a) match
        case true => Option.Some(a)
        case false => Option.None()
      case Option.None() => Option.None()

    def map[A,B](x: Option[A])(mapp: A => B): Option[B] = x match
      case Option.Some(a) => Option.Some(mapp(a))
      case Option.None() => Option.None()

    def fold[A](x: Option[A])(d: A)(mapp: A => A): A = x match
      case Option.Some(a) => mapp(a)
      case Option.None() => d



  println(Option.filter[Int](Option.Some(5))(_ > 2)) // Some(5)
  println(Option.filter[Int](Option.Some(5))(_ > 8)) // None
  println(Option.filter[Int](Option.None[Int]())(_ > 2)) // None


  /*
  println(Option.map(Option.Some(5))(_ > 2)) // Some(5)
  println(Option.map(Option.Some(5))(_ > 8)) // None
  println(Option.map(Option.None[Int]())(_ > 2)) // None
  println(Option.map(Option.Some(4))(_ + 10))
  */

  /*
  println(Option.fold(Option.Some(5))(1)(_ + 1)) // 6
  println(Option.fold(Option.None[Int]())(1)(_ + 1)) // 1
  */


}
