package coverage.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import conditions.Condition;
import conditions.ConditionAnalizer;
import coverage.pathconditions.PathConditionList;
import inputFinder.InputFinder;

public class Main 
{
	private static List<Map<String, Integer>> parameters = new ArrayList<Map<String, Integer>>();

	public static void main(String[] args) 
	{

		int x = 0;
		int y = 0;
		Map<String, Integer> firstInvocation = new HashMap<String, Integer>();
		firstInvocation.put("x", 0);
		firstInvocation.put("y", 0);

		parameters.add(firstInvocation);
		
		new InputFunction().test(x, y);

		
		PathConditionList pcl = PathConditionList.getInstance();
		List<String> expressions = pcl.getList();
		ConditionAnalizer conditionAnalizer = new ConditionAnalizer();
		List<Condition> conditions = conditionAnalizer.getConditions(expressions);
		
		InputFinder.findAlternativeInputs(parameters, conditions);

		System.out.println("OUTPUT: " + parameters);
	}
}
