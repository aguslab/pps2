package coverage.app;

import coverage.expressions.Expression;
import coverage.expressions.ExpressionXEqualsToY;
import coverage.expressions.ExpressionXLessThanY;

public class Function 
{
	static Function function;

    void test(int x,int y, String condition)
    {
    	Expression expression = new ExpressionXLessThanY(x, y, condition);
		if(expression.eval())
		{
			System.out.println("verdad");
		}
		else
		{
			System.out.println("falso");
		}
		
		x+=5;
		expression.setExpression(x, y, "7<6");
		
		if(expression.eval())
		{
			System.out.println("verdad");
		}
		else
		{
			System.out.println("falso");
		}
		
		Expression expression2 = new ExpressionXEqualsToY(x, y, condition);
		if(expression2.eval())
		{
			System.out.println("verdad");
		}
		else
		{
			System.out.println("falso");
		}
    }
}