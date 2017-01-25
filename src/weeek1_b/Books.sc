case class Book(title: String, authors: List[String])

val books: List[Book] = List(
  Book("20 tysiecy mil podwodnej zeglugi",
    List("Verne, Julius")),
  Book("Programming in Scala",
    List("Odersky, Martin","Spoon, Lex","Venners, Bill")),
  Book("Java Puzzlers",
    List("Bloch, Joshua","Gafter, Neal")),
  Book("Effective in Java",
    List("Bloch, Joshua")),
  Book("Intro to Func Programming",
    List("Bird, Richard", "Walder, Phil")),
  Book("Effective in Java II",
    List("Bloch, Joshua"))
)

for (b <- books; a <- b.authors if a startsWith("Bloch"))
  yield b.title

for (b <- books if b.authors.length ==1)
  yield b.title

{
  for {
    b1 <- books
    b2 <- books
    if b1.title < b2.title
    a1 <- b1.authors
    a2 <- b2.authors
    if a1 == a2
  } yield a1
}.distinct

books.flatMap(a =>
  a.authors.withFilter(n => n.startsWith("Bird"))
    .map(y => a.title))



