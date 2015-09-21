package coverage.app;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import coverage.pathconditions.PathConditionList;
import coverage.z3.Z3;

public class Main 
{
	private static List<Map<String,Integer>> params=new ArrayList<Map<String,Integer>>();
	
	//Initializer ejecuta la funcion
    public static void main(String[] args)
    {
    	int x = 0;
    	int y = 0;
    	Map<String, Integer> primeraInvocacion=new HashMap<String, Integer>();
    	
    	primeraInvocacion.put("x", 0);
    	primeraInvocacion.put("y", 0);
    	params.add(primeraInvocacion);
    	
    	new InputFunction().test(x, y);
    	PathConditionList pcl =  PathConditionList.getInstance();
    	List<String> conditions = pcl.getList();
		System.out.println(conditions);
		
		findAlternativeInputs(conditions);
    	
		
		System.out.println(params);
    	// imprimir todos los pares de inputs que se encontraron para que la cobertura de}
		// codigo sea total
    	    	
    	
//    	Initializer init = new Initializer();
//    	PathConditionList pcl = PathConditionList.getInstance();
//    	pcl.clear();
//    	init.iniciar();
//    	System.out.println(pcl.getList());
//    	Z3 z3=new Z3();
//    	String exp="";
//    	for (String pc :pcl.getList()) {
//			exp += pc +",";
//      		
//		}
//    	exp=exp.substring(0,exp.length()-1);
//    	Map<String, Integer> result=z3.eval(exp);
//    	System.out.println(result);
    
    }

	private static void findAlternativeInputs(List<String> conditions) {
    	PathConditionList pcl =  PathConditionList.getInstance();
		Z3 z3 = new Z3();
    	int i = conditions.size()-1;
    	while (i >= 0) {
    		// negar la ultima
    		conditions.set(conditions.size()-1, negar(conditions.get(conditions.size()-1)));
    		// pedir valores de input a z3
    		Map<String, Integer> valores=z3.eval(concatenar(conditions));
    		// llamar a la funcion de agus
    		params.add(valores);
    		
    		new InputFunction().test(valores.get("x"), valores.get("y"));
        	
    		// pedis las condiciones
    		 conditions = pcl.getList();
    		findAlternativeInputs(conditions);
    		// llamar recursivamente
    		// eliminar la ultima
    		conditions.remove(conditions.size()-1);
		}
		
	}

	private static String  negar(String string) {
		return "Not("+string+")";
				
	}
	
	private static String concatenar(List<String> args){
		String exp="";
		for (String pc :args) {
			exp += pc +",";
      		
		}
    	exp=exp.substring(0,exp.length()-1);
    	return exp;
	}
}
