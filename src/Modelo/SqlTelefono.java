package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlTelefono extends Conexion {

    public boolean agregarTelefono(String tel, int persona) {

        PreparedStatement ps = null;
        Connection con = getConexion();
        SqlTelefono sqlTel = new SqlTelefono();

        String sql = "INSERT INTO telefono(numero, persona) values(?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tel);
            ps.setInt(2, persona);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlTelefono.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public int idTelefono(String tel) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT idtelefono FROM telefono WHERE numero = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tel);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return -1;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SqlTelefono.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }
    
    public ArrayList<Telefono> telefonos(int id){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        ArrayList<Telefono> telefonos = new ArrayList<>();

        String sql = "SELECT numero FROM telefono WHERE persona = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                Telefono tel = new Telefono();
                tel.setNumero(rs.getString(1));
                telefonos.add(tel);
            }
            return telefonos;
        } catch (SQLException ex) {
            Logger.getLogger(SqlTelefono.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }

}
