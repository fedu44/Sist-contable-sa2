package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SqlCuenta extends Conexion {

    public int idCuenta(Cuenta cta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT idcuenta FROM cuenta As c WHERE c.nombre = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cta.getNombre());
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return -1;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public String tipoCuenta(Cuenta cta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT tipo FROM cuenta As c WHERE c.nombre = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cta.getNombre());
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            } else {
                return "";
            }

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

}
