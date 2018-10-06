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

    public int idEditorPorNombre(String nombre) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT ideditor FROM editor WHERE nombre = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(SqlEditor.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    public boolean guardadTexto(String texto, String nombre) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE editor SET texto = ? WHERE nombre = ? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, texto);
            ps.setString(2, nombre);
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SqlEditor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
