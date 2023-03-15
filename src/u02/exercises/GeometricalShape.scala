package u02.exercises
import scala.math.{Pi, abs}

object GeometricalShape extends App {

  enum Shape:
    case Rectangle(b: Double, h:Double)
    case Circle(r: Double)
    case Square(l: Double)


  def perimeter(shape: Shape): Double = shape match
    case Shape.Rectangle(b,h) => 2*(b+h)
    case Shape.Circle(r) => 2 * Pi * r
    case Shape.Square(l) => 4 * l

  def contains(shape: Shape, point: (Double, Double)): Boolean = shape match
    case Shape.Rectangle(b,h) => point._1 >= 0 && point._1 <= h && point._2 >= 0 && point._2 <= b
    case Shape.Circle(r) => abs(point._1) <= r && abs(point._2) <= r
    case Shape.Square(l) => point._1 >= 0 && point._1 <= l && point._2 >= 0 && point._2 <= l

  println(perimeter(Shape.Rectangle(3,4)))
  println(perimeter(Shape.Circle(3)))
  println(perimeter(Shape.Square(4)))


  println(contains(Shape.Circle(3), (4,3)))
  println(contains(Shape.Circle(3), (1,2)))

}
