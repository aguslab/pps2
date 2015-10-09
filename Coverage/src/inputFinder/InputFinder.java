package inputFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import conditions.Condition;
import conditions.ConditionAnalizer;
import coverage.app.InputFunction;
import coverage.expressions.ExpressionAnalizer;
import coverage.pathconditions.PathConditionList;
import coverage.z3.NoSolutionException;
import coverage.z3.Z3;

public class InputFinder
{
	
private static int reclevel = 0;
	public static void findAlternativeInputs(List<Map<String, Integer>> parameters, List<Condition> conditions) 
	{
		reclevel++;
		System.out.println();
		System.out.println("Nivel recursion: " + reclevel);
		System.out.println("Condiciones: " + conditions);
		
		ConditionAnalizer conditionAnalizer = new ConditionAnalizer();
		conditionAnalizer.cleanConditions(conditions);
		
		if (conditions.isEmpty()) 
		{
			return;
		}
		
		PathConditionList pcl = PathConditionList.getInstance();
		Z3 z3 = new Z3();
		ExpressionAnalizer expressionAnalizer = new ExpressionAnalizer();
		
		int lastIndex = conditions.size() - 1;
		String lastCondition = conditions.get(lastIndex).getExpression();
		Condition condition = new Condition(expressionAnalizer.negateExpression(lastCondition));
		condition.mark();
		conditions.remove(lastIndex);
		conditions.add(condition);


		// pedir valores de input a z3
		List<String> z3Conditions = new ArrayList<String>();
		z3Conditions.addAll(ConditionAnalizer.getExpressions(conditions));

		Map<String, Integer> values = null;
		try 
		{
			values = z3.eval(expressionAnalizer.concatenate(z3Conditions));
		} 
		catch (NoSolutionException e)
		{
			e.printStackTrace();
		}

		parameters.add(values);
		pcl.clear();
		new InputFunction().test(values.get("x"), values.get("y"));
		List<String> newExecutionConditions = pcl.getList();

		findAlternativeInputs(parameters, conditionAnalizer.generateConditions(conditions,
				newExecutionConditions));

		reclevel--;
	}
}
