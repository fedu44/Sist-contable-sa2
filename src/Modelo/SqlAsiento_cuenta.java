package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlAsiento_cuenta extends Conexion {

    public boolean registrar(Asiento_cuenta ac) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO asiento_cuenta (debe, haber, cuenta, asiento, saldo_parcial) VALUES (?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1, ac.getDebe());
            ps.setDouble(2, ac.getHaber());
            ps.setDouble(3, ac.getCuenta());
            ps.setDouble(4, ac.getAsiento());
            ps.setDouble(5, ac.getSaldo_parcial());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public int saldoParcial(Cuenta cta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT ac.saldo_parcial FROM asiento_cuenta ac INNER JOIN asiento a ON(a.idasiento=ac.asiento) INNER JOIN cuenta c ON(c.idcuenta= ac.cuenta) WHERE cuenta= ? AND a.fecha >= ALL (SELECT asi.fecha FROM asiento_cuenta acu INNER JOIN asiento asi ON(asi.idasiento=acu.asiento)INNER JOIN cuenta cu ON(cu.idcuenta= acu.cuenta) WHERE cuenta= ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cta.getIdcuenta());
            ps.setInt(2, cta.getIdcuenta());
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

    public boolean eliminar(Asiento_cuenta ac) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM asiento_cuenta WHERE asiento = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ac.getAsiento());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
