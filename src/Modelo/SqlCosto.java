package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SqlCosto extends Conexion {
     public int agregarCosto(int cantidad, Double costo) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO costo(fecha, cantidad, costo) VALUES(?,?,?)";
        
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ps.setString(1, fechaHora.format(new Date()));
            ps.setInt(2, cantidad);
            ps.setDouble(3, costo);
            if(ps.executeUpdate() > 0){
                rs = ps.getGeneratedKeys();
                if(rs.next()){
                    System.out.println(rs.getInt(1));
                    return rs.getInt(1);
                }
            }
            return -1;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
     }
}
