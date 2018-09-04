package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlAsientos extends Conexion {

    public int ultimoNumAsiento() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT max(numAsiento)  FROM asiento";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {

                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public int ultimoIdAsiento() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT idasiento  FROM asiento WHERE fecha >= all(SELECT fecha  FROM asiento)";

        try {
            ps = con.prepareStatement(sql);
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

    public Boolean registrarAsiento(Asiento asiento) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO asiento (numAsiento, fecha, descripcion, usuario) VALUES(?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, asiento.getNumAsiento());
            ps.setString(2, asiento.getFecha());
            ps.setString(3, asiento.getDescripcion());
            ps.setInt(4, asiento.getUsuario());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlAsientos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
