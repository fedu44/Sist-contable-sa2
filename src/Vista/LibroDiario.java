package Vista;

import Modelo.Renglon;
import Modelo.SqlAsientos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LibroDiario extends javax.swing.JFrame {

    private ArrayList<Renglon> renglones = new ArrayList<>();
    private DefaultTableModel tModel;
    private String fechaD;
    private String fechaH;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public LibroDiario() {
        initComponents();
        //setSize(1400, 800);

        tModel = (DefaultTableModel) tablaAsiento.getModel();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radBtnGrupo = new javax.swing.ButtonGroup();
        panelReg = new javax.swing.JPanel();
        btnAtras = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAsiento = new javax.swing.JTable();
        btnAdelante = new javax.swing.JButton();
        btnIr = new javax.swing.JButton();
        jTextDiaD = new javax.swing.JTextField();
        jTextMesD = new javax.swing.JTextField();
        jTextAnioD = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextDiaH = new javax.swing.JTextField();
        jTextMesH = new javax.swing.JTextField();
        jTextAnioH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelReg.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAtras.setText("<");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        tablaAsiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hora", "Cuenta", "Debe", "Haber"
            }
        ));
        jScrollPane2.setViewportView(tablaAsiento);

        btnAdelante.setText(">");
        btnAdelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdelanteActionPerformed(evt);
            }
        });

        btnIr.setText("ir");
        btnIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrActionPerformed(evt);
            }
        });

        jTextDiaD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDiaDActionPerformed(evt);
            }
        });

        jTextMesD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMesDActionPerformed(evt);
            }
        });

        jLabel1.setText(" Dia                  Mes                Año");

        jLabel2.setText("Ej:         9                  9                  2018");

        jTextDiaH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDiaHActionPerformed(evt);
            }
        });

        jTextMesH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMesHActionPerformed(evt);
            }
        });

        jTextAnioH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAnioHActionPerformed(evt);
            }
        });

        jLabel3.setText("Desde:");

        jLabel4.setText("Hasta:");

        javax.swing.GroupLayout panelRegLayout = new javax.swing.GroupLayout(panelReg);
        panelReg.setLayout(panelRegLayout);
        panelRegLayout.setHorizontalGroup(
            panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdelante)
                .addGap(36, 36, 36))
            .addGroup(panelRegLayout.createSequentialGroup()
                .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRegLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRegLayout.createSequentialGroup()
                                .addComponent(jTextDiaH, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextMesH, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextAnioH, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRegLayout.createSequentialGroup()
                                .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelRegLayout.createSequentialGroup()
                                        .addComponent(jTextDiaD, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextMesD, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextAnioD, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnIr)))))
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(panelRegLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRegLayout.setVerticalGroup(
            panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextDiaD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextMesD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextAnioD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextDiaH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextMesH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextAnioH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRegLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnIr)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtras)
                    .addComponent(btnAdelante))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarRenglones(Renglon renglon) {
        String cuenta = renglon.getCuenta();
        double debe = renglon.getDebe();
        double haber = renglon.getHaber();
        String hora = renglon.getFecha();
        this.tModel.addRow(new Object[]{hora ,cuenta, debe, haber});
    }
    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed

        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, Integer.parseInt(jTextDiaD.getText()));
        c.set(Calendar.MONTH, Integer.parseInt(jTextMesD.getText()));
        c.set(Calendar.YEAR, Integer.parseInt(jTextAnioD.getText()));
        c.add(Calendar.DATE, -1);
        jTextAnioD.setText(String.valueOf(c.get(Calendar.YEAR)));
        jTextMesD.setText(String.valueOf(c.get(Calendar.MONTH)));
        jTextDiaD.setText(String.valueOf(c.get(Calendar.DATE)));
        desplegarAsientos();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdelanteActionPerformed

        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, Integer.parseInt(jTextDiaD.getText()));
        c.set(Calendar.MONTH, Integer.parseInt(jTextMesD.getText()));
        c.set(Calendar.YEAR, Integer.parseInt(jTextAnioD.getText()));
        c.add(Calendar.DATE, 1);
        jTextAnioD.setText(String.valueOf(c.get(Calendar.YEAR)));
        jTextMesD.setText(String.valueOf(c.get(Calendar.MONTH)));
        jTextDiaD.setText(String.valueOf(c.get(Calendar.DATE)));
        desplegarAsientos();

    }//GEN-LAST:event_btnAdelanteActionPerformed

    private void btnIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrActionPerformed

        desplegarAsientos();
    }//GEN-LAST:event_btnIrActionPerformed

    private void jTextMesDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMesDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMesDActionPerformed

    private void jTextDiaDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDiaDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDiaDActionPerformed

    private void jTextDiaHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDiaHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDiaHActionPerformed

    private void jTextMesHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMesHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMesHActionPerformed

    private void jTextAnioHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAnioHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAnioHActionPerformed

    private void limpiar() {

        this.renglones = new ArrayList<Renglon>();
        tablaAsiento.removeAll();
        for (int i = 0; i < renglones.size(); i++) {
            tModel.removeRow(i);
        }
        this.renglones.clear();
        this.tablaAsiento.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Hora","Cuenta", "Debe", "Haber"
                }
        ));
        this.tModel = (DefaultTableModel) tablaAsiento.getModel();

    }

    public void cerrar() {
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibroDiario().setVisible(true);
            }
        });
    }

    public void desplegarAsientos() {

        limpiar();
        SqlAsientos asiSql = new SqlAsientos();
        this.renglones = null;
        String diaD = jTextDiaD.getText();
        String mesD = jTextMesD.getText();
        String anioD = jTextAnioD.getText();
        this.fechaD = diaD + '-' + mesD + '-' + anioD;
        this.sdf.setLenient(false);
        try {
            Date date = this.sdf.parse(fechaD);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Fecha invalida");
        }
        this.fechaD = anioD + '-' + mesD + '-' + diaD;
        String diaH = jTextDiaH.getText();
        String mesH = jTextMesH.getText();
        String anioH = jTextAnioH.getText();
        this.fechaH = diaH + '-' + mesH + '-' + anioH;
        this.sdf.setLenient(false);
        try {
            Date date = this.sdf.parse(fechaH);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Fecha invalida");
        }
        this.fechaH = anioH + '-' + mesH + '-' + diaH;
        renglones = asiSql.asientoPorFecha(fechaD, fechaH);
        if (renglones != null) {
            renglones.forEach((renglon) -> {
                agregarRenglones(renglon);
            });
        } else {
            JOptionPane.showMessageDialog(null, "No hay asientos realizados en la fecha indicada");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdelante;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnIr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextAnioD;
    private javax.swing.JTextField jTextAnioH;
    private javax.swing.JTextField jTextDiaD;
    private javax.swing.JTextField jTextDiaH;
    private javax.swing.JTextField jTextMesD;
    private javax.swing.JTextField jTextMesH;
    private javax.swing.JPanel panelReg;
    private javax.swing.ButtonGroup radBtnGrupo;
    private javax.swing.JTable tablaAsiento;
    // End of variables declaration//GEN-END:variables

}
