import weeek1_b.Generator

val integers = new Generator[Int] {
  val rand = new java.util.Random
  def generate = rand.nextInt()
}

//integers.generate

val pairs = new Generator[(Int,Int)] {
  def generate = (integers.generate,integers.generate)
}

//pairs.generate

val booleans = for (x <- integers) yield x>0

//booleans.generate

def single[T](x: T): Generator[T] = new Generator[T] {
  def generate = x
}

def choose (lo: Int, hi: Int): Generator[Int] =
  for (x <- integers) yield lo + x % (hi - lo)

def oneOf[T](xs: T*): Generator[T] =
  for (idx <- choose(0,xs.length)) yield xs(idx)

//oneOf("dupa", "zbita", "Wojtek", "tratatatt").generate

def lists: Generator[List[Int]] = for {
  isEmpty <- booleans
  list <- if (isEmpty) emptyList else nonEmptyList
} yield list

def nonEmptyList = for {
  head <- integers
  tail <- lists
} yield head :: tail

def emptyList = single(Nil)

lists.generate








