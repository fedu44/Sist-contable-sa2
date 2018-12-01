package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlCliente extends Conexion {

    public boolean agregarCliente(Cliente cliente) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO cliente(nombre, nombre_fiscal, cuit_cuil, calle, numero_casa, piso, depto, situacion_crediticia, bloqueado, tipo_cliente, periodo_validez, limite_credito, ultima_operacion, fecha_alta, categoria_iva, telefono, nota) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(3, cliente.getCuit_cuil());
            ps.setString(4, cliente.getCalle());
            ps.setInt(5, cliente.getNumeroCasa());
            ps.setString(6, cliente.getPiso());
            ps.setString(7, cliente.getDepto());
            ps.setInt(8, cliente.getSituacionCrediticia());
            ps.setBoolean(9, cliente.isBloqueado());
            ps.setInt(10, cliente.getTipoCliente());
            ps.setString(11, cliente.getPeriodoValidez());
            ps.setDouble(12, cliente.getLimiteCredito());
            ps.setString(13, cliente.getUltimaOperacion());
            ps.setString(14, cliente.getFechaAlta());
            ps.setInt(15, cliente.getCategoriaIva());
            ps.setInt(16, cliente.getTelefono());
            ps.setString(17, cliente.getNota());
            if (cliente.getCuit_cuil().substring(0, 2).equals("30")) {
                ps.setString(2, cliente.getNombre_nombreFiscal());
                ps.setString(1, null);
            } else {
                ps.setString(1, cliente.getNombre_nombreFiscal());
                ps.setString(2, null);
            }
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SqlCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
