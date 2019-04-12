package dibujarnull;

public class Pato {

	private String nombre;
	private int edad;
	
	public Pato(String nombre, int edad) 
	{
		this.nombre = nombre;
		this.edad = edad;
	}


	public String toString() {
		return nombre+","+edad+" años";
	}
	
	
	
}
