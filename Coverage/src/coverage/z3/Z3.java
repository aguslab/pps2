package coverage.z3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Z3 
{
	private static final String NO_SOLUTION = "no solution";

	public Map<String, Integer> eval(String expression) throws NoSolutionException
	{
		System.out.println("Z3 recibe: "+expression);
		
		expression = expression.replace(" ", "");
		String command = "python C:/z3/z3eval.py " + expression;

		String output = executeCommand(command);
		
		if (output.trim().equals(NO_SOLUTION)) 
		{
			throw new NoSolutionException();
		}
		
		String[] values = output.replace("[", "").replace("]", "").split(",");
		System.out.println("z3:" + Arrays.toString(values));

		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (String val : values) 
		{
			String[] key_value = val.split("=");
			map.put(key_value[0].trim(),Integer.valueOf(key_value[1].trim()));
		}	
		
		return map;
	}
		
	private String executeCommand(String command) 
	{
		StringBuffer output = new StringBuffer();
		
		Process p;
		try 
		{
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) 
			{
				output.append(line + "\n");
			}

		} 
		catch (IOException  e) 
		{			
			System.out.println (e);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}

		return output.toString();

	}
}
