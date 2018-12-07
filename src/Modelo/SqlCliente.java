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

        String sql = "INSERT INTO cliente(nombre, nombre_fiscal, cuit_cuil, calle, numero_casa, piso, depto, situacion_crediticia, bloqueado, tipo_cliente, periodo_validez, limite_credito, ultima_operacion, fecha_alta, categoria_iva, nota, contacto) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
            ps.setString(16, cliente.getNota());
            ps.setString(17, cliente.getContacto());
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

    public ArrayList<Renglon> clientes() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        ArrayList<Renglon> renglones = new ArrayList<>();

        String sql = "SELECT cl.nombre, cl.nombre_fiscal, cl.cuit_cuil, sc.nombre, cl.limite_credito, cl.fecha_alta FROM cliente cl INNER JOIN situacion_crediticia sc ON(cl.situacion_crediticia = sc.idsituacion_crediticia)";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.first()) {
                if (rs.getString(2) == null) {
                    Renglon renglon = new Renglon(rs.getString(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                    renglones.add(renglon);
                    while (rs.next()) {
                        Renglon renglon2 = new Renglon(rs.getString(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                        renglones.add(renglon2);
                    }
                    return renglones;
                } else {
                    Renglon renglon = new Renglon(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                    renglones.add(renglon);
                    while (rs.next()) {
                        Renglon renglon2 = new Renglon(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                        renglones.add(renglon2);
                    }
                    return renglones;
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public Cliente traerCliente(String cuit_cuil) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        Cliente cliente = new Cliente();

        String sql = "SELECT nombre, nombre_fiscal, cuit_cuil, calle, numero_casa, piso, depto, situacion_crediticia, bloqueado, tipo_cliente, periodo_validez, limite_credito, categoria_iva, nota, contacto, idcliente FROM cliente WHERE cuit_cuil = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cuit_cuil);
            rs = ps.executeQuery();

            if (rs.next()) {
                cliente.setCuit_cuil(rs.getString(3));
                cliente.setCalle(rs.getString(4));
                cliente.setNumeroCasa(rs.getInt(5));
                cliente.setPiso(rs.getString(6));
                cliente.setDepto(rs.getString(7));
                cliente.setSituacionCrediticia(rs.getInt(8));
                cliente.setBloqueado(rs.getBoolean(9));
                cliente.setTipoCliente(rs.getInt(10));
                cliente.setPeriodoValidez(rs.getString(11));
                cliente.setLimiteCredito(rs.getDouble(12));
                cliente.setCategoriaIva(rs.getInt(13));
                cliente.setNota(rs.getString(14));
                cliente.setContacto(rs.getString(15));
                cliente.setId(rs.getInt(16));
                if (cliente.getCuit_cuil().substring(0, 2).equals("30")) {
                    cliente.setNombre_nombreFiscal(rs.getString(2));
                } else {
                    cliente.setNombre_nombreFiscal(rs.getString(1));
                }
                return cliente;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(SqlCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean actualizarCliente(int id, Cliente cliente) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE cliente SET nombre = ?, nombre_fiscal = ?, cuit_cuil = ?, calle = ?, numero_casa = ?, piso = ?, depto = ?, situacion_crediticia = ?, bloqueado = ?, categoria_iva = ?, nota = ?, contacto = ?, limite_credito = ?  WHERE idcliente = ? ";

        try {
            ps = con.prepareStatement(sql);
            if (cliente.getCuit_cuil().substring(0, 2).equals("30")) {
                ps.setString(1, null);
                ps.setString(2, cliente.getNombre_nombreFiscal());
            } else {
                ps.setString(2, null);
                ps.setString(1, cliente.getNombre_nombreFiscal());
            }
            ps.setString(3, cliente.getCuit_cuil());
            ps.setString(4, cliente.getCalle());
            ps.setInt(5, cliente.getNumeroCasa());
            ps.setString(6, cliente.getPiso());
            ps.setString(7, cliente.getDepto());
            ps.setInt(8, cliente.getSituacionCrediticia());
            ps.setBoolean(9, cliente.isBloqueado());
            ps.setInt(10, cliente.getCategoriaIva());
            ps.setString(11, cliente.getNota());
            ps.setString(12, cliente.getContacto());
            ps.setInt(13, id);
            ps.setDouble(14, cliente.getLimiteCredito());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SqlCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
