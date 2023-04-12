package modelo;

public class Reservas {

	private Integer id;
	private String fecha_Entrada;
	private String fecha_Salida;
	private float valor;
	private String forma_Pago;
	
	public Reservas(String fecha_Entrada, String fecha_Salida, float valor, String forma_Pago) {
		this.fecha_Entrada = fecha_Entrada;
		this.fecha_Salida = fecha_Salida;
		this.valor = valor;
		this.forma_Pago = forma_Pago;
	}
	
	
	public Reservas(int id, String fecha_Entrada, String fecha_Salida, float valor, String forma_Pago) {
		this.id = id;
		this.fecha_Entrada = fecha_Entrada;
		this.fecha_Salida = fecha_Salida;
		this.valor = valor;
		this.forma_Pago = forma_Pago;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFecha_Entrada() {
		return fecha_Entrada;
	}

	public void setFecha_Entrada(String fecha_Entrada) {
		this.fecha_Entrada = fecha_Entrada;
	}

	public String getFecha_Salida() {
		return fecha_Salida;
	}

	public void setFecha_Salida(String fecha_Salida) {
		this.fecha_Salida = fecha_Salida;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getForma_Pago() {
		return forma_Pago;
	}

	public void setForma_Pago(String forma_Pago) {
		this.forma_Pago = forma_Pago;
	}

	@Override
	public String toString() {
		return "Reservas [id=" + id + ", fecha_Entrada=" + fecha_Entrada + ", fecha_Salida=" + fecha_Salida + ", valor="
				+ valor + ", forma_Pago=" + forma_Pago + "]";
	}
	
	
	
}
