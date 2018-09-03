package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlAsientos extends Conexion {

    public int ultimoAsiento() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT max(idasiento)  FROM asiento";

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

    public Boolean registrarAsiento(Asiento asiento) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "INSERT INTO asiento (idasiento, fecha, descripcion) VALUES(?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, asiento.getIdasiento());
            ps.setString(2, asiento.getFecha());
            ps.setString(3, asiento.getDescripcion());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlAsientos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
