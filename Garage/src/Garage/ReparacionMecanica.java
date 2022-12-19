package Garage;

public class ReparacionMecanica  extends Reparacion {
	private static float extra = 1.1f;
	
	public ReparacionMecanica(String desc) {
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
	public static double getExtra(ReparacionMecanica r) {
		return extra;
	}
	
	public static double getExtra() {
		return extra;
	}

	public static void setExtra(float extra) {
		ReparacionMecanica.extra = extra;
	}
	
}
