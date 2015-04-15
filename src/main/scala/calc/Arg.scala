package calc

/**
 * Argument.
 * @param back previoues argument.
 * @param next next arg.
 * @param value value.
 * @param operation operation.
 * @param arth string equvalent of operation.
 */
case class Arg(back: Arg, next: Arg, value : Float, operation: (Float, Float) => Float, arth : Char) {
  def this(back: Arg, next: Arg, opr: (Float, Float) => Float, name : Char) = this(back, next, 0f, opr, name)
  def this(value : Float) = this(null, null, value, null, 'n')

  /**
   * Calculate result.
   * @return value.
   */
  def result(): Float = {
    if (back == null && next == null) {
      value
    } else {
      operation(back.result(), next.result())
    }
  }

  /**
   * Check if operation has possion correctly.
   * @param c operation.
   * @return true if correctly.
   */
  def correctly(c: Char): Boolean = {
    arth.equals('n') || arth == '*' || (arth == '/' && (c == '-' || c == '+') || (c == '-' && c == '+'))
  }
}