package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlEditor extends Conexion {

    public boolean registrarEditor(String nombre) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO editor (texto, nombre) values ('', ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SqlEditor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
