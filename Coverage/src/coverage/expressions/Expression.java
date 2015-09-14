package coverage.expressions;

public interface Expression
{
	public boolean eval();
	public String getPredicate();
	public void setExpression(int x, int y, String predicate);
}
