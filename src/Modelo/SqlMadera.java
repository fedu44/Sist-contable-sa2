package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlMadera extends Conexion {
    
    public ArrayList<Madera> traerMaderas() {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        ArrayList<Madera> maderas = new ArrayList<>();
        
        String sql = "SELECT * FROM madera";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Madera mad = new Madera(rs.getInt(1), rs.getString(2),rs.getString(3));
                maderas.add(mad);
            }
            return maderas;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<String> traerColores() {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        ArrayList<String> colores = new ArrayList<>();
        
        String sql = "SELECT DISTINCT color FROM madera";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                String col = new String(rs.getString(1));
                colores.add(col);
            }
            return colores;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
