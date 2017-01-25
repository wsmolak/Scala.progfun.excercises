def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => x :: Nil
  case y :: ys => if (y > x) x :: xs
    else if (y == x) xs
    else y :: insert(x, ys)
}

def isort(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case y :: ys => insert(y, isort(ys))
}

val lista: List[Int] = 5 :: 1 :: 2 :: 6 :: 3 :: 4 :: Nil

val lista2: List[Int] = isort(lista)



