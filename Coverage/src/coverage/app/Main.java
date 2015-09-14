package coverage.app;
import coverage.pathconditions.PathConditionList;

public class Main 
{
	//Initializer ejecuta la funcion
    public static void main(String[] args)
    {
    	Initializer init = new Initializer();
    	PathConditionList pcl = PathConditionList.getInstance();
    	pcl.clear();
    	init.iniciar();
    	System.out.println(pcl.getList());
    }
}
