package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlSituacionCrediticia extends Conexion {

    public int idSitCred(String nombre) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT idsituacion_crediticia FROM situacion_crediticia WHERE nombre = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCategoriaIva.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }
    
    public ArrayList<SituacionCrediticia> situaciones() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        ArrayList<SituacionCrediticia> situacion = new ArrayList<>();

        String sql = "SELECT * FROM situacion_crediticia";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SituacionCrediticia SitCred = new SituacionCrediticia();
                SitCred.setNombre(rs.getString(2));
                situacion.add(SitCred);
            }
            return situacion;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
