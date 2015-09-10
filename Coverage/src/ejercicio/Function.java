package ejercicio;

public class Function 
{
	static Function f;

    public static void main(String[] args)
    {
        new Function().iniciar();
    }

    void iniciar()
    {
    	int x = 2;
		int y = 6;
        f = new Function();
        f.test(x,y,"2<6");
    }

    void test(int x,int y, String condition)
    {
    	Expression expression = new Expression(x, y, condition);
		if(expression.eval())
		{
			System.out.println("verdad");
		}
		else
		{
			System.out.println("falso");
		}
		
		x+=5;
		expression.setExpression(x, y, "7<6");
		
		if(expression.eval())
		{
			System.out.println("verdad");
		}
		else
		{
			System.out.println("falso");
		}
    
    }
}