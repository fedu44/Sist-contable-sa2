package Vista;

import Modelo.SqlAsientos;
import Modelo.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Home extends javax.swing.JFrame {

    public static Borrar frmBorr;
    public static Registro frmReg;
    public static RegistrarAsiento frmRegAsis;
    public static LibroDiario frmLibDia;
    public static LibroMayor frmLibMay;
    public static PlanDeCuentas frmPlan;
    Usuario mod;

    public Home() {
        initComponents();
        setResizable(false);
        setSize(1400, 800);
        setLocationRelativeTo(null);
    }

    public Home(Usuario mod) {
        initComponents();
        setResizable(false);
        setSize(1400, 800);
        setLocationRelativeTo(null);
        this.mod = mod;

        switch (mod.getTipoUsuario()) {
            case 1:
                break;
            case 2:
                menuUsuarios.setVisible(false);
                subEliminarUsuario.setVisible(false);
                break;
            case 3:
                menuUsuarios.setVisible(false);
                subEliminarUsuario.setVisible(false);
                break;
            default:
                break;
        }
        this.jTxtUser.setText(mod.getNombre());
        Timer t = new Timer(1000, updateClockAction);
        t.start();

        SqlAsientos asiSql = new SqlAsientos();
        this.cantAsientos.setText(asiSql.cantidadAsientos(300, mod).toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gftfudttug = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTxtUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cantAsientos = new javax.swing.JLabel();
        jTxtReloj = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAsientoContable = new javax.swing.JMenu();
        subAgregarAsiento = new javax.swing.JMenuItem();
        menuLibroMayor = new javax.swing.JMenu();
        subVerLibroMayor = new javax.swing.JMenuItem();
        menuLibroDiario = new javax.swing.JMenu();
        subVerLibroDiario = new javax.swing.JMenuItem();
        menuUsuarios = new javax.swing.JMenu();
        subAgregarUsuario = new javax.swing.JCheckBoxMenuItem();
        subEliminarUsuario = new javax.swing.JCheckBoxMenuItem();
        menuPlanDeCuentas = new javax.swing.JMenu();
        subVerPlanDeCuentas = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gftfudttug.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resurces/pantera-band-1994.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Usuario:");

        jTxtUser.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("<html>Cantidad de asientos registrados<br/>en los últimos 30 días</html>");

        cantAsientos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jTxtReloj.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        menuAsientoContable.setText("Asientos contables");

        subAgregarAsiento.setText("Agregar asiento");
        subAgregarAsiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subAgregarAsientoActionPerformed(evt);
            }
        });
        menuAsientoContable.add(subAgregarAsiento);

        jMenuBar1.add(menuAsientoContable);

        menuLibroMayor.setText("Libro mayor");

        subVerLibroMayor.setText("Ver libro Mayor");
        subVerLibroMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subVerLibroMayorActionPerformed(evt);
            }
        });
        menuLibroMayor.add(subVerLibroMayor);

        jMenuBar1.add(menuLibroMayor);

        menuLibroDiario.setText("Libro Diario");

        subVerLibroDiario.setText("Ver libro diario");
        subVerLibroDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subVerLibroDiarioActionPerformed(evt);
            }
        });
        menuLibroDiario.add(subVerLibroDiario);

        jMenuBar1.add(menuLibroDiario);

        menuUsuarios.setText("Usuarios");

        subAgregarUsuario.setSelected(true);
        subAgregarUsuario.setText("Agregar");
        subAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subAgregarUsuarioActionPerformed(evt);
            }
        });
        menuUsuarios.add(subAgregarUsuario);

        subEliminarUsuario.setSelected(true);
        subEliminarUsuario.setText("Eliminar");
        subEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subEliminarUsuarioActionPerformed(evt);
            }
        });
        menuUsuarios.add(subEliminarUsuario);

        jMenuBar1.add(menuUsuarios);

        menuPlanDeCuentas.setText("Plan de cuentas");

        subVerPlanDeCuentas.setSelected(true);
        subVerPlanDeCuentas.setText("Ver plan de cuentas");
        subVerPlanDeCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subVerPlanDeCuentasActionPerformed(evt);
            }
        });
        menuPlanDeCuentas.add(subVerPlanDeCuentas);

        jMenuBar1.add(menuPlanDeCuentas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gftfudttug, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1057, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTxtReloj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jTxtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(cantAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gftfudttug, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subAgregarUsuarioActionPerformed

        if (frmReg == null) {
            frmReg = new Registro();
            frmReg.setVisible(true);
        }

    }//GEN-LAST:event_subAgregarUsuarioActionPerformed

    private void subEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subEliminarUsuarioActionPerformed

        if (frmBorr == null) {
            frmBorr = new Borrar();
            frmBorr.setVisible(true);
        }

    }//GEN-LAST:event_subEliminarUsuarioActionPerformed

    private void subAgregarAsientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subAgregarAsientoActionPerformed

        if (frmRegAsis == null) {
            frmRegAsis = new RegistrarAsiento(mod);
            frmRegAsis.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frmRegAsis.setVisible(true);
        }
    }//GEN-LAST:event_subAgregarAsientoActionPerformed

    private void subVerLibroDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subVerLibroDiarioActionPerformed

        if (frmLibDia == null) {
            frmLibDia = new LibroDiario();
            frmLibDia.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frmLibDia.setVisible(true);
        }
    }//GEN-LAST:event_subVerLibroDiarioActionPerformed

    private void subVerLibroMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subVerLibroMayorActionPerformed

        if (frmLibMay == null) {
            frmLibMay = new LibroMayor();
            frmLibMay.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frmLibMay.setVisible(true);
        }
    }//GEN-LAST:event_subVerLibroMayorActionPerformed

    private void subVerPlanDeCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subVerPlanDeCuentasActionPerformed

        if (frmPlan == null) {
            frmPlan = new PlanDeCuentas();
            frmPlan.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frmPlan.setVisible(true);
        }
    }//GEN-LAST:event_subVerPlanDeCuentasActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    ActionListener updateClockAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();

            jTxtReloj.setText(now.get(Calendar.HOUR_OF_DAY) + " : " + now.get(Calendar.MINUTE) + " : " + now.get(Calendar.SECOND));
        }
    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cantAsientos;
    private javax.swing.JLabel gftfudttug;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jTxtReloj;
    private javax.swing.JLabel jTxtUser;
    private javax.swing.JMenu menuAsientoContable;
    private javax.swing.JMenu menuLibroDiario;
    private javax.swing.JMenu menuLibroMayor;
    private javax.swing.JMenu menuPlanDeCuentas;
    private javax.swing.JMenu menuUsuarios;
    private javax.swing.JMenuItem subAgregarAsiento;
    private javax.swing.JCheckBoxMenuItem subAgregarUsuario;
    private javax.swing.JCheckBoxMenuItem subEliminarUsuario;
    private javax.swing.JMenuItem subVerLibroDiario;
    private javax.swing.JMenuItem subVerLibroMayor;
    private javax.swing.JCheckBoxMenuItem subVerPlanDeCuentas;
    // End of variables declaration//GEN-END:variables
}
