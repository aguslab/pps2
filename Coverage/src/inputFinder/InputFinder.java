package inputFinder;

import java.util.List;
import java.util.Map;

import conditions.Condition;
import conditions.ConditionAnalizer;
import coverage.app.InputFunction;
import coverage.pathconditions.PathConditionList;
import coverage.z3.Z3;

public class InputFinder
{
	
private static int reclevel = 0;
	public static void findAlternativeInputs(List<Map<String, Integer>> parameters, List<Condition> conditions) 
	{
		reclevel++;
		System.out.println("\nNivel recursion: " + reclevel);
		System.out.println("Condiciones: " + conditions);
		
		//Vaciamos la lista de condiciones
		ConditionAnalizer conditionAnalizer = new ConditionAnalizer();
		conditionAnalizer.cleanConditions(conditions);
		
		if (conditions.isEmpty()) 
		{
			return;
		}
		
		//Negamos la última condicion, la marcamos y la guardamos en lugar de la ultima que había
		conditions = conditionAnalizer.modifyConditionsState(conditions);

		//Pedimos los valores de input a z3
		PathConditionList pcl = PathConditionList.getInstance();
		Z3 z3 = new Z3();
		Map<String, Integer> values = z3.getValues(conditions);
		
		//Los guardamos como parte del output
		parameters.add(values);
		
		//Limpiamos pcl para ejecutar la función de nuevo y conseguimos más inputs
		pcl.clear();
		new InputFunction().test(values.get("x"), values.get("y"));
		List<String> newExecutionConditions = pcl.getList();

		findAlternativeInputs(parameters, conditionAnalizer.generateConditions(conditions,
				newExecutionConditions));

		reclevel--;
	}
}
