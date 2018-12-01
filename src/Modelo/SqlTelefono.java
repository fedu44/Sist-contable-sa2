package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlTelefono extends Conexion {

    public int agregarTelefono(String tel) {

        PreparedStatement ps = null;
        Connection con = getConexion();
        SqlTelefono sqlTel = new SqlTelefono();

        String sql = "INSERT INTO telefono(numero) values(?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tel);
            ps.execute();
            return sqlTel.idTelefono(tel);
        } catch (SQLException ex) {
            Logger.getLogger(SqlTelefono.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
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

}
