package u02.exercises

object GCD extends App {


  def gcd(a:Int, b:Int): Int = b match
    case 0 => a
    case _ => gcd(b, a%b)

  println(gcd(14,7))
}
