package controller;

import java.util.List;

import dao.HuespedesDAO;
import factory.ConnectionFactory;
import modelo.Huespedes;

public class HuespedesController {
	
	private HuespedesDAO huespedesDAO;

	public HuespedesController() {
		ConnectionFactory factory = new ConnectionFactory();
		this.huespedesDAO = new HuespedesDAO(factory.recuperaConexion());
	}
	
	public void guardar(Huespedes huespedes) {
		huespedesDAO.guardar(huespedes);
	}

	public List<Huespedes> listar() {
		return huespedesDAO.listar();
	}

	public List<Huespedes> buscar(String apellido) {
		return huespedesDAO.buscar(apellido);
	}

	public Integer modificar(Integer id, String nombre, String apellido, String fecha_Nacimiento, String nacionalidad,
			Integer telefono, Integer id_Reserva) {
		return huespedesDAO.modificar(id, nombre, apellido, fecha_Nacimiento, nacionalidad, telefono, id_Reserva);
	}

	public Integer eliminar(Integer id) {
		return huespedesDAO.eliminar(id);
	}
	
	

}
