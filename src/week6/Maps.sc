val RomanNumbers = Map('I' -> 1, 'V' -> 5, 'X' -> 10,
  'L' -> 50, 'C' -> 100, 'D' -> 500,'M' -> 1000)

val Capitals = Map("US" -> "Washington", "Poland" -> "Warsaw") withDefaultValue("unknown")

RomanNumbers('X')
Capitals get "Germany"
Capitals("Germany")
Capitals get "Poland"

def showCapital(country: String) = Capitals.get(country) match {
  case Some(capital) => capital
  case None => "Missing data"
}

showCapital("Germany")
showCapital("Poland")

val fruit = List("peach","apple","pinapple","banana","mango","plum")
fruit sortWith((_.length < _.length))
fruit sorted

fruit groupBy(_.length)