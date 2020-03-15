package Vista;

import Modelo.Asiento;
import Modelo.Asiento_cuenta;
import Modelo.Cliente;
import Modelo.Cuenta;
import Modelo.GenerarFactura;
import Modelo.GenerarPdf;
import Modelo.Renglon;
import Modelo.SqlAsiento_cuenta;
import Modelo.SqlAsientos;
import Modelo.SqlCliente;
import Modelo.Usuario;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PreVenta extends javax.swing.JFrame {

    private ArrayList<Renglon> renglones = new ArrayList<>();
    private DefaultTableModel tModel;
    private static double total;
    private ArrayList<ArrayList<Integer>> elementosPorComprar = new ArrayList<>();
    private Boolean esCredito;
    private Boolean esContado;
    private static int userId;
    private JTable tabla;
    private static StockManual screen;

    public double getTotal() {
        return PreVenta.total;
    }

    public void setTotal(double total, Usuario mod) {
        PreVenta.total = total;
    }

    public ArrayList<ArrayList<Integer>> getElementosPorComprar() {
        return elementosPorComprar;
    }

    public void setElementosPorComprar(ArrayList<ArrayList<Integer>> elementosPorComprar) {
        this.elementosPorComprar = elementosPorComprar;
    }

    public Boolean getEsCredito() {
        return esCredito;
    }

    public void setEsCredito(Boolean esCredito) {
        this.esCredito = esCredito;
    }

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        PreVenta.userId = userId;
    }

    public Boolean getEsContado() {
        return esContado;
    }

    public void setEsContado(Boolean esContado) {
        this.esContado = esContado;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public PreVenta(double total, int userId, StockManual screen) {
        initComponents();
        PreVenta.total = total;
        PreVenta.userId = userId;
        this.setResizable(false);
        btnInmediato.doClick();
        desplegar("");
        this.esCredito = false;
        this.esContado = true;
        this.screen = screen;
    }

    private void agregarRenglones(Renglon renglon) {
        String nombre = renglon.getNombre();
        String cuit_cuil = renglon.getCuit_cuil();
        String situacion_crediticia = renglon.getSituacion_crediticia();
        String fecha = renglon.getFecha_alta();
        String limite = renglon.getLimite_credito();
        this.tModel.addRow(new Object[]{nombre, cuit_cuil, situacion_crediticia, limite, fecha});
    }

    public void desplegar(String nombre) {
        limpiar();
        tModel = (DefaultTableModel) tblCli.getModel();
        SqlCliente sqlCli = new SqlCliente();
        if (nombre.equals("")) {
            renglones = sqlCli.clientes();
        } else {
            renglones = sqlCli.clientesPorNombre(nombre);
        }

        if (renglones != null) {
            renglones.forEach((renglon) -> {
                agregarRenglones(renglon);
            });
        } else {
            JOptionPane.showMessageDialog(null, "No hay clientes cargados");
        }
    }

    public void limpiar() {

        this.renglones = new ArrayList<Renglon>();
        tblCli.removeAll();
        for (int i = 0; i < renglones.size(); i++) {
            tModel.removeRow(i);
        }
        this.renglones.clear();
        this.tblCli.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nombre", "Cuit/Cuil", "Situacion crediticia", "Límite", "Fecha de alta"
                }
        ));
        this.tModel = (DefaultTableModel) tblCli.getModel();

    }

    public void factura() {

        int selectedRow = tblCli.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun cliente");
            return;
        }
        Renglon r = this.renglones.get(selectedRow);
        SqlCliente sqlCli = new SqlCliente();
        Cliente cli = sqlCli.traerCliente(r.getCuit_cuil());

        ArrayList<String> leftheader = new ArrayList<>();
        leftheader.add("SpaceX");
        leftheader.add("Roque Saenz Pena 511");
        leftheader.add("Resposable Inscripto");
        leftheader.add(" ");
        leftheader.add(" ");
        leftheader.add(" ");
        leftheader.add(" ");
        leftheader.add("Nombre: " + cli.getNombre_nombreFiscal());
        leftheader.add("direccion: " + cli.getCalle());
        leftheader.add("contacto: " + cli.getContacto());

        ArrayList<String> rightHeader = new ArrayList<>();
        rightHeader.add("Factura");
        Random rnd = new Random();
        Long n = 1000000000+ rnd.nextLong();
        rightHeader.add("nro: 2002-" + n.toString().substring(0, 9));
        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        rightHeader.add("fecha: " + (String) fecha.format(new Date()));
        rightHeader.add("CUIT: 30-68720025-6");
        rightHeader.add("ing. Brutos: 9016712847");
        rightHeader.add("Inicio de Actividad: 10-09-2019");
        rightHeader.add(" ");

        rightHeader.add("CUIT: " + cli.getCuit_cuil());
        if (cmbCuotas.isEnabled()) {
            rightHeader.add("Cond venta: cuotas");
        } else {
            rightHeader.add("Cond venta: contado");
        }
        leftheader.add("condicion iva: Consumidor Final");

        String nombre = "factura.pdf";
        new GenerarFactura(this.tabla, leftheader, rightHeader, nombre, getTotal());
        String[] commando = {"cmd.exe", "/c", nombre};
        ProcessBuilder builder = new ProcessBuilder(commando);
        builder.redirectErrorStream(true);
        try {
            builder.start();
        } catch (Exception e) {
            System.out.println("por favor contacte al servicio tecnico");
        }
    }

    public void venta() {

        double total = getTotal();
        SqlAsientos sqlAsientos = new SqlAsientos();
        SqlAsiento_cuenta sqlAsientos_cuenta = new SqlAsiento_cuenta();
        int ultimoCodigo = sqlAsientos.ultimoNumAsiento() + 1;
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Asiento asiento = new Asiento(ultimoCodigo, fechaHora.format(new Date()), "Venta", getUserId());
        sqlAsientos.registrarAsiento(asiento);
        Cuenta cuenta;
        double saldoParcial;
        int ultimoCodigoAsientoCuenta = sqlAsientos_cuenta.ultimoCodigo();
        int ultimoIdAsiento = sqlAsientos.ultimoIdAsiento();
        Asiento_cuenta asiento_cuenta;

        if (!getEsCredito()) {
            if (getEsContado()) {
                // Cuenta Caja
                cuenta = new Cuenta(6, "Activo", "Caja", 1, "111", true);
                saldoParcial = sqlAsientos_cuenta.saldoParcial(cuenta);
                asiento_cuenta = new Asiento_cuenta(total, 0, 6, ultimoIdAsiento, saldoParcial + total, ultimoCodigoAsientoCuenta + 1);
                sqlAsientos_cuenta.registrar(asiento_cuenta);
            } else {
                // Cuenta Banco c/c
                cuenta = new Cuenta(8, "Activo", "Banco c/c", 1, "113", true);
                saldoParcial = sqlAsientos_cuenta.saldoParcial(cuenta);
                asiento_cuenta = new Asiento_cuenta(total, 0, 8, ultimoIdAsiento, saldoParcial + total, ultimoCodigoAsientoCuenta + 1);
                sqlAsientos_cuenta.registrar(asiento_cuenta);
            }
        } else {
            // Cuenta Deudores por ventas
            cuenta = new Cuenta(10, "Activo", "Deudores por ventas", 1, "121", true);
            saldoParcial = sqlAsientos_cuenta.saldoParcial(cuenta);
            asiento_cuenta = new Asiento_cuenta(total, 0, 10, ultimoIdAsiento, saldoParcial + total, ultimoCodigoAsientoCuenta + 1);
            sqlAsientos_cuenta.registrar(asiento_cuenta);
        }
        // Cuenta Venta
        cuenta.setIdcuenta(32);
        cuenta.setCodigo("411");
        cuenta.setNombre("Venta");
        cuenta.setTipo("Ingresos");
        saldoParcial = sqlAsientos_cuenta.saldoParcial(cuenta);
        asiento_cuenta = new Asiento_cuenta(0, total, 32, ultimoIdAsiento, saldoParcial + total, ultimoCodigoAsientoCuenta + 2);
        sqlAsientos_cuenta.registrar(asiento_cuenta);

        // TODO: Calcular cmv
        double cmv = total * 0.9;

        // AC-CMV
        cuenta.setIdcuenta(36);
        cuenta.setCodigo("510");
        cuenta.setNombre("Costo Mercaderia Vendida");
        cuenta.setTipo("Egresos");
        saldoParcial = sqlAsientos_cuenta.saldoParcial(cuenta);
        ultimoIdAsiento = sqlAsientos.ultimoIdAsiento();
        asiento_cuenta = new Asiento_cuenta(cmv, 0, 36, ultimoIdAsiento, saldoParcial + cmv, ultimoCodigoAsientoCuenta + 3);
        sqlAsientos_cuenta.registrar(asiento_cuenta);
        // AC-Mercaderia
        cuenta.setIdcuenta(14);
        cuenta.setCodigo("131");
        cuenta.setNombre("Mercaderias");
        cuenta.setTipo("Activo");
        saldoParcial = sqlAsientos_cuenta.saldoParcial(cuenta);
        ultimoIdAsiento = sqlAsientos.ultimoIdAsiento();
        asiento_cuenta = new Asiento_cuenta(0, cmv, 14, ultimoIdAsiento, saldoParcial - cmv, ultimoCodigoAsientoCuenta + 4);
        sqlAsientos_cuenta.registrar(asiento_cuenta);

        factura();
        Home.frmStoMan = null;
        Home.frmPreVen = null;
        screen.dispose();
        this.dispose();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnInmediato = new javax.swing.JButton();
        btnCredito = new javax.swing.JButton();
        btnFactura = new javax.swing.JButton();
        pnlCredito = new javax.swing.JPanel();
        cmbCuotas = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblCuotas = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCli = new javax.swing.JTable();
        chkDeb = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnInmediato.setText("Pago inmediato");
        btnInmediato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInmediatoActionPerformed(evt);
            }
        });

        btnCredito.setText("Crédito");
        btnCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditoActionPerformed(evt);
            }
        });

        btnFactura.setText("Generar factura");
        btnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaActionPerformed(evt);
            }
        });

        pnlCredito.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmbCuotas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"2", "3", "6", "12" }));
        cmbCuotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCuotasActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar nombre");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblCuotas.setText("Cantidad de cuotas:");

        tblCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cuit/Cuil", "Categoria de iva", "Limite de credito", "Fecha de alta"
            }
        ));
        jScrollPane2.setViewportView(tblCli);

        chkDeb.setText("Débito");
        chkDeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDebActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCreditoLayout = new javax.swing.GroupLayout(pnlCredito);
        pnlCredito.setLayout(pnlCreditoLayout);
        pnlCreditoLayout.setHorizontalGroup(
            pnlCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCreditoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkDeb, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCuotas)
                .addGap(44, 44, 44)
                .addComponent(cmbCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCreditoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlCreditoLayout.setVerticalGroup(
            pnlCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCreditoLayout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addGroup(pnlCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkDeb))
                .addContainerGap())
            .addGroup(pnlCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCreditoLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(161, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFactura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnInmediato, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(btnCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInmediato)
                    .addComponent(btnCredito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(btnFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        desplegar(txtNombre.getText());

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed

        if (getEsCredito()) {
            int fila = tblCli.getSelectedRow();
            if (fila != -1) {
                Usuario mod = Home.mod;
                int limiteDeCredito = Integer.parseInt(renglones.get(fila).getLimite_credito());
                switch (renglones.get(fila).getSituacion_crediticia()) {
                    case "Normal":
                        // Efectuar venta a credito
                        venta();
                        break;
                    case "Atrasado":
                        // No total a pagar mayor a la deuda actual
                        if (limiteDeCredito > 0 && ((limiteDeCredito - getTotal() > 0) || ( Math.abs(limiteDeCredito - getTotal()) < limiteDeCredito/4))) {
                            JOptionPane.showMessageDialog(null, "El cliente está atrasado, solo puede efectuarse ventas a crédito menor a la deuda actualo regularizar la deuda.");
                        } else {
                            // Efectuar venta a credito
                            venta();
                        }
                        break;
                    case "Seguimiento especial":
                        // Solo admin le puede vender o cambiar situación crediticia
                        if(mod.getTipoUsuario() != 1){
                            JOptionPane.showMessageDialog(null, "El cliente está bajo seguimiento especial y no puede efectuarse venta a crédito. Regularice la deuda o pida al administrador ejecutar la venta");
                            break;
                        }else{
                            venta();
                        }
                        break;
                    case "Riesgo de insolvencia":
                        // No se le puede vender a credito
                        JOptionPane.showMessageDialog(null, "El cliente tiene riesgo de insolvencia, no puede efectuarse venta a crédito");
                        break;
                    case "Incobrable":
                        // No se le puede vender a credito
                        JOptionPane.showMessageDialog(null, "El cliente es incobrable, no puede efectuarse venta a crédito");
                        break;
                }
                // Actualizar limite de credito de cliente
                SqlCliente sqlCli = new SqlCliente();
                Cliente cliente = sqlCli.traerCliente(renglones.get(fila).getCuit_cuil());
                cliente.setLimiteCredito(limiteDeCredito - getTotal());
                sqlCli.actualizarCliente(cliente.getId(), cliente);
            } else {
                JOptionPane.showMessageDialog(null, "No hay cliente seleccionado");
            }
        } else {
            // Efectuar venta a contado
            venta();
        }

    }//GEN-LAST:event_btnFacturaActionPerformed

    private void btnInmediatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInmediatoActionPerformed

        btnBuscar.setEnabled(false);
        txtNombre.setEditable(false);
        txtNombre.setBackground(new Color(255, 255, 255, 80));
        cmbCuotas.setEnabled(false);
        tblCli.setRowSelectionAllowed(false);
        setEsCredito(false);
        chkDeb.setEnabled(true);

    }//GEN-LAST:event_btnInmediatoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        Home.frmPreVen = null;
        this.dispose();

    }//GEN-LAST:event_formWindowClosing

    private void cmbCuotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCuotasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCuotasActionPerformed

    private void btnCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditoActionPerformed

        btnBuscar.setEnabled(true);
        txtNombre.setEditable(true);
        txtNombre.setBackground(Color.WHITE);
        cmbCuotas.setEnabled(true);
        tblCli.setRowSelectionAllowed(true);
        setEsCredito(true);
        chkDeb.setEnabled(false);

    }//GEN-LAST:event_btnCreditoActionPerformed

    private void chkDebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDebActionPerformed

        setEsContado(!getEsContado());

    }//GEN-LAST:event_chkDebActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PreVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PreVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PreVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PreVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PreVenta(total, userId, screen).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCredito;
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnInmediato;
    private javax.swing.JCheckBox chkDeb;
    private javax.swing.JComboBox<String> cmbCuotas;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCuotas;
    private javax.swing.JPanel pnlCredito;
    private javax.swing.JTable tblCli;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
