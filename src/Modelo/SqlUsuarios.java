package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SqlUsuarios extends Conexion {

    public boolean registrar(Usuario usr) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO usuarios (nombre, contrasena, tipoUsuario) VALUES (?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getNombre());
            ps.setString(2, usr.getContrasena());
            ps.setInt(3, usr.getTipoUsuario());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean login(Usuario usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT u.idusuarios, u.nombre, u.contrasena, u.tipoUsuario, t.nombre FROM usuarios As u INNER JOIN tipo_usuario AS t on(u.tipoUsuario = t.idtipo_usuario) WHERE u.nombre = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getNombre());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (usr.getContrasena().equals(rs.getString(3))) {
                    usr.setIdusuario(rs.getInt(1));
                    usr.setNombre((rs.getString(2)));
                    usr.setTipoUsuario(rs.getInt(4));
                    usr.setNombreTipo(rs.getString(5));
                    return true;
                } else {
                    return false;
                }

            }

            return false;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public int existeUsuario(String usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT count(u.idusuarios) FROM usuarios AS u WHERE u.nombre = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 1;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }

    }

    public boolean borrar(String usuario) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        if (existeUsuario(usuario) == 1) {

            String sql = "DELETE FROM usuarios WHERE nombre = ?";

            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, usuario);
                ps.execute();
                System.out.println(1);
                return true;

            } catch (SQLException ex) {
                Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(3);
                return false;
            }

        }
        System.out.println(2);
        return false;
    }
    

}
