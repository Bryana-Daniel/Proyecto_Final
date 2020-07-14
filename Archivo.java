import java.io.*;
 import java.util.*;
  class Archivo{
   public static ArrayList<String> leerTodo(String nombreArchivo)
   {  
    ArrayList<String> contenido = new ArrayList<String>();
    String cadena = new String();

    try(FileInputStream fis = new FileInputStream(nombreArchivo);
    DataInputStream din = new DataInputStream(fis);
    BufferedReader br = new BufferedReader(new InputStreamReader(din));)
    {
      cadena = br.readLine();
      while(cadena != null)
      {
        contenido.add(cadena);
        cadena = br.readLine();
      }
      return contenido;
    }
    catch(Exception error)
    {}
    return null;
  }


    public static void crearArchivo(String contenido, String nombre)
    {
        try
        {
            String ruta = "C:/Users/W8/Documents/Tecnologico Nacional de Mexico/Bryana/" + nombre+".txt";
            File file = new File(ruta);

            if(!file.exists())
            {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido+"\n");
            bw.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


            
            public static void guardarTodo(String informacion){
            	try
            	{
            		FileOutputStream fos = new FileOutputStream ("C:/Users/W8/Documents/Tecnologico Nacional de Mexico/Bryana/");
            		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            		out.write(informacion);                     
            		out.close();
            	} 
            	catch (Exception e) 
            	//Agregar Excepciones         
            	{
            		e.printStackTrace();
            		System.exit(1);
            	}
            } 
            public static void guardarTodo(String informacion, String nombre)
            {
            	try
            	{
            	FileOutputStream fos = new FileOutputStream ("C:/Users/W8/Documents/Tecnologico Nacional de Mexico/Bryana/" + nombre+".txt");
            	BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));                     
            	out.write(informacion);                     
            	out.close();                  
            	}         
            	catch (Exception e) 
            	//Agregar Excepciones         
            	{
            		e.printStackTrace();                     
            		System.exit(1); 
            	}
            }
        } 