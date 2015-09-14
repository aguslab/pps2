package coverage.expressions;


//Evalua expresiones del tipo x>y
public class ExpressionXGreaterThanY implements Expression
{
	private int x,y;
	
	public ExpressionXGreaterThanY(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean eval()
	{
		return this.x > this.y;
	}
	
	@Override
	public String getPredicate()
	{
		return "x>y";
	}
}
