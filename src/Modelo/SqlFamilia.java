package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlFamilia extends Conexion  {
    
    public ArrayList<Familia> traerFamilias() {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        ArrayList<Familia> familias = new ArrayList<>();
        
        String sql = "SELECT * FROM familia";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Familia fam = new Familia(rs.getInt(1), rs.getString(2));
                familias.add(fam);
            }
            return familias;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
