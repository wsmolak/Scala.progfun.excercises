package week3

/**
  * Created by wsmolak on 12/20/2016.
  */
object Empty extends IntSet{
  override def contains(x: Int): Boolean = false
  override def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  override def toString = "."
  override def union(other: IntSet): IntSet = other
}
