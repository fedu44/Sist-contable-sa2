package Vista;

import Modelo.Cuenta;
import Modelo.GenerarPdf;
import Modelo.Renglon;
import Modelo.SqlAsientos;
import Modelo.SqlCuenta;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
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
        btnImprimir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

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

        btnImprimir.setText("imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resurces/pantera-band-1994.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnImprimir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnMostrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnMostrar))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnImprimir)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCuentaActionPerformed

    }//GEN-LAST:event_comboCuentaActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        
        desplegar();
        
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
       
        String[] cmd = {"cmd.exe", "/c", "mkdir PDF_Libro_Mayor"};
        ProcessBuilder builder = new ProcessBuilder(cmd);
        builder.redirectErrorStream(true);
        try {
            builder.start();
        } catch (Exception e) {
            System.out.println("por favor contacte al servicio tecnico");
        }
        
        String nombre ="PDF_Libro_Mayor\\" + this.comboCuenta.getSelectedItem().toString().replaceAll("[^A-Za-z]+", " ") +  ".pdf";
        new GenerarPdf(this.tModel,nombre);
        
        String[] commando = {"cmd.exe", "/c", nombre};
        builder = new ProcessBuilder(commando);
        builder.redirectErrorStream(true);
        try {
            builder.start();            
        } catch (Exception e) {
            System.out.println("por favor contacte al servicio tecnico");
        }
       
    }//GEN-LAST:event_btnImprimirActionPerformed

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
            limpiar();
            JOptionPane.showMessageDialog(null, "No hay asientos realizados en la cuenta indicada");
        }
   }
    
     private void limpiar(){
        this.tablaAsiento.removeAll();
            this.tablaAsiento.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Fecha", "Debe", "Haber", "Saldo_parcial"
                }
        ));
            this.tModel = (DefaultTableModel) tablaAsiento.getModel();
            
            
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JComboBox<String> comboCuenta;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaAsiento;
    // End of variables declaration//GEN-END:variables
}
