package Garage;

public abstract class Reparacion extends Trabajo{
	private double precioMaterial;
	
	public Reparacion(String desc) {
		super(desc);
	}
	

//--------------------------MOSTRAR TRABAJO------------------------	
//	public static String toString(Trabajo t) {
//		String info = null;
//		if(t instanceof ReparacionMecanica) {
//			info = ((ReparacionMecanica)t).toString();
//		}
//		else if(t instanceof ReparacionChapaPintura) {
//			info = ((ReparacionChapaPintura)t).toString();
//		}
//		return info;
//	}
	
	
//--------------------------REGISTRO TRABAJOS---------------------
	public static Reparacion devuelveTrabajo(String desc, int opc) {
		if(opc == 2) {
			ReparacionMecanica rm = new ReparacionMecanica(desc);
			return rm;
		}
		else {
			ReparacionChapaPintura rcp = new ReparacionChapaPintura(desc);
			return rcp;
		}
	}
	
	
//--------------------------GETTERS & SETTERS---------------------
	public double getPrecioMaterial() {
		return precioMaterial;
	}

	
//--------------------------AUMENTA COSTE PIEZAS---------------------
	public void setPrecioMaterial(double precioMaterial) {
		if(estado == false) {
			System.out.println("El trabajo ya esta finalizado y no se puede modificar.");
		}
		else {
			this.precioMaterial += precioMaterial;
		}
	}
	
}
