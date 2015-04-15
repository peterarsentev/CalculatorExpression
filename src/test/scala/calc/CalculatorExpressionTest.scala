package calc

import collection.mutable.Stack
import org.scalatest._

/**
 * Test for calculator expression.
 * @author parsentev 
 * @since 15.04.2015
 */
class CalculatorExpressionTest extends FlatSpec with Matchers {

  "Calculate" should "check the expression" in {
    new CalculatorExpression("2+2").result() should be (4)
    new CalculatorExpression("2-2").result() should be (0)
    new CalculatorExpression("2*2").result() should be (4)
    new CalculatorExpression("2/2").result() should be (1)
  }
}
