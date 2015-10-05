package coverage.app;

import coverage.expressions.ExpressionXEqualsToY;
import coverage.expressions.ExpressionXGreaterThanValue;
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
			if (new ExpressionXGreaterThanY(x, y).eval()) 
			{
				System.out.println("x mayor que y");
				if (new ExpressionXGreaterThanValue(x, 10).eval())
				{
					System.out.println("x mayor que 10");
					
				}
				else
				{
					System.out.println("x menor que 10");
				}
				
			}
			else
			{
				System.out.println("x menor que y");
				if (new ExpressionXGreaterThanValue(x,5).eval())
				{
					System.out.println("x es mayor que 5");
				} 
				else 
				{
					System.out.println("x es menor que 5");
				}
				
			}
		}
   }
    
}