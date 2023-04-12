package modelo;

public class Huespedes {

	private Integer id;
	private String nombre;
	private String apellido;
	private String fecha_Nacimiento;
	private String nacionalidad;
	private Integer telefono;
	private Integer id_Reserva;

	public Huespedes(String nombre, String apellido, String fecha_Nacimiento, String nacionalidad, Integer telefono,
			Integer id_Reserva) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_Nacimiento = fecha_Nacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.id_Reserva = id_Reserva;
	}
	
	public Huespedes(Integer id, String nombre, String apellido, String fecha_Nacimiento, String nacionalidad, Integer telefono,
			Integer id_Reserva) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_Nacimiento = fecha_Nacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.id_Reserva = id_Reserva;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFecha_Nacimiento() {
		return fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(String fecha_Nacimiento) {
		this.fecha_Nacimiento = fecha_Nacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Integer getId_Reserva() {
		return id_Reserva;
	}

	public void setId_Reserva(Integer id_Reserva) {
		this.id_Reserva = id_Reserva;
	}

	@Override
	public String toString() {
		return "Huespedes [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha_Nacimiento="
				+ fecha_Nacimiento + ", nacionalidad=" + nacionalidad + ", telefono=" + telefono + ", id_Reserva="
				+ id_Reserva + "]";
	}
	
	

}
