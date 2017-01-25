import scala.io.Source._

//val input = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")

//val input = fromFile("C:/Users/wsmolak/Documents/studia/coursera_scala/excercises/src/resources/slowa.txt","utf-8")
val input = fromFile("C:/Users/wsmolak/Documents/studia/coursera_scala/excercises/src/resources/linuxwords.txt")

val words = input.getLines.toList filter(word => word forall (chr => chr.isLetter))

val mnem = Map(
  '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
  '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ"
)

val charCode: Map[Char, Char] =
  for ((digit, str) <- mnem;
       ltr <- str) yield ltr -> digit

//charCode('G')

def wordCode(word: String): String =
  word.toUpperCase map charCode

wordCode("Wojtek")

val wordsForNum: Map[String, Seq[String]] =
  words groupBy wordCode withDefaultValue Seq()

def encode (number: String): Set[List[String]] =
  if (number.isEmpty) Set(List())
  else {
    for {
      split <- 1 to number.length
        word <- wordsForNum(number take split)
          rest <- encode(number drop split)
    } yield word :: rest
  }.toSet

encode("26965835")

def translate (number: String): Set[String] =
  encode(number) map (_ mkString " ")

translate("26965835")