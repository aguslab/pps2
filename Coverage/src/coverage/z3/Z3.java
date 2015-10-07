package coverage.z3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Z3 
{
	private static final String NO_SOLUTION = "no solution";

	public Map<String, Integer> eval(String exp) throws NoSolutionException
	{
		exp = exp.replace(" ", "");
		String comando = "python C:/z3/z3eval.py " + exp;

		String output = executeCommand(comando);
		
		if (output.trim().equals(NO_SOLUTION)) 
		{
			throw new NoSolutionException();
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] valores = output.replace("[", "").replace("]", "").split(",");
		for (String val : valores) 
		{
			String[] clave_valor = val.split("=");
			map.put(clave_valor[0].trim(),Integer.valueOf(clave_valor[1].trim()));
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
