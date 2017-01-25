package week4

/**
  * Created by wsmolak on 11/21/2016.
  */
trait Expr
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr
case class Var(x: String) extends Expr




