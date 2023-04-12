package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Huespedes;
import modelo.Reservas;
import views.Exito;

public class HuespedesDAO {

	private Connection con;

	public HuespedesDAO(Connection con) {
		this.con = con;
	}
	
	public void guardar(Huespedes huespedes) {
		try {
			PreparedStatement statement;
			statement = con.prepareStatement("INSERT INTO HUESPEDES "
					+ "(nombre, apellido, fecha_Nacimiento, nacionalidad, telefono, id_Reserva) "
					+ "VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			try (statement){
				java.sql.Date fecha_Nacimiento = java.sql.Date.valueOf(huespedes.getFecha_Nacimiento());
				statement.setString(1, huespedes.getNombre());
				statement.setString(2, huespedes.getApellido());
				statement.setDate(3, fecha_Nacimiento);
				statement.setString(4, huespedes.getNacionalidad());
				statement.setInt(5, huespedes.getTelefono());
				statement.setInt(6, huespedes.getId_Reserva());
				
				statement.execute();
				
				final ResultSet resultSet = statement.getGeneratedKeys();
				
				try(resultSet){
					while(resultSet.next()) {
						huespedes.setId(resultSet.getInt(1));
						
						new Exito().setVisible(true);
					}
				}
				
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huespedes> listar() {
		List<Huespedes> resultado = new ArrayList<>();

		try {
			final PreparedStatement statement = con
					.prepareStatement("SELECT ID, NOMBRE, APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA FROM HUESPEDES");

			try (statement) {
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Huespedes(resultSet.getInt("ID"), 
								resultSet.getString("NOMBRE"),
								resultSet.getString("APELLIDO"), 
								resultSet.getString("FECHA_NACIMIENTO"),
								resultSet.getString("NACIONALIDAD"),
								resultSet.getInt("TELEFONO"),
								resultSet.getInt("ID_RESERVA")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}

	public List<Huespedes> buscar(String apellido) {
		List<Huespedes> resultado = new ArrayList<>();

		try {
			final PreparedStatement statement = con
					.prepareStatement("SELECT ID, NOMBRE, APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA FROM HUESPEDES WHERE APELLIDO LIKE ?");

			try (statement) {
				statement.setString(1, "%"+apellido+"%");
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Huespedes(resultSet.getInt("ID"), 
								resultSet.getString("NOMBRE"),
								resultSet.getString("APELLIDO"), 
								resultSet.getString("FECHA_NACIMIENTO"),
								resultSet.getString("NACIONALIDAD"),
								resultSet.getInt("TELEFONO"),
								resultSet.getInt("ID_RESERVA")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}

	public Integer modificar(Integer id, String nombre, String apellido, String fecha_Nacimiento, String nacionalidad,
			Integer telefono, Integer id_Reserva) {
		try {
			final PreparedStatement statement = con.prepareStatement("UPDATE HUESPEDES SET "
					+ " NOMBRE = ?, "
					+ " APELLIDO = ?, "
					+ " FECHA_NACIMIENTO = ?, "
					+ " NACIONALIDAD = ?, "
					+ " TELEFONO = ?, "
					+ " ID_RESERVA = ?"
					+ " WHERE ID = ?");
			
			try(statement){
				
				java.sql.Date fechaN = java.sql.Date.valueOf(fecha_Nacimiento);
				statement.setString(1, nombre);
				statement.setString(2, apellido);
				statement.setDate(3, fechaN);
				statement.setString(4, nacionalidad);
				statement.setInt(5, telefono);
				statement.setInt(6, id_Reserva);
				statement.setInt(7, id);
				statement.execute();
				
				int updateCount = statement.getUpdateCount();
				
				return updateCount;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Integer eliminar(Integer id) {
        try {
            final PreparedStatement statement = con.prepareStatement("DELETE FROM HUESPEDES WHERE ID = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

}
