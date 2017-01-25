import week3.{IntSet, NonEmpty, Empty}

object intsets{
  val zbior = new NonEmpty(3, Empty, Empty)
  val zbior2 = zbior incl 5
  zbior contains 5
  val zbior3 = zbior2 incl 17
  val zbior4 = new NonEmpty(7, Empty, Empty)
  val zbior5 = zbior4 incl 8 incl 10 incl 21

  val zbiorDuzy = zbior5 union zbior3

  val nowy = Empty incl 6

  nowy.getClass

  Empty.getClass

  if (true) 1 else 3.8

}