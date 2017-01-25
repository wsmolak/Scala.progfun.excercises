package weeek1_b

/**
  * Created by wsmolak on 1/25/2017.
  */
trait Tree

case class Inner(left: Tree, right: Tree) extends Tree
case class Leaf(x: Int) extends Tree