package Vista;

import Modelo.Renglon;
import Modelo.SqlUsuarios;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

public class registrarAsiento extends javax.swing.JFrame {

    public registrarAsiento() {
        initComponents();
        //setSize(1400, 800);
        SqlUsuarios modSql = new SqlUsuarios();
        tModel=(DefaultTableModel)tablaAsiento.getModel();
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String fecha = sdf.format(date);
        txtFecha.setText(fecha);
        txtNumAsiento.setText(String.valueOf(modSql.ultimoAsiento()));
        if (txtNumAsiento.getText().equals("-1")) {
            JOptionPane.showMessageDialog(null, "Intente nuevamente");
            cerrar();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radBtnGrupo = new javax.swing.ButtonGroup();
        panelReg = new javax.swing.JPanel();
        txtNumAsiento = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelReg.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtNumAsiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNumAsiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        txtFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        comboCuenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
        jLabel1.setText("Numero de asiento");

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
                "Cuenta", "Debe", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(tablaAsiento);

        javax.swing.GroupLayout panelRegLayout = new javax.swing.GroupLayout(panelReg);
        panelReg.setLayout(panelRegLayout);
        panelRegLayout.setHorizontalGroup(
            panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegLayout.createSequentialGroup()
                            .addComponent(btnRegistrar)
                            .addGap(238, 238, 238))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegLayout.createSequentialGroup()
                            .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(panelRegLayout.createSequentialGroup()
                                    .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(panelRegLayout.createSequentialGroup()
                                                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44))
                                            .addGroup(panelRegLayout.createSequentialGroup()
                                                .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel1)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel3))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtNumAsiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(comboCuenta, 0, 95, Short.MAX_VALUE)))))
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(radBtnDebe)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(radBtnHaber))
                                .addGroup(panelRegLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(btnAgregar)))
                            .addGap(91, 91, 91)))))
        );
        panelRegLayout.setVerticalGroup(
            panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(txtNumAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        try{
        if (radBtnDebe.isSelected()) {
            debe = Double.parseDouble(txtMonto.getText());
        } else {
            haber = Double.parseDouble(txtMonto.getText());
        }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Monto equivocado");
            return;
        }

        if(debe < 0 || haber < 0){
            
            JOptionPane.showMessageDialog(null, "Monto negativo");
            
        }else{
        Renglon newRenglon = new Renglon(cuenta, descripcion, debe, haber);
        this.renglones.add(newRenglon);
        this.tModel.addRow(new Object[]{cuenta, debe,haber});

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
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCuentaActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private boolean checkAsiento() {
        //valida que el asiento este balanceado
        double sumHab = 0;
        double sumDeb = 0;
        for (Renglon rg : this.renglones) {
            sumDeb += rg.getDebe();
            sumHab += rg.getHaber();
        }
        if (sumDeb == sumHab) {
            JOptionPane.showMessageDialog(null, "Asiento guardado");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error cuenta no balanceada");
            return false;
        }
    }

    private void limpiar() {
        txtMonto.setText("");
        txtDesc.setText("");
        radBtnGrupo.clearSelection();
    }

    public void cerrar() {
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrarAsiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> comboCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    // End of variables declaration//GEN-END:variables

    private ArrayList<Renglon> renglones = new ArrayList<Renglon>();
    private DefaultTableModel tModel;
    //la jList lstRenglon muestra los elementos que contiene modelList

    
}
