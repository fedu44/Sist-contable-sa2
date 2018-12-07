package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlArticulo extends Conexion {
    
public ArrayList<Articulo> traerArticulos() {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        ArrayList<Articulo> articulos = new ArrayList<>();
        
        String sql = "SELECT * FROM articulo";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Articulo art = new Articulo(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
                articulos.add(art);
            }
            return articulos;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
