package controller;

import java.util.List;

import dao.ReservasDAO;
import factory.ConnectionFactory;
import modelo.Reservas;

public class ReservasController {

	private ReservasDAO reservasDAO;

	public ReservasController() {
		ConnectionFactory factory = new ConnectionFactory();
		this.reservasDAO = new ReservasDAO(factory.recuperaConexion());
	}
	
	public void guardar(Reservas reservas) {
		reservasDAO.guardar(reservas);
	}

	public List<Reservas> listar() {
		return reservasDAO.listar();
	}

	public List<Reservas> buscar(String id) {
		return reservasDAO.buscar(id);
	}

	public Integer modificar(Integer id, String fecha_Entrada, String fecha_Salida, float valor, String forma_Pago) {
		return reservasDAO.modificar(id, fecha_Entrada, fecha_Salida, valor, forma_Pago);
	}

	public Integer eliminar(Integer id) {
		return reservasDAO.eliminar(id);
	}
}
