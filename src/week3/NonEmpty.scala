package week3

/**
  * Created by wsmolak on 12/20/2016.
  */
class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  override def contains(x: Int): Boolean =
    if (x > elem) right contains x
    else if (x < elem) left contains x
    else true
  override def incl(x: Int): IntSet =
    if (x > elem) new NonEmpty(elem, left, right incl x)
    else if (x < elem) new NonEmpty(elem, left incl x, right)
    else this
  override def toString = "{" + left + elem + right + "}"

  override def union(other: IntSet): IntSet =
    ((left union right) union other) incl elem
}
