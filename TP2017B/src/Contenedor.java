
public class Contenedor {

	private String clave; //codigo del producto
	private Long valor;   //valor del producto asociado al codigo
	
	public Contenedor(String clave, Long valor) {
		super();
		this.clave = clave;
		this.valor = valor;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

}
