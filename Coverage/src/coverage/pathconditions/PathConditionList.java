package coverage.pathconditions;

import java.util.ArrayList;
import java.util.List;

public class PathConditionList 
{
	
	private static PathConditionList instance = null;
	private List<String> conditionsList;
	
	private PathConditionList() 
	{ 
		this.conditionsList = new ArrayList<String>();
	}
	
	public static PathConditionList getInstance() 
	{
		if (instance == null)
			instance = new PathConditionList();
		return instance;
	}
	
	public void addCondition(String condition) 
	{
		this.conditionsList.add(condition);
	}
	
	public void clear() 
	{
		this.conditionsList.clear();
	}
	
	public List<String> getList() 
	{
		return this.conditionsList;
	}

}
