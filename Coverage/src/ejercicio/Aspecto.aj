package ejercicio;

public aspect Aspecto 
{
	private String conditionPath = "";
	Object around():  execution(boolean eval()) 
    {
    	Object resultadoFuncion = proceed();
    	Expression expression = (Expression) thisJoinPoint.getThis();
    	Boolean guardaIF = Boolean.parseBoolean(resultadoFuncion.toString());
    	
    	if(guardaIF)
    		this.conditionPath += expression.getPredicate() + " "; 
    	else
    		this.conditionPath += "!" + expression.getPredicate() + " ";
    	
    	System.out.println(this.conditionPath);
    	
		return resultadoFuncion;
    }
}