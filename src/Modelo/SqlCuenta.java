package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public ArrayList<Cuenta> planCuenta() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        ArrayList<Cuenta> cuentas = new ArrayList<>();

        String sql = "SELECT * FROM cuenta ORDER BY codigo";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setIdcuenta(rs.getInt(1));
                cuenta.setNombre(rs.getString(2));
                cuenta.setTipo(rs.getString(3));
                cuenta.setEmpresa(rs.getInt(4));
                cuenta.setCodigo(rs.getString(5));
                cuenta.setRecibeSaldo(rs.getBoolean(6));
                cuentas.add(cuenta);
            }
            return cuentas;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Cuenta> nombreCuentasHoja() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        ArrayList<Cuenta> cuentas = new ArrayList<>();

        String sql = "SELECT nombre FROM cuenta WHERE recibeSaldo = 1";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setNombre(rs.getString(1));
                cuentas.add(cuenta);
            }
            return cuentas;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    

}
