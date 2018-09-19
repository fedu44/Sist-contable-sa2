package Vista;

import Modelo.Cuenta;
import Modelo.SqlCuenta;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class PlanDeCuentas extends javax.swing.JFrame {

    private ArrayList<Cuenta> cuentas = new ArrayList<>();
    private DefaultTableModel tModel;
    private Integer cantColumnas;

    public PlanDeCuentas() {
        initComponents();
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
            row[0] = c.getCodigo();
            int i = c.getCodigo().indexOf("0");
            System.out.println(i);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaPlan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaPlan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(182, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPlan;
    // End of variables declaration//GEN-END:variables
}
