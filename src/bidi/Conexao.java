package bidi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author neto
 */
public class Conexao {
    public Connection getConnection(){
    try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Biblioteca", "postgres", "postgres");
	} catch (SQLException e){
            throw new RuntimeException(e);
	}
    }
}
