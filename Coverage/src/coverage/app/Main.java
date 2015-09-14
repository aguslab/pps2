package coverage.app;

import coverage.aspects.Aspect;
import coverage.mock.Z3mock;

public class Main 
{
	/*Initializer ejecuta la funcion
	 * Z3mock lo hice para que sepas el metodo que hay que usar para darle el conditional path al verdadero z3
	 * */
    public static void main(String[] args)
    {
    	Initializer init = new Initializer();
    	init.iniciar();
    	Z3mock z3 = new Z3mock();
    	z3.getConditionPath(Aspect.aspectOf().getConditionPath());
    	z3.mostrarConditionPath();
    }
}
