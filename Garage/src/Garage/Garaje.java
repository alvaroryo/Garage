package Garage;

import java.util.*;

public class Garaje {
	private List<Trabajo> trabajos;
	
	public Garaje() {
		trabajos = new ArrayList<Trabajo>();
	}
	
//--------------------------GETTERS & SETTERS---------------------
	public List<Trabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(List<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}
	
//--------------------------REGISTRO TRABAJOS---------------------
	
	public int registra(String desc, int opc) {
		if (opc == 1) {			//Revision
			Revision rev = new Revision(desc);
			trabajos.add(rev);
			return rev.getId();
		}
		else if (opc == 2) {	//Reparacion mecanica
			ReparacionMecanica rm = new ReparacionMecanica(desc);
			trabajos.add(rm);
			return rm.getId();
		}
		else{					//Reparacion chapa y pintura
			ReparacionChapaPintura rcp = new ReparacionChapaPintura(desc);
			trabajos.add(rcp);
			return rcp.getId();
		}
	}


//--------------------------AUMENTA HORAS TRABAJO---------------------
	public int aumentaHoras(int ident, int horas) {
		int error = 0;
		for(Trabajo t: trabajos)  {
			if(t.getId()==ident) {
				if(t.getHoras()>=0) {	//Si el numero de horas es negativo
					if(t.isEstado()==false) {	//Si el trabajo ya esta finalizado
						//error =????////////////////////////////////////////////------------------------------------------------------------
					}
					else t.aumentaHoras(horas);
				}
				else error = -3;
			}
		}
		return error;
	}
	

//--------------------------FINALIZAR TRABAJO---------------------
	public void finalizarTrabajo(int ident) {
		for(Trabajo t: trabajos)  {
			if(t.getId()==ident) {
				t.finalizaTrabajo();
			}
		}
	}

//--------------------------AUMENTA COSTE PIEZAS-------------------
	public int aumentaCoste(int ident,float precio) {
		int error=0;
		for(Trabajo t: trabajos)  {
			if(t.getId()==ident) {
				if(t instanceof Reparacion) {	//Si el trabajo no es reparacion error
					if(t.isEstado()==false) {	//Si el trabajo esta finalizado error
						error = -2;		
					}
					else {
						t.aumentaCoste(precio);	
					}
				}
				else error =-1; 						
			}
		}
		return error;
	}
	
//--------------------------MOSTRAR TRABAJO------------------------
	public String muestraTrabajo(int ident) {
		String info="";
		for(Trabajo t: trabajos)  {
			if(t.getId()==ident) {
				info = t.muestraTrabajo();
			}
		}
		return info;
	}
//--------------------------EXISTE TRABAJO------------------------
	
	public boolean existeTrabajo(int ident) {
		boolean existe = false;
		for(Trabajo t: trabajos) {
			if(t.getId()==ident) {
				existe = true;		
			}
		}
		return existe;
	}
}
