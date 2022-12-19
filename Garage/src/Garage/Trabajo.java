package Garage;

public abstract class Trabajo {
	
	private static int contador=-1;
	private int id;
	
	private String descripcion;

	private int horas;
	protected boolean estado;  //true -> activo , false -> finalizado
	private static int precioHora=30;
	
	public Trabajo(String desc) {
		Trabajo.contador+=1;
		this.id = contador; //agrego id y cambio el valor del contador
		this.descripcion = desc;
		this.horas = 0;
		this.estado = true;
	}
	
//--------------------------AUMENTA HORAS TRABAJO---------------------
	public void aumentaHoras(int horas) {
		this.horas += horas;
	}
	
//--------------------------FINALIZAR TRABAJO---------------------
	public void finalizaTrabajo() {
		setEstado(false);
	}
	
//--------------------------AUMENTA COSTE PIEZAS---------------------
	
	public abstract void aumentaCoste(float coste);
	
	
//	public static void aumentaCoste(Trabajo t, double coste) {
//		if(t instanceof Reparacion) {
//			Reparacion rep = (Reparacion)t;
//			rep.setPrecioMaterial(coste);
//		}
//	}
	
//--------------------------REGISTRO TRABAJOS---------------------
//	public static Trabajo registraTrabajo(String desc, int opc) {
//		if(opc == 1) {
//			Revision rev = new Revision(desc);
//			return rev;
//		}
//		else {
//			Reparacion rep;
//			rep = Reparacion.devuelveTrabajo(desc,opc);
//			return rep;
//		}
//	}
	
//--------------------------MOSTRAR TRABAJO------------------------	
	public abstract String muestraTrabajo();
//	{
//		String info = null;
//		if(t instanceof Revision) {
//			Revision r = (Revision)t;
//			info = r.toString();
//		}
//		else if(t instanceof Reparacion) {
//			info = Reparacion.toString(t);
//		}
//		
//		return info;
//	}
	
//--------------------------GETTERS & SETTERS---------------------
	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Trabajo.contador = contador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public static int getPrecioHora() {
		return precioHora;
	}

	public static void setPrecioHora(int precioHora) {
		Trabajo.precioHora = precioHora;
	}
}
