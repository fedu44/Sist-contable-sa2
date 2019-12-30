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

    public ArrayList<Renglon> buscarPorArticulo() {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        PreparedStatement ps2 = null;
        ResultSet rs2 = null;
        Connection con = getConexion();
        ArrayList<Renglon> renglones = new ArrayList<>();
        
        String sql = "SELECT nombre, descripcion, count(*) FROM articulo where estado = 'disponible' GROUP BY descripcion";
        String sql2 = "SELECT count(*), descripcion, nombre FROM articulo where estado = 'reservado' GROUP BY descripcion";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ps2 = con.prepareStatement(sql2);
            rs2 = ps2.executeQuery();
            rs2.next();
            while(rs.next()) {
                Renglon renglon;  
                if(rs2.isAfterLast()){
                    if(rs.getString(2).equals(rs2.getString(2))){
                        renglon = new Renglon(rs.getString(1), rs.getInt(3) - rs2.getInt(1), rs.getString(2), rs.getInt(3));
                        rs2.next();
                    }else{
                        renglon = new Renglon(rs.getString(1), rs.getInt(3), rs.getString(2), rs.getInt(3));
                    }
                    renglones.add(renglon);
                }else{
                    renglon = new Renglon(rs.getString(1), rs.getInt(3), rs.getString(2), rs.getInt(3));
                    renglones.add(renglon);
                }
                
            }
            Renglon renglon;
            if(rs2.isAfterLast()){   
                renglon = new Renglon(rs2.getString(3), 0, rs2.getString(2), rs2.getInt(1));
                renglones.add(renglon);
                return renglones;
            }else{
                while(rs2.next()){
                    renglon = new Renglon(rs2.getString(3), 0, rs2.getString(2), rs2.getInt(1));
                    renglones.add(renglon);
                }
            return renglones;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<Renglon> buscarArticulo(String nom, int fam, int mad) {
        
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;

        ResultSet rs = null;
        ResultSet rs2 = null;
        Connection con = getConexion();
        ArrayList<Renglon> renglones = new ArrayList<>();
        
        String sql = "SELECT a.nombre, a.descripcion, count(*) FROM articulo a INNER JOIN articulo_familia af on(a.idarticulo = af.articulo) INNER JOIN familia f on (f.idfamilia = af.familia) WHERE a.estado = 'disponible' and a.nombre = ? and a.madera = ? and f.idfamilia = ? GROUP BY a.descripcion";
        String sql2 = "SELECT count(*), a.descripcion FROM articulo a INNER JOIN articulo_familia af on(a.idarticulo = af.articulo) INNER JOIN familia f on (f.idfamilia = af.familia) WHERE a.estado = 'reservado' and a.nombre = ? and a.madera = ? and f.idfamilia = ? GROUP BY a.descripcion";

        try {
            ps = con.prepareStatement(sql);
            ps2 = con.prepareStatement(sql2);

            ps.setString(1, nom);
            ps.setInt(2, mad);
            ps.setInt(3, fam);
            rs = ps.executeQuery();
            
            ps2.setString(1, nom);
            ps2.setInt(2, mad);
            ps2.setInt(3, fam);
            rs2 = ps2.executeQuery();
            rs2.next();
            while(rs.next()) {
                Renglon renglon;
                if(rs.getString(2).equals(rs2.getString(2))){
                    renglon = new Renglon(rs.getString(1), rs.getInt(3) - rs2.getInt(1), rs.getString(2), rs.getInt(3));
                    rs2.next();
                }else{
                    renglon = new Renglon(rs.getString(1), rs.getInt(3), rs.getString(2), rs.getInt(3));
                }
                renglones.add(renglon);
            }
            return renglones;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
