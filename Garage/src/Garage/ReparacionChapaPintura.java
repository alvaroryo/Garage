package Garage;

public class ReparacionChapaPintura extends Reparacion {
	private static float extra = 1.3f;
	
	public ReparacionChapaPintura(String desc) {
		super(desc);
	}

//--------------------------MOSTRAR TRABAJO-----------------------------	
	public String muestraTrabajo() {
		double total = getHoras() * getPrecioHora();
		total = total + (getPrecioMaterial() * getExtra());
		String info = "ID: "+getId()+"\n-----\n Descripcion: "+getDescripcion()+"\n Precio: "+ total;
		return info;
	}
	
//--------------------------AUMENTA COSTE PIEZAS------------------
	public void aumentaCoste(float precio) {
		setPrecioMaterial(precio);	
	}
	
//--------------------------GETTERS & SETTERS---------------------
	public static double getExtra(ReparacionChapaPintura r) {
		return extra;
	}
	
	public static double getExtra() {
		return extra;
	}

	public static void setExtra(float extra) {
		ReparacionChapaPintura.extra = extra;
	}
}
