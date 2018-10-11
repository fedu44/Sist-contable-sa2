package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlEmpresa extends Conexion{
    
    public String inicioActividad(int empresa) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT fecha_inic_act FROM empresa WHERE idempresa = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, empresa);
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
    
    public String empresa(int empresa) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT nombre FROM empresa WHERE idempresa = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, empresa);
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
    
    public String cuit(int empresa) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT cuit FROM empresa WHERE idempresa = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, empresa);
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
