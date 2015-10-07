package coverage.app;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import coverage.pathconditions.PathConditionList;
import coverage.z3.NoSolutionException;
import coverage.z3.Z3;

public class Main 
{
	private static List<Map<String,Integer>> params = new ArrayList<Map<String,Integer>>();
	
	//Initializer ejecuta la funcion
    public static void main(String[] args)
    {
    	int x = 0;
    	int y = 0;
    	Map<String, Integer> primeraInvocacion=new HashMap<String, Integer>();
    	
    	primeraInvocacion.put("x", 0);
    	primeraInvocacion.put("y", 0);
    	params.add(primeraInvocacion);
    	
    	new InputFunction().test(x, y);
    	PathConditionList pcl =  PathConditionList.getInstance();
    	List<String> conditions = pcl.getList();
		System.out.println(conditions);
		
		
		findAlternativeInputs(new ArrayList<String>(), conditions);
    	
		
		System.out.println(params);
    }
    

	private static int reclevel = 0;

	public static void findAlternativeInputs(List<String> fixedConditions, List<String> variableConditions) 
	{
		reclevel++;
//		System.out.println("fijas: " + fixedConditions);
//		System.out.println("variables: " + variableConditions);
		
		PathConditionList pcl =  PathConditionList.getInstance();
		Z3 z3 = new Z3();
    	while (variableConditions.size()>0) 
    	{
    		System.out.println();
    		System.out.println("nivel recursion: " + reclevel);
    		
    		// negar la ultima
    		int lastIndex = variableConditions.size()-1;
			String lastCondition = variableConditions.get(lastIndex);
    		fixedConditions.add(negar(lastCondition));
    		variableConditions.remove(lastIndex);
    		
    		// pedir valores de input a z3
    		List<String> z3Conditions= new ArrayList<String>();
    		z3Conditions.addAll(fixedConditions);
    		z3Conditions.addAll(variableConditions);
    		
    		System.out.println("FIJAS: " + fixedConditions);
    		System.out.println("VARIABLES: " + variableConditions);
    		
    		Map<String, Integer> valores;
			try 
			{
				valores = z3.eval(concatenar(z3Conditions));
			} catch (NoSolutionException e)
			{
				continue;
			}
    		
			params.add(valores);
    		pcl.clear();
    		
    		if(valores.size() > 0)
    			new InputFunction().test(valores.get("x"), valores.get("y"));
    		
    		List<String> newExecutionConditions = pcl.getList();
    		List<String> tmp = removeConditions(newExecutionConditions, fixedConditions);
			findAlternativeInputs(fixedConditions, tmp);
			
			//Se elimina la ultima fija al volver de la recursion
			System.out.println("ANTES: " + fixedConditions);
			int i = fixedConditions.size()-1;
			fixedConditions.remove(i);
			System.out.println("DESPUES: " + fixedConditions);
    		
		}
    	
		reclevel--;
	}
 
	private static List<String> removeConditions(
			List<String> newExecutionConditions, List<String> fixedConditions) 
	{
		
		List<String> ret = new ArrayList<String>();
		for (String condition : newExecutionConditions) 
		{
			if (!fixedConditions.contains(condition))
			{
				ret.add(condition);
			}
		}
		return ret;
	}

	private static String negar(String expression) 
	{
		if(expression.startsWith("Not"))
		{
			return expression.substring(3,expression.length());
		}
		else
		{
			return "Not"+expression+"";
		}
				
	}
	
	private static String concatenar(List<String> args)
	{
		String exp="";
		for (String pathCondition :args) 
		{
			exp += pathCondition +",";
      		
		}
    	exp=exp.substring(0,exp.length()-1);
    	return exp;
	}
}
