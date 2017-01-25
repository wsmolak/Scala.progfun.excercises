class Poly(val terms: Map[Int,Double]){
  def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
  override def toString =
    (for ((exp,coef) <- terms.toList.sorted.reverse) yield coef+"x^"+exp) mkString "+"
  def adjust(term: (Int,Double)): (Int,Double) ={
    val (exp,coeff) = term
    terms get exp match{
      case Some(coeff1) => exp -> (coeff + coeff1)
      case None => exp -> coeff
    }
  }
}

//simpler way using withDefaultValue()
class Poly2(val terms0: Map[Int,Double]){
  def this(bindings: (Int,Double)*) = this(bindings.toMap)
  val terms = terms0 withDefaultValue(0.0)
  def + (other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))
  override def toString =
    (for ((exp,coef) <- terms.toList.sorted.reverse) yield coef+"x^"+exp) mkString "+"
  def addTerm(terms: Map[Int,Double],term: (Int,Double)): Map[Int,Double] = {
    val (exp,coeff) = term
    terms + (exp -> (coeff + terms(exp)))
  }
}

val p1 = new Poly(Map(1 -> 6.0, 3 -> 5.2, 6 -> 6.0))
val p2 = new Poly(Map(0 -> 6.0, 2 -> 5.2, 6 -> 7.2))

p1 + p2

