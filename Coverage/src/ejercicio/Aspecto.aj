package ejercicio;

import java.util.ArrayList;
import java.util.List;

public aspect Aspecto 
{
	private List<String> conditionPath = new ArrayList<String>();
	Object around():  execution(boolean eval()) 
    {
    	Object resultadoFuncion = proceed();
    	Expression expression = (Expression) thisJoinPoint.getThis();
    	Boolean guardaIF = Boolean.parseBoolean(resultadoFuncion.toString());
    	
    	if(guardaIF)
    		this.conditionPath.add(expression.getPredicate()); 
    	else
    		this.conditionPath.add("!" + expression.getPredicate());
    
		return this.conditionPath;
    }
}