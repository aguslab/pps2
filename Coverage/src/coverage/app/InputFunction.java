package coverage.app;

import coverage.expressions.ExpressionXEqualsToY;

public class InputFunction 
{

    void test(int x,int y)
    {
		if(new ExpressionXEqualsToY(x, y).eval())
		{
			System.out.println("verdad");
		}
		else
		{
			System.out.println("falso");
		}
   }
}