package coverage.aspects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import coverage.expressions.Expression;
import coverage.expressions.ExpressionXLessThanY;

/*Interferimos el metodo eval() que evalua y devuelve el resultado de una condicion, 
 * obtenemos dicho resultado, lo pasamos a boolean y vemos si es true o false
 * true: guardamos en una lista la guarda original
 * false: guardamos en una lista la guarda negada
 */

public aspect Aspect 
{
	private String conditionPath = "";
	
	Object around():  execution(boolean eval()) 
    {
    	Object resultadoFuncion = proceed();
    	Expression expression = (Expression) thisJoinPoint.getThis();
    	Boolean guardaIF = Boolean.parseBoolean(resultadoFuncion.toString());
    	if(guardaIF)
    		this.conditionPath += expression.getPredicate() + ","; 
    	else
    		this.conditionPath += "!" + expression.getPredicate() + ","; 
    	
		return resultadoFuncion;
    }
	
	//Para darle el condition path a z3
	public String getConditionPath()
	{
		this.conditionPath = this.conditionPath.replaceFirst(".$",""); 
		return this.conditionPath;
	}
}