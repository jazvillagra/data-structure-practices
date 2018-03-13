package lab.edd;

public class Lotes extends Medicamentos{
		
		String fechaVencto;
		double precioCosto;
		double comision;
		double PrecioVenta=getPrecioVenta(precioCosto);
		
		
		public double getPrecioVenta(double costo){
			double venta=0;
			double x=(25/100)*costo;
			venta=x+costo;
		
			return venta;		
		}
}

