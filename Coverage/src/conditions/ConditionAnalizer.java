package conditions;

import java.util.ArrayList;
import java.util.List;

public class ConditionAnalizer 
{
	public List<String> getExpressions(List<Condition> conditions) 
	{
		List<String> result = new ArrayList<String>();
		for (Condition condition : conditions) 
		{
			result.add(condition.getExpression());
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
	
	public List<Condition> getConditions(List<String> expressions)
	{
		List<Condition> conditions = new ArrayList<Condition>();
		for (String string : expressions) 
		{
			Condition condition = new Condition(string);
			conditions.add(condition);
		}
		return conditions;
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
	
	public List<Condition> modifyConditionsState(List<Condition> conditions)
	{
		int lastIndex = conditions.size() - 1;
		String lastCondition = conditions.get(lastIndex).getExpression();
		Condition condition = new Condition(this.negateCondition(lastCondition));
		condition.mark();
		conditions.remove(lastIndex);
		conditions.add(condition);
		
		return conditions;
	}
	
	public String negateCondition(String condition) 
	{
		if(condition.startsWith("Not"))
		{
			return condition.substring(3,condition.length());
		}
		else
		{
			return "Not"+condition+"";
		}
	}

	public String concatenate(List<String> args) 
	{
		String exp = "";
		for (String pc : args) 
		{
			exp += pc + ",";

		}
		exp = exp.substring(0, exp.length() - 1);
		return exp;
	}
}
