package coverage.app;

import coverage.expressions.ExpressionXEqualsToY;
import coverage.expressions.ExpressionXGreaterThanY;

public class InputFunction 
{

    void test(int x,int y)
    {
		if(new ExpressionXEqualsToY(x, y).eval())
		{
			 System.out.println("son iguales");
		}
		else
		{
			System.out.println("son distintos");
			if (new ExpressionXGreaterThanY(x, y).eval()) {
				System.out.println("x mayor que y");
			}
			else {
				System.out.println("x menor que y");
			}
		}
   }
}