package victor.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = ConnectionFactory.class
                .getClassLoader()
                .getResourceAsStream("db.properties")) {
            if (input == null) throw new RuntimeException("Arquivo db.properties não encontrado!");
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar configurações do banco.", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String password = System.getenv("DB_PASSWORD");
        if (password == null) password = props.getProperty("db.password");

        return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                password
        );
    }
}
