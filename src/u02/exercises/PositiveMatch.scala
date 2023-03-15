package u02.exercises

object PositiveMatch extends App {

  /*
  val x: Int => String = _ match
        case n if n >= 0 => "positive"
        case _ => "negative"
   */

  /*
  def positive(x : Int) : String = x match
      case x if x >= 0 => "positive"
      case _ => "negative"


  println(positive(4));
  println(positive(-4))
  */

  //val neg: (String => Boolean) => (String => Boolean) = p => !p(_)

  def neg[X](p: X => Boolean): (X => Boolean) = !p(_)

  println(neg(_ == "")("Ciao"))


}
