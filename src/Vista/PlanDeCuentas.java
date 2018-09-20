package Vista;

import Modelo.Cuenta;
import Modelo.GenerarPdf;
import Modelo.SqlCuenta;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class PlanDeCuentas extends javax.swing.JFrame {

    private ArrayList<Cuenta> cuentas = new ArrayList<>();
    private DefaultTableModel tModel;
    private Integer cantColumnas;

    public PlanDeCuentas() {
        initComponents();
        this.setResizable(false);
        
        SqlCuenta sqlCuenta = new SqlCuenta();
        this.cuentas = sqlCuenta.planCuenta();

        this.cantColumnas = cantColumnas();
        tModel = (DefaultTableModel) tablaPlan.getModel();
        tModel.addColumn("Codigo");
        for (int i = 0; i < this.cantColumnas; i++) {
            tModel.addColumn("Cuenta");
        }
        carga();

    }

    private Integer cantColumnas() {
        Integer max = 0;
        for (Cuenta c : cuentas) {
            if (c.getCodigo().length() > max) {
                max = c.getCodigo().length();
            }
        }
        return max;
    }

    private void carga() {

        for (Cuenta c : this.cuentas) {
            Object row[] = new Object[cantColumnas + 1];
            for (int i=0;i< cantColumnas+1;i++){
                row[i]="";
            }
            row[0] = c.getCodigo();
            int i = c.getCodigo().indexOf("0");
            if (i == -1) {
                row[cantColumnas] = c.getNombre();
            } else {
                row[i] = c.getNombre();
            }
            tModel.addRow(row);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPlan = new javax.swing.JTable();
        btnImprimir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaPlan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaPlan);

        btnImprimir.setText("imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\fragno\\Documents\\prog\\java\\Sist-contable-sa2\\pantera-band-1994.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImprimir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImprimir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        
        
        String nombre = "PDF_Plan_De_Cunta" + ".pdf";
        new GenerarPdf(this.tModel,nombre);
        
        String[] commando = {"cmd.exe", "/c", nombre};
        ProcessBuilder builder = new ProcessBuilder(commando);
        builder.redirectErrorStream(true);
        try {
            builder.start();            
        } catch (Exception e) {
            System.out.println("por favor contacte al servicio tecnico");
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlanDeCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlanDeCuentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPlan;
    // End of variables declaration//GEN-END:variables
}
