package coverage.expressions;


//Evalua expresiones del tipo x<y
public class ExpressionXLessThanY implements Expression
{
	private int x,y;
	private String predicate;
	
	public ExpressionXLessThanY(int x, int y, String predicate)
	{
		this.x = x;
		this.y = y;
		this.predicate = predicate;
	}
	
	public boolean eval()
	{
		return this.x < this.y;
	}
	
	public String getPredicate()
	{
		return this.predicate;
	}
	
	public void setExpression(int x, int y, String predicate)
	{
		this.x = x;
		this.y = y;
		this.predicate = predicate;
	}
}
