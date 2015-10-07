package coverage.expressions;

public class MarkedExpressionDecorator implements Expression 
{
	
	private Expression expression;

	@Override
	public boolean eval() 
	{
		return this.expression.eval();
	}

	@Override
	public String getPredicate() 
	{
		return this.expression.getPredicate();
	}

}
