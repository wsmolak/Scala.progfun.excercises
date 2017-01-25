val f: PartialFunction[String,String] = { case "ping" => "pong"}

f("ping")
f.isDefinedAt("wojtek")


val f2: PartialFunction[List[Int],String] = {
  case Nil => "one"
  case x :: y :: rest => "two"
}

f2.isDefinedAt(List(1,2,3))

val g: PartialFunction[List[Int],String] = {
  case Nil => "one"
  case x :: rest => rest match {
    case Nil => "two"
  }
}
g.isDefinedAt(List(1,2,3))
//match error even g is DefinedAt
g(List(1,2,3))






