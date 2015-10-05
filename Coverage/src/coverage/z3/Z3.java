package coverage.z3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Z3 {

	public Map<String, Integer> eval(String exp) {
		System.out.println("Z3: "+exp);
		
		exp = exp.replace(" ", "");
		String comando = "python /home/galles/workspace_luna/Coverage/resources/example.py "
				+ exp;

		String output = executeCommand(comando);
		System.out.println(output);
		String[] valores = output.replace("[", "").replace("]", "").split(",");
		Map<String, Integer> map = new HashMap<String, Integer>();

		
			for (String val : valores) {
				String[] clave_valor = val.split("=");
				map.put(clave_valor[0].trim(),
						Integer.valueOf(clave_valor[1].trim()));
			}
		
		return map;
	}

	private String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}
}
