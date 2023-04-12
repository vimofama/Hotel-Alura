package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

import modelo.Reservas;
import views.Exito;

public class ReservasDAO {

	private Connection con;

	public ReservasDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Reservas reservas) {
		try {
			PreparedStatement statement;
			statement = con.prepareStatement(
					"INSERT INTO RESERVAS " + "(fecha_Entrada, fecha_Salida, valor, forma_Pago) " + "VALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			try (statement) {
				java.sql.Date fecha_Entrada = java.sql.Date.valueOf(reservas.getFecha_Entrada());
				java.sql.Date fecha_Salida = java.sql.Date.valueOf(reservas.getFecha_Salida());
				statement.setDate(1, fecha_Entrada);
				statement.setDate(2, fecha_Salida);
				statement.setFloat(3, reservas.getValor());
				statement.setString(4, reservas.getForma_Pago());

				statement.execute();

				final ResultSet resultSet = statement.getGeneratedKeys();

				try (resultSet) {
					while (resultSet.next()) {
						reservas.setId(resultSet.getInt(1));
					}
				}

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Reservas> listar() {
		List<Reservas> resultado = new ArrayList<>();

		try {
			final PreparedStatement statement = con
					.prepareStatement("SELECT ID, FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO FROM RESERVAS");

			try (statement) {
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Reservas(resultSet.getInt("ID"), resultSet.getString("FECHA_ENTRADA"),
								resultSet.getString("FECHA_SALIDA"), resultSet.getFloat("VALOR"),
								resultSet.getString("FORMA_PAGO")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}

	public List<Reservas> buscar(String id) {
		List<Reservas> resultado = new ArrayList<>();

		try {
			final PreparedStatement statement = con
					.prepareStatement("SELECT ID, FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO FROM RESERVAS WHERE ID LIKE ?");

			try (statement) {
				statement.setInt(1, Integer.parseInt(id));
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Reservas(resultSet.getInt("ID"), resultSet.getString("FECHA_ENTRADA"),
								resultSet.getString("FECHA_SALIDA"), resultSet.getFloat("VALOR"),
								resultSet.getString("FORMA_PAGO")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}

	public Integer modificar(Integer id, String fecha_Entrada, String fecha_Salida, float valor, String forma_Pago) {
		try {
			final PreparedStatement statement = con.prepareStatement("UPDATE RESERVAS SET "
					+ " FECHA_ENTRADA = ?, "
					+ " FECHA_SALIDA = ?, "
					+ " VALOR = ?, "
					+ " FORMA_PAGO = ?"
					+ " WHERE ID = ?");
			
			try(statement){
				
				java.sql.Date fechaE = java.sql.Date.valueOf(fecha_Entrada);
				java.sql.Date fechaS = java.sql.Date.valueOf(fecha_Salida);
				statement.setDate(1, fechaE);
				statement.setDate(2, fechaS);
				statement.setFloat(3, valor);
				statement.setString(4, forma_Pago);
				statement.setInt(5, id);
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
            final PreparedStatement statement = con.prepareStatement("DELETE FROM RESERVAS WHERE ID = ?");

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
