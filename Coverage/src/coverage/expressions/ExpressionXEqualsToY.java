package coverage.expressions;

public class ExpressionXEqualsToY implements Expression 
{
	private int x, y;
	
	public ExpressionXEqualsToY(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean eval() 
	{
		return this.x == this.y;
	}

	@Override
	public String getPredicate() 
	{
		return "x==y";
	}

}
