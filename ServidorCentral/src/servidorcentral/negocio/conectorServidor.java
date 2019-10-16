package servidorcentral.negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Esta clase se conecta a la base de datos con Jdbc
 *
 * @author Libardo, Ricardo, Julio
 */
public class conectorServidor {

    private Connection cn;
    private ResultSet rs;
    private Statement st;
    private final String URL = "jdbc:hsqldb:file:C:\\Users\\HP\\Desktop\\Taller4-cliente-servidor\\ServidorCentral\\bd\\servidorCentral;hsqldb.lock_file=false";
    //Cambie la URL de su bd local, por ejemplo, si tiene Windows,sería algo como:
    //private final String URL = "jdbc:hsqldb:file:C:\\clientes\\bd\\clientes;hsqldb.lock_file=false";
    
    private final String USER = "sa";
    private final String PASSWORD = "123";

    public conectorServidor() {
        
    }

    public void conectarse() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbcDriver");
        cn = DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public void actualizar(String sql) throws SQLException {
        st = cn.createStatement();
        st.executeUpdate(sql);
    }
    /**
     * Ejecuta una consulta de tipo select
     * @param sql
     * @throws SQLException 
     */
    public void crearConsulta(String sql) throws SQLException {
        st = cn.createStatement();
        rs = st.executeQuery(sql);
    }

    /**
     * Cierra las variables de rs, st y cn que estén abiertas
     * @throws SQLException 
     */
    public void desconectarse() throws SQLException {
        if ( rs != null){
            rs.close();
        }
        st.close();
        cn.close();
    }
    /**
     * Devuelve todo el conjunto de resultados
     * @return 
     */
    public ResultSet getResultado() {
        return rs;
    }
}