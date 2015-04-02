object CalculatorExpression {
  def main(args: Array[String]) {
    val expr = "1+9/3+1*2"
    println(parse(0).result())

    def add(left: Float, right: Float) : Float = left + right
    def substract(left: Float, right: Float) : Float = left - right
    def div(left: Float, right: Float) : Float = left / right
    def multi(left: Float, right: Float) : Float = left * right

    def parse(index: Int): Arg = {
      for (i <- index until expr.length) {
        val operation = expr.charAt(i)
        if ('*'.equals(operation)) {
          return new Arg(new Arg(expr.substring(index, i).toFloat), parse(i + 1), multi)
        } else if ('/'.equals(operation)) {
          return new Arg(new Arg(expr.substring(index, i).toFloat), parse(i + 1), div)
        } else if ('-'.equals(operation)) {
          return new Arg(new Arg(expr.substring(index, i).toFloat), parse(i + 1), substract)
        } else if ('+'.equals(operation)) {
          return new Arg(new Arg(expr.substring(index, i).toFloat), parse(i + 1), add)
        }
      }
      new Arg(expr.substring(index, expr.length).toFloat)
    }
  }
}