package coverage.aspects;

import coverage.expressions.Expression;
import coverage.pathconditions.PathConditionList;

/*Interferimos el metodo eval() que evalua y devuelve el resultado de una condicion, 
 * obtenemos dicho resultado, lo pasamos a boolean y vemos si es true o false
 * true: guardamos en una lista la guarda original
 * false: guardamos en una lista la guarda negada
 */

public aspect Aspect 
{
	
	Object around(): (within(coverage.expressions.*)) && execution(boolean eval()) 
    {
    	Object resultadoFuncion = proceed();
    	Expression expression = (Expression) thisJoinPoint.getThis();
    	Boolean guardaIF = Boolean.parseBoolean(resultadoFuncion.toString());
    	
    	PathConditionList pcl = PathConditionList.getInstance();
    	
    	if(guardaIF)
    		pcl.addCondition("(" + expression.getPredicate() +")"); 
    	else
    		pcl.addCondition("Not(" + expression.getPredicate() +")"); 
    	
		return resultadoFuncion;
    }
}