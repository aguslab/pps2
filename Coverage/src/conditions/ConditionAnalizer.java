package conditions;

import java.util.ArrayList;
import java.util.List;

public class ConditionAnalizer 
{
	public static List<String> getExpressions(List<Condition> conditions) 
	{
		List<String> result = new ArrayList<String>();
		for (Condition condition : conditions) 
		{
			result.add(condition.getExpression());
		}
		return result;
	}

	public List<Condition> cleanConditions(List<Condition> conditions) 
	{
		List<Condition> result = new ArrayList<Condition>();
		if (conditions.size() > 0) 
		{
			int lastIndex = conditions.size() - 1;
			while (!conditions.isEmpty()&&conditions.get(lastIndex).isMarked()) 
			{
				conditions.remove(lastIndex);
				lastIndex--;
			}
		}
		return result;
	}
	
	public List<Condition> generateConditions(
			List<Condition> condicionesPrevias, List<String> variables) 
	{
		List<Condition> result = new ArrayList<Condition>();
		for (int i = 0; i < condicionesPrevias.size(); i++) 
		{
			Condition condition = new Condition(variables.get(i));
			if (condicionesPrevias.get(i).isMarked()) 
			{
				condition.mark();
			}
			result.add(condition);

		}
		if (condicionesPrevias.size() < variables.size()) 
		{
			for (int i = condicionesPrevias.size(); i < variables.size(); i++) 
			{
				Condition condition = new Condition(variables.get(i));
				result.add(condition);

			}
		}

		return result;
	}
	
}
