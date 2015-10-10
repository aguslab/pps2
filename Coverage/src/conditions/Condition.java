package conditions;

public class Condition
{
	private String expression;
	private Boolean marked=false;
	
	public Condition(String expression)
	{
		this.expression = expression;
	}
	
	public void mark()
	{
		this.marked=true;
	}
	
	public boolean isMarked()
	{
		return this.marked;
	}

	@Override
	public String toString() 
	{
		return "Condition [expression=" + expression + " marked=" + marked + "]";
	}

	public String getExpression() 
	{
		return this.expression;
	}
	
}
