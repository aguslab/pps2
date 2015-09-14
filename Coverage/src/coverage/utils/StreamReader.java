package coverage.utils;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Esto lo puse por las dudas de que Z3 necesite leer los condition path de un archivo de texto, si no sirve Borrarlo!
public class StreamReader 
{
	private PrintStream out;
	
	//Para guardar el condition path en el archivo prints.txt
	public void guardarPrints() throws IOException
	{
	  File file = new File("C:\\Users\\ale\\git\\pps2\\Coverage\\src\\ejercicio\\prints.txt");
	  FileOutputStream fis = new FileOutputStream(file);
	  this.out = new PrintStream(fis);
	  System.setOut(out);
	}

	// Para leer el archivo prints.txt
	public StringBuilder getPrintsArchivo() throws FileNotFoundException, IOException
	{
		
		InputStream in = new FileInputStream(new File("C:\\Users\\ale\\git\\pps2\\Coverage\\src\\ejercicio\\prints.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) 
        {
            out.append(line + "-");
        }
        
        reader.close();
        return out;
	}
	
	//para cerrar el FileOutputStream y que deje de guardar lo que sale en consola
	public void close()
	{
		out.close();
	}
}
