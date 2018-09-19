package Vista;

import Modelo.Asiento;
import Modelo.Asiento_cuenta;
import Modelo.Cuenta;
import Modelo.Renglon;
import Modelo.SqlAsiento_cuenta;
import Modelo.SqlAsientos;
import Modelo.SqlCuenta;
import Modelo.SqlUsuarios;
import Modelo.Usuario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

public class RegistrarAsiento extends javax.swing.JFrame {

    private static Usuario mod;
    private ArrayList<Renglon> renglones = new ArrayList<Renglon>();
    private DefaultTableModel tModel;
    //la jList lstRenglon muestra los elementos que contiene modelList
    private int asiento = 0;
    private ArrayList<Integer> asientos_cuenta = new ArrayList<Integer>();
    private ArrayList<Cuenta> cuentas = new ArrayList<>();

    public RegistrarAsiento(Usuario usr) {
        initComponents();
        //setSize(1400, 800);
        this.mod = usr;
        // la sentencia de abajo hay que probarlo solo con loguin
        txtUsuario.setText(usr.getNombre());
        SqlAsientos asiSql = new SqlAsientos();
        tModel = (DefaultTableModel) tablaAsiento.getModel();

        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String fecha = sdf.format(date);
        txtFecha.setText(fecha);
        txtNumAsiento.setText(String.valueOf((asiSql.ultimoNumAsiento()) + 1));
        if (txtNumAsiento.getText().equals("-1")) {
            JOptionPane.showMessageDialog(null, "Intente nuevamente");
            cerrar();
        }
        SqlCuenta sqlCuenta = new SqlCuenta();
        cuentas = sqlCuenta.nombreCuentasHoja();
        for (Cuenta cuenta : cuentas) {
            comboCuenta.addItem(cuenta.getNombre());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radBtnGrupo = new javax.swing.ButtonGroup();
        panelReg = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        txtFecha = new javax.swing.JLabel();
        comboCuenta = new javax.swing.JComboBox<>();
        txtMonto = new javax.swing.JTextField();
        txtDesc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        radBtnDebe = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        radBtnHaber = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAsiento = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtNumAsiento = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelReg.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        txtFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        comboCuenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {""}));
        comboCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboCuentaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comboCuentaMousePressed(evt);
            }
        });
        comboCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCuentaActionPerformed(evt);
            }
        });

        txtMonto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });

        txtDesc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Fecha");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cuenta");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Monto");

        radBtnGrupo.add(radBtnDebe);
        radBtnDebe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radBtnDebe.setText("Debe");
        radBtnDebe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBtnDebeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Descripcion");

        radBtnGrupo.add(radBtnHaber);
        radBtnHaber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radBtnHaber.setText("Haber");
        radBtnHaber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBtnHaberActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tipo");

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tablaAsiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cuenta", "Debe", "Haber"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaAsiento);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Numero de asiento");

        txtNumAsiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNumAsiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnLimpiar.setText("limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRegLayout = new javax.swing.GroupLayout(panelReg);
        panelReg.setLayout(panelRegLayout);
        panelRegLayout.setHorizontalGroup(
            panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar))
                    .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(btnRegistrar)
                            .addGap(238, 238, 238))
                        .addGroup(panelRegLayout.createSequentialGroup()
                            .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelRegLayout.createSequentialGroup()
                                        .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(89, 89, 89))
                                    .addGroup(panelRegLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)))
                                .addGroup(panelRegLayout.createSequentialGroup()
                                    .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(63, 63, 63)))
                            .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegLayout.createSequentialGroup()
                                    .addComponent(txtDesc)
                                    .addGap(26, 26, 26)
                                    .addComponent(btnAgregar)
                                    .addGap(91, 91, 91))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegLayout.createSequentialGroup()
                                    .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtMonto)
                                        .addComponent(comboCuenta, 0, 156, Short.MAX_VALUE)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNumAsiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelRegLayout.createSequentialGroup()
                                            .addGap(48, 48, 48)
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelRegLayout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(radBtnDebe)
                                            .addGap(18, 18, 18)
                                            .addComponent(radBtnHaber)))
                                    .addGap(0, 51, Short.MAX_VALUE)))))))
        );
        panelRegLayout.setVerticalGroup(
            panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegLayout.createSequentialGroup()
                        .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(txtNumAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radBtnDebe)
                    .addComponent(radBtnHaber)
                    .addComponent(jLabel6))
                .addGap(33, 33, 33)
                .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addGap(18, 18, 18)
                .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        String descripcion = txtDesc.getText();
        String cuenta = comboCuenta.getSelectedItem().toString();
        double debe = 0;
        double haber = 0;

        if (descripcion.equals("") || cuenta.equals("") || (radBtnDebe.isSelected() == false && radBtnHaber.isSelected() == false)) {

            JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los campos");
            return;
        }

        try {
            if (radBtnDebe.isSelected()) {
                debe = Double.parseDouble(txtMonto.getText());
            } else {
                haber = Double.parseDouble(txtMonto.getText());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Monto equivocado");
            return;
        }

        if (debe < 0 || haber < 0) {

            JOptionPane.showMessageDialog(null, "Monto negativo");

        } else {
            Renglon newRenglon = new Renglon(cuenta, debe, haber);
            this.renglones.add(newRenglon);
            if (haber > 0) {
                cuenta = "         " + cuenta;
            }
            this.tModel.addRow(new Object[]{cuenta, debe, haber});

            limpiar();
        }


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void radBtnHaberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBtnHaberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radBtnHaberActionPerformed

    private void radBtnDebeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBtnDebeActionPerformed

    }//GEN-LAST:event_radBtnDebeActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    private void comboCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCuentaActionPerformed

    }//GEN-LAST:event_comboCuentaActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        if (checkAsiento()) {;
            if (cuentaRepetida()) {
                JOptionPane.showMessageDialog(null, "Hay cuentas repetidas");
            } else {
                // Se agrega asiento en BD
                Date date = new Date();
                DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SqlAsientos sqlAsiento = new SqlAsientos();
                Asiento asiento = new Asiento();
                asiento.setNumAsiento(Integer.parseInt(txtNumAsiento.getText()));
                asiento.setDescripcion(txtDesc.getText());
                asiento.setFecha(fechaHora.format(date).toString());
                asiento.setUsuario(mod.getIdusuario());
                sqlAsiento.registrarAsiento(asiento);
                // Se agrega Asiento_cuenta en BD
                SqlAsiento_cuenta SqlAc = new SqlAsiento_cuenta();
                Asiento_cuenta ac = new Asiento_cuenta();
                SqlCuenta SqlCta = new SqlCuenta();
                Cuenta ctaN = new Cuenta();
                Cuenta ctaI = new Cuenta();
                double nuevoSaldo_parcial = -1;
                for (int i = 0; i < renglones.size(); i++) {
                    double saldo_parcial = -1;
                    ac.setDebe((int) renglones.get(i).getDebe());
                    ac.setHaber((int) renglones.get(i).getHaber());
                    ctaN.setNombre(renglones.get(i).getCuenta());
                    ac.setCuenta(SqlCta.idCuenta(ctaN));
                    if (ac.getCuenta() == -1) {
                        JOptionPane.showMessageDialog(null, "Cuenta inexistente");
                        break;
                    }
                    asiento.setIdasiento(sqlAsiento.ultimoIdAsiento());
                    ac.setAsiento(asiento.getIdasiento());
                    this.asiento = ac.getAsiento();
                    ctaI.setIdcuenta(SqlCta.idCuenta(ctaN));
                    saldo_parcial = SqlAc.saldoParcial(ctaI);
                    if (saldo_parcial == -1) {
                        JOptionPane.showMessageDialog(null, "Error de saldo de cuenta");
                        break;
                    }

                    switch (SqlCta.tipoCuenta(ctaN)) {
                        case "Activo":
                            nuevoSaldo_parcial = saldo_parcial + renglones.get(i).getDebe() - renglones.get(i).getHaber();
                            break;
                        case "Pasivo":
                            nuevoSaldo_parcial = saldo_parcial - renglones.get(i).getDebe() + renglones.get(i).getHaber();
                            break;
                        case "r-":
                            nuevoSaldo_parcial = saldo_parcial + renglones.get(i).getDebe();
                            break;
                        case "r+":
                            nuevoSaldo_parcial = saldo_parcial + renglones.get(i).getHaber();
                            break;
                        case "":
                            JOptionPane.showMessageDialog(null, "Error de carga de cuenta");
                            break;
                    }
                    if (nuevoSaldo_parcial < 0) {
                        JOptionPane.showMessageDialog(null, "Error de saldo de cuenta");
                        break;
                    }

                    ac.setSaldo_parcial(nuevoSaldo_parcial);
                    SqlAc.registrar(ac);
                    this.asientos_cuenta.add(ac.getIdasiento_cuenta());

                }

                if (nuevoSaldo_parcial == -1 || ac.getCuenta() == -1) {

                    corregirError();

                } else {
                    actualizarRegistrarAsiento();
                    JOptionPane.showMessageDialog(null, "Asiento guardado");

                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error cuenta no balanceada");

        }


    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        actualizarRegistrarAsiento();

    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void comboCuentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCuentaMousePressed

    }//GEN-LAST:event_comboCuentaMousePressed

    private void comboCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCuentaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCuentaMouseClicked

    private boolean checkAsiento() {
        //valida que el asiento este balanceado
        double sumHab = 0;
        double sumDeb = 0;
        for (Renglon rg : this.renglones) {
            sumDeb += rg.getDebe();
            sumHab += rg.getHaber();
        }
        if ((sumDeb == sumHab) && (sumDeb != 0)) {
            return true;
        } else {
            return false;
        }
    }

    private void limpiar() {
        txtMonto.setText("");
        radBtnGrupo.clearSelection();
    }

    public void cerrar() {
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarAsiento(mod).setVisible(true);
            }
        });
    }

    public void corregirError() {

        SqlAsiento_cuenta SqlAc = new SqlAsiento_cuenta();
        Asiento_cuenta ac = new Asiento_cuenta();
        SqlAsientos sqlAsiento = new SqlAsientos();
        Asiento asiento = new Asiento();

        for (Integer i : this.asientos_cuenta) {
            ac.setIdasiento_cuenta(i);
            SqlAc.eliminar(ac);
        }
        asiento.setIdasiento(this.asiento);
        sqlAsiento.eliminar(asiento);
    }

    public boolean cuentaRepetida() {

        for (int i = 0; i < renglones.size(); i++) {
            for (int n = i + 1; n < renglones.size(); n++) {
                if (renglones.get(i).getCuenta().equals(renglones.get(n).getCuenta())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void actualizarRegistrarAsiento() {

        SqlAsientos asiSql = new SqlAsientos();
        tModel = (DefaultTableModel) tablaAsiento.getModel();
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String fecha = sdf.format(date);
        txtFecha.setText(fecha);
        txtNumAsiento.setText(String.valueOf((asiSql.ultimoNumAsiento()) + 1));
        if (txtUsuario.getText().equals("-1")) {
            JOptionPane.showMessageDialog(null, "Intente nuevamente");
            cerrar();
        }
        renglones.removeAll(renglones);
        tablaAsiento.removeAll();
        for (int i = 0; i < renglones.size(); i++) {
            tModel.removeRow(i);
        }
        this.renglones.clear();
        this.tablaAsiento.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Cuenta", "Debe", "Haber"
                }
        ));
        this.tModel = (DefaultTableModel) tablaAsiento.getModel();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> comboCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelReg;
    private javax.swing.JRadioButton radBtnDebe;
    private javax.swing.ButtonGroup radBtnGrupo;
    private javax.swing.JRadioButton radBtnHaber;
    private javax.swing.JTable tablaAsiento;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JLabel txtNumAsiento;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables

}
