class Arg(back: Arg, next: Arg, value : Float, opr: (Float, Float) => Float) {

  def this(back: Arg, next: Arg, opr: (Float, Float) => Float) = this(back, next, 0f, opr)
  def this(value : Float) = this(null, null, value, null)
  def this() = this(0f)

  def result(): Float = {
    if (back == null && next == null) {
      value
    } else {
      opr(back.result(), next.result())
    }
  }
}