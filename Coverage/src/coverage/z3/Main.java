package coverage.z3;
import java.io.IOException;
import java.util.Map;




public class Main {

	public static void main(String [] args) throws IOException{
		Z3 z3=new Z3();
		String exp= "(y==10),Not(x>20)";
		Map<String, Integer> result=z3.eval(exp);
		System.out.println(result);
	}
	
	
}
