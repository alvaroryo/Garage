package Garage;

public class Revision extends Trabajo {
	private static float extra = 20f;
	
	public Revision(String desc) {
		super(desc);
		
	}
	
//--------------------------MOSTRAR TRABAJO------------------------	
	public String muestraTrabajo() {
		double total = (getHoras() * getPrecioHora())+ getExtra();
		String info = "ID: "+getId()+"\n-----\n Descripcion: "+getDescripcion()+"\n Precio: "+ total;
		return info;
	}

//--------------------------GETTERS & SETTERS---------------------
	public static float getExtra() {
		return extra;
	}

	public static void setExtra(float extra) {
		Revision.extra = extra;
	}

	public void aumentaCoste(float coste) {}
}
