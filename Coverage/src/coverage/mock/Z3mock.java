package coverage.mock;

import java.util.List;

//Simula el z3
public class Z3mock 
{
	private List<String>conditionPath;
	
	public Z3mock(){}
	
	public void getConditionPath(List<String> conditionPath)
	{
		this.conditionPath = conditionPath;
	}
	
	public void mostrarConditionPath()
	{
		System.out.println("Condition Path para pasar a z3: " + this.conditionPath);
	}
	
}
