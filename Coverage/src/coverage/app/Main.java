package coverage.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import conditions.Condition;
import coverage.pathconditions.PathConditionList;
import inputFinder.InputFinder;

public class Main {
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

		List<Condition> conditions = new ArrayList<Condition>();
		for (String string : expressions) 
		{
			Condition condition = new Condition(string);
			conditions.add(condition);
		}
		
		InputFinder.findAlternativeInputs(parameters, conditions);

		System.out.println("OUTPUT: " + parameters);
	}
}
