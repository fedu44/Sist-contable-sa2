package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlCategoriaIva extends Conexion {
    
    public int idIva(String tipo){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT idcategoria_iva FROM categoria_iva WHERE tipo = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tipo);
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
    
    public ArrayList<CategoriaIva> categorias() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        ArrayList<CategoriaIva> categoria = new ArrayList<>();

        String sql = "SELECT * FROM categoria_iva";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoriaIva catIva = new CategoriaIva();
                catIva.setTipo(rs.getString(2));
                categoria.add(catIva);
            }
            return categoria;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
