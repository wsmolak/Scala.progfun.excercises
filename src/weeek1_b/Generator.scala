package weeek1_b

/**
  * Created by wsmolak on 1/25/2017.
  */
trait Generator[+T] {
  self => //an alias for this
  def generate: T
  def map[S](f: T => S): Generator[S] = new Generator[S] {
    def generate = f(self.generate)
  }
  def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
    def generate = f(self.generate).generate
  }
}
