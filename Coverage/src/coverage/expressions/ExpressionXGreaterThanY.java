package coverage.expressions;

//Esto es necesario?
//Evalua expresiones del tipo x>y
public class ExpressionXGreaterThanY implements Expression
{
	private int x,y;
	private String predicate;
	
	public ExpressionXGreaterThanY(int x, int y, String predicate)
	{
		this.x = x;
		this.y = y;
		this.predicate = predicate;
	}
	
	public boolean eval()
	{
		return this.x > this.y;
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
