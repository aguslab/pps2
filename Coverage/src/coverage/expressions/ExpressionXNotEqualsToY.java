package coverage.expressions;

public class ExpressionXNotEqualsToY implements Expression
{
	private int x, y;
	
	public ExpressionXNotEqualsToY(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean eval() 
	{
		return this.x != this.y;
	}

	@Override
	public String getPredicate() 
	{
		return "x!=y";
	}

}
