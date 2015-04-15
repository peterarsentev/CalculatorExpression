package calc

/**
 * Class analizyes expression like "8+3/1-2"
 * @param text expression.
 */
class CalculatorExpression(text : String) {

  private def add(left: Float, right: Float) : Float = left + right
  private def substract(left: Float, right: Float) : Float = left - right
  private def div(left: Float, right: Float) : Float = left / right
  private def multi(left: Float, right: Float) : Float = left * right

  private def parse(expression: String, index: Int): Arg = {
    for (i <- index until expression.length) {
      val operation = expression.charAt(i)
      if ('*'.equals(operation)) {
        return calculate(expression, operation, index, i, multi)
      } else if ('/'.equals(operation)) {
        return calculate(expression, operation, index, i, div)
      } else if ('-'.equals(operation)) {
        return calculate(expression, operation, index, i, substract)
      } else if ('+'.equals(operation)) {
        return calculate(expression, operation, index, i, add)
      }
    }
    new Arg(expression.substring(index, expression.length).toFloat)
  }

  private def calculate(expression : String, operation : Char, start : Int, position : Int, opr: (Float, Float) => Float) : Arg = {
    val next = parse(expression, position+1)
    if (next.correctly(operation)) {
      new Arg(new Arg(expression.substring(start, position).toFloat), next, opr, operation)
    } else {
      new Arg(
        new Arg(new Arg(expression.substring(start, position).toFloat), next.back, opr, operation), next.next, next.operation, next.arth)
    }
  }

  def result() : Float = {
      parse(text, 0).result()
  }
}