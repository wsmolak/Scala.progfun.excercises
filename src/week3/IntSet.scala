package week3

/**
  * Created by wsmolak on 12/20/2016.
  */
abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

