package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public Boolean eliminar(Asiento asiento) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM asiento WHERE idasiento = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, asiento.getIdasiento());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlAsientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Renglon> asientoPorFecha(String fechaD, String fechaH) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        ArrayList<Renglon> renglones = new ArrayList<Renglon>();
            
        String sql = "SELECT a.fecha, c.nombre, ac.debe, ac.haber FROM asiento_cuenta ac INNER JOIN asiento a ON(a.idasiento=ac.asiento) INNER JOIN cuenta c ON(c.idcuenta= ac.cuenta) WHERE a.fecha > ? AND a.fecha < ? ORDER BY a.fecha";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, (fechaD + " 00:00:00"));
            ps.setString(2, (fechaH + " 23:59:59"));
            
            rs = ps.executeQuery();
            if(rs.first()){
                Renglon renglon = new Renglon(rs.getString(1).substring(10, 19), rs.getString(2), rs.getInt(3), rs.getInt(4));
                renglones.add(renglon);
                while (rs.next()) {
                    Renglon renglon2 = new Renglon(rs.getString(1).substring(10, 19), rs.getString(2), rs.getInt(3), rs.getInt(4));
                    renglones.add(renglon2);
                }
                return renglones;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
