def squareList(xs: List[Int]): List[Int] =
  xs match {
    case Nil => xs
    case y :: ys => y * y :: squareList(ys)
  }

def squareList2(xs: List[Int]): List[Int] =
  xs map (x => x * x)


val b = List(1,2,3,4,5,6,7)
val c = squareList(b)
val d = squareList2(b)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val (first,rest) = xs span(y => y == x)
    first :: pack(rest)
}

pack(List("a", "a", "a", "b", "c", "c", "a"))

def encode[T](xs: List[T]): List[(T,Int)] = {
  pack(xs) map (l => (l.head,l.length))
}
encode(List("a", "a", "a", "b", "c", "c", "a"))

def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]())( f(_) :: _ )

val f = mapFun[Int,Int](b,x => x-x)

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)( (x,y) => y+1 )

val g = lengthFun(List("a", "a", "a", "b", "wer23", "c", "c", "a", "sd"))