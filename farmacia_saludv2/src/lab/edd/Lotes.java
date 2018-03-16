package lab.edd;
/**
 * @authors jheisecke, jvillagra. Javier Heisecke, Paula Villagra
 */
public class Lotes{
	String fechaVto;
	double precioCosto;
	double comision;
	double PrecioVenta=getPrecioVenta(precioCosto);
	Medicamentos[] input;
	
	
	public double getPrecioVenta(double costo){
		double venta=0;
		double x=(25/100)*costo;
		venta=x+costo;
	
		return venta;		
	}
	
	public Lotes (String fechaVto, double precioCosto, double comision, Medicamentos input) {
		this.fechaVto=fechaVto;
		this.precioCosto=precioCosto;
		this.comision=comision;
	}

	
}
