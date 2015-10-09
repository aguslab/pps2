package coverage.expressions;

import java.util.List;

public class ExpressionAnalizer 
{
	public String negateExpression(String expression) 
	{
		if(expression.startsWith("Not"))
		{
			return expression.substring(3,expression.length());
		}
		else
		{
			return "Not"+expression+"";
		}
	}

	public String concatenate(List<String> args) 
	{
		String exp = "";
		for (String pc : args) 
		{
			exp += pc + ",";

		}
		exp = exp.substring(0, exp.length() - 1);
		return exp;
	}
}
