package coverage.app;

import coverage.expressions.ExpressionXLessThanY;

public class Function 
{
	static Function function;

    void test(int x,int y, String condition)
    {
    	ExpressionXLessThanY expression = new ExpressionXLessThanY(x, y, condition);
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
    }
}