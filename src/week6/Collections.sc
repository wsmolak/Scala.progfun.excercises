
val xs = Array(1,2,3,11,5,6,7,8,9)

(xs map (x => x - 1)).last

val s = "Wojtek Smolak 1 2 3"
s filter (c => c.isDigit)

val r: Range = 0 to 25 by 5

r.start
r.step
r.end

val r2: Range = 1 until 100

r2.step

r zip r2

s flatMap (e => List('.',e))

r flatMap(e => e until e*2)
r reduce(_+_)
r.foldLeft(25)(_+_)


def comb(m: Int, n: Int) =
  (1 to m) flatMap (x => (1 to n) map (y=> (x,y)))

val c = comb(4,5)

def scalarProd(xs: Vector[Double], ys: Vector[Double]): Double =
  (xs zip ys).map(xy => xy._1 * xy._2).sum

def scalarProd2(xs: Vector[Double], ys: Vector[Double]): Double =
  (xs zip ys).map{case (x,y) => x *  y}.sum

//commutative
val sp = scalarProd(Vector(1,3,5),Vector(2,4,6))
val sp2 = scalarProd(Vector(2,4,6),Vector(1,3,5))

val sp3 = scalarProd2(Vector(1,3,5),Vector(2,4,6))
val sp4 = scalarProd2(Vector(2,4,6),Vector(1,3,5))

def isPrime(n: Int): Boolean = (2 until n) forall(d => n%d !=0)

isPrime(11)

val number = 7

(1 until number) flatMap (i =>
  (1 until i) map (j => (i,j))) filter(pair => isPrime(pair._1 + pair._2))

//and equivalent result produced by a bit different code:

for {
  i <- 1 until number
    j <- 1 until i
      if isPrime(i+j)
} yield (i,j)

for (p <- (1 until 12) if isPrime(p)) yield p









