package Vista;

import Modelo.Cuenta;
import Modelo.Renglon;
import Modelo.SqlAsientos;
import Modelo.SqlCuenta;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LibroMayor extends javax.swing.JFrame {

    private ArrayList<Cuenta> cuentas = new ArrayList<>();
    private ArrayList<Renglon> renglones = new ArrayList<>();
    private DefaultTableModel tModel;
    
    public LibroMayor() {
        initComponents();
        tModel = (DefaultTableModel) tablaAsiento.getModel();
        SqlCuenta sqlCuenta = new SqlCuenta();
        cuentas = sqlCuenta.nombreCuentasHoja();
        cuentas.forEach((cuenta) -> {
            comboCuenta.addItem(cuenta.getNombre());
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAsiento = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        comboCuenta = new javax.swing.JComboBox<>();
        btnMostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaAsiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Debe", "Haber", "Saldo_parcial"
            }
        ));
        jScrollPane2.setViewportView(tablaAsiento);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cuenta:");

        comboCuenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {""}));
        comboCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCuentaActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboCuenta, 0, 160, Short.MAX_VALUE)
                .addGap(64, 64, 64)
                .addComponent(btnMostrar)
                .addGap(135, 135, 135))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrar))
                .addContainerGap(295, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(140, 140, 140)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCuentaActionPerformed

    }//GEN-LAST:event_comboCuentaActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        
        desplegar();
        
    }//GEN-LAST:event_btnMostrarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibroMayor().setVisible(true);
            }
        });
    }
    
    private void agregarRenglones(Renglon renglon) {
        String hora = renglon.getFecha();
        double debe = renglon.getDebe();
        double haber = renglon.getHaber();
        double saldo_parcial = renglon.getSaldo_parcial();
        this.tModel.addRow(new Object[]{hora, debe, haber, saldo_parcial});
    }
    
    public void desplegar(){
        SqlAsientos asiSql = new SqlAsientos();
        renglones = asiSql.asientoCuentaPorFecha(comboCuenta.getSelectedItem().toString());
        if (renglones != null) {
            renglones.forEach((renglon) -> {
                agregarRenglones(renglon);
            });
        } else {
            JOptionPane.showMessageDialog(null, "No hay asientos realizados en la cuenta indicada");
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrar;
    private javax.swing.JComboBox<String> comboCuenta;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaAsiento;
    // End of variables declaration//GEN-END:variables
}
