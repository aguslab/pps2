package coverage.mock;

import java.util.List;

//Simula el z3
public class Z3mock 
{
	private String conditionPath;
	
	public Z3mock(){}
	
	public void getConditionPath(String conditionPath)
	{
		this.conditionPath = conditionPath;
	}
	
	public void mostrarConditionPath()
	{
		System.out.println("Condition Path para pasar a z3: " + this.conditionPath);
	}
	
}
