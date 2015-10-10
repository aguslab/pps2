package coverage.expressions;

public class ExpressionXGreaterThanValue implements Expression 
{
	
	private int x;
	private int value;
	
	public ExpressionXGreaterThanValue(int x, int value) 
	{
		this.x = x;
		this.value = value;
	}

	@Override
	public boolean eval() 
	{
		return x > value;
	}

	@Override
	public String getPredicate() 
	{
		return "x>" + value;
	}

}
