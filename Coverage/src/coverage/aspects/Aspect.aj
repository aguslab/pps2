package coverage.aspects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import coverage.expressions.ExpressionXLessThanY;

/*Interferimos el metodo eval() que evalua y devuelve el resultado de una condicion, 
 * obtenemos dicho resultado, lo pasamos a boolean y vemos si es true o false
 * true: guardamos en una lista la guarda original
 * false: guardamos en una lista la guarda negada
 */
public aspect Aspect 
{
	private List<String> conditionPath = new ArrayList<String>();
	
	Object around():  execution(boolean eval()) 
    {
    	Object resultadoFuncion = proceed();
    	ExpressionXLessThanY expression = (ExpressionXLessThanY) thisJoinPoint.getThis();
    	Boolean guardaIF = Boolean.parseBoolean(resultadoFuncion.toString());
    	if(guardaIF)
    		this.conditionPath.add(expression.getPredicate()); 
    	else
    		this.conditionPath.add("!" + expression.getPredicate());
    	
    	/* Descomentar esto si z3 necesita usar archivos para leer el conditional path, sino borrarlo!
    	StreamReader sr = new StreamReader();
		try 
		{
			sr.guardarPrints();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
    	System.out.println(this.conditionPath);
    	sr.close();*/
		return resultadoFuncion;
    }
	
	//Para darle el condition path a z3
	public List<String> getConditionPath()
	{
		return this.conditionPath;
	}
}