package lab.edd;
/**
 * @authors jheisecke, jvillagra. Javier Heisecke, Paula Villagra
 */
public class Medicamentos {
	public String codigo;
	public String nombre;
	public String laboratorio;
	public String drogas[];

	public Medicamentos (String codigo, String nombre, String laboratorio, String drogas[]) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.laboratorio=laboratorio;
		this.drogas=drogas;
	}
	
}
