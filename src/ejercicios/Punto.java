package ejercicios;

public class Punto {

	private int x;
	private int y;
	
	public Punto(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}


	public String toString() {
		return "("+this.x+","+this.y+")";
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	public static Punto puntoAlAzar()
	{
		Punto p1;
		
		int x=(int)Math.random()*11;
		int y=(int)Math.random()*11;
		p1=new Punto(x,y);
		return p1;
		
	}

	public double distanciaA(Punto p2) 
	{
		int x=this.x-p2.x;
		int y=this.y-p2.y;
		double raiz=Math.sqrt((x*x)+(y*y));
		return raiz;
	}
	
	
	
	
}
