package coverage.z3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Z3 
{

	public Map<String, Integer> eval(String exp) 
	{
		exp = exp.replace(" ", "");
		String comando = "python ";
		String path = "C:/z3/z3eval.py ";

		String output = executeCommand(comando, path, exp);
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		if(!output.isEmpty())
		{
			String[] valores = output.replace("[", "").replace("]", "").split(",");
			for (String val : valores) 
			{
				String[] clave_valor = val.split("=");
				map.put(clave_valor[0].trim(),Integer.valueOf(clave_valor[1].trim()));
			}	
		}
		
		return map;
	}
		
	private String executeCommand(String command, String path, String exp) 
	{
		StringBuffer output = new StringBuffer();
		String[] cmd = new String[2];
		cmd[0]= command;
		cmd[1]= path + exp;
		Process p;
		try 
		{
			p = Runtime.getRuntime().exec(cmd);
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
