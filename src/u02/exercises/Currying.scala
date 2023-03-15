package u02.exercises

object Currying extends App {


  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  val p2: (Int, Int, Int) => Boolean = (x,y,z) => x <= y && y == z
  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z

  def compose[X](f: X => X, g: X => X): (X => X) = x => f(g(x))
  println(compose[Int](_ -1, _ * 2)(5))

}
