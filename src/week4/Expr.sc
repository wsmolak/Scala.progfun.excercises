import week4._

object test {
  def eval(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
    case Prod(e1, e2) => eval(e1) * eval(e2)
  }
  def show (e: Expr): String = e match {
    case Number(m) => m.toString
    case Sum(l,r) => show(l) + " + " + show(r)
    case Var(x) => x
    case Prod(l,r) => "( " + show(l) + " )" + " * " + show(r)

  }

//  val w: Int = Sum(Number(2),Number(5)).eval
  val x:Int = eval(Sum(Sum(Number(2),Number(18)),Number(5)))
  val y:Int = eval(Prod(Number(2), Sum(Sum(Number(2),Number(14)),Number(3))))
  val s: String = show(Sum(Sum(Number(2),Number(15)),Var("x")))
  val p: String = show(Sum(Prod(Number(3),Var("n")),Prod(Number(2),Number(5))))
  val d: String = show(Prod(Sum(Number(2), Var("x")), Var("y")))
  val a: String = show(Sum(Prod(Number(2), Var("x")), Var("y")))
  val b: String = show(Prod(Number(2),Number(15)))
}