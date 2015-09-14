package coverage.expressions;

public class ExpressionXEqualsToY implements Expression
{
	private int x,y;
	private String predicate;
	
	public ExpressionXEqualsToY(int x, int y, String predicate)
	{
		this.x = x;
		this.y = y;
		this.predicate = predicate;
	}

	@Override
	public boolean eval() 
	{
		return this.x == this.y;
	}

	@Override
	public String getPredicate() 
	{
		return this.predicate;
	}

	@Override
	public void setExpression(int x, int y, String predicate) 
	{
		this.x = x;
		this.y = y;
		this.predicate = predicate;
	}
}
