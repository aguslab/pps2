package coverage.expressions;

public class ExpressionXEqualsToValue implements Expression 
{
	private int x;
	private int value;
	
	public ExpressionXEqualsToValue(int x, int value) 
	{
		this.x = x;
		this.value = value;
	}
	
	@Override
	public boolean eval() 
	{
		return this.x == this.value;
	}
	
	@Override
	public String getPredicate() 
	{
		return "x==" + this.value;
	}

}
