package servidorcentral.negocio;

import java.util.ArrayList;
import mvcf.AModel;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Representa el modelo (Observable) de datos Cuando hay cambios en el estado,
 * notifica a todas sus vistas (observadores)
 *
 * @author Julio, Libardo, Ricardo
 */
public class GestorClientes extends AModel {

    private conectorServidor conector;

    public GestorClientes() {
        conector = new conectorServidor(); 
    }

    /**
     * Trae de la base de datos todos los clientes
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
     public void copiarCliente(String id, String nombres, String apellidos, String direccion, String celular, String email, String sexo) throws ClassNotFoundException, SQLException {
        conector.conectarse();
        conector.actualizar("INSERT INTO SERVIDORCENTRAL (id, nombres, apellidos, direccion, celular, email, sexo)"
                + " VALUES ("
                + "'" + id + "',"
                + "'" + nombres + "',"
                + "'" + apellidos + "',"
                + "'" + direccion + "',"
                + "'" + celular + "',"
                + "'" + email + "',"
                + "'" + sexo + "'"
                + ")");
        conector.desconectarse();
        this.notificar();
    }
}