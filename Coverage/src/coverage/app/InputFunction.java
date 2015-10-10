package coverage.app;

import coverage.expressions.ExpressionXEqualsToValue;
import coverage.expressions.ExpressionXEqualsToY;
import coverage.expressions.ExpressionXLessThanValue;
import coverage.expressions.ExpressionXLessThanY;

public class InputFunction 
{
  
    public void test(int x,int y)
    {
    	//Test 1
		/*if(new ExpressionXEqualsToY(x, y).eval())
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
		}*/
    	
    	//Test 2
    	/*if(new ExpressionXLessThanY(x, y).eval())
		{
			 System.out.println("x menor a y");
		}
		else
		{
			System.out.println("x mayor igual a y");
		}*/
    	
    	//Test 3
    	/*if(new ExpressionXLessThanY(x, y).eval())
		{
			 System.out.println("x menor a y");
			 if(new ExpressionXLessThanValue(x, 2).eval())
			 {
				 System.out.println("x menor a 2");
			 }
			 else
			 {
				 System.out.println("x mayor a 2");
			 }
		}
		else
		{
			System.out.println("x mayor igual a y");
		}*/
    	
    	//Test 4
    	if(new ExpressionXLessThanY(x, y).eval())
		{
			 System.out.println("x menor a y");
			 if(new ExpressionXLessThanValue(x, 2).eval())
			 {
				 System.out.println("x menor a 2");
			 }
			 else
			 {
				 System.out.println("x mayor a 2");
			 }
		}
		else
		{
			System.out.println("X mayor igual a Y");
			if(new ExpressionXEqualsToValue(x, 2).eval())
			{
				System.out.println("X igual a 2");
				if(new ExpressionXEqualsToY(x, y).eval())
				{
					System.out.println("X igual a Y");
				}
				else
				{
					System.out.println("X distinto de Y");
				}
			}
			else
			{
				System.out.println("X distinto de 2");
			}
		}
   }
    
}