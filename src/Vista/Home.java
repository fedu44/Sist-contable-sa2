
package Vista;

import Modelo.Usuario;


public class Home extends javax.swing.JFrame {
    
    public static Borrar frmBorr;
    public static Registro frmReg;
    Usuario mod;
    
    public Home() {
        initComponents();
        setResizable(false);
        setSize(1400,800);
        setLocationRelativeTo(null);
    }
    
    public Home(Usuario mod)
    {
        initComponents();
        setResizable(false);
        setSize(1400,800);
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        menuImprimir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        menuImprimir.setText("Imprimir");
        jMenuBar1.add(menuImprimir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subAgregarUsuarioActionPerformed
        
        if(frmReg == null)
        {
            frmReg = new Registro();
            frmReg.setVisible(true);
        }
        
    }//GEN-LAST:event_subAgregarUsuarioActionPerformed

    private void subEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subEliminarUsuarioActionPerformed
        
        if (frmBorr == null)
        {
            Borrar frmBorrar = new Borrar();
            frmBorrar.setVisible(true);
        }
        
    }//GEN-LAST:event_subEliminarUsuarioActionPerformed

    private void subAgregarAsientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subAgregarAsientoActionPerformed
        
        RegistrarAsiento asiento = new RegistrarAsiento(mod);
        asiento.setVisible(true);
        
    }//GEN-LAST:event_subAgregarAsientoActionPerformed

    private void subVerLibroDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subVerLibroDiarioActionPerformed
        LibroDiario libroDiario = new LibroDiario();
        libroDiario.setVisible(true);
    }//GEN-LAST:event_subVerLibroDiarioActionPerformed

    private void subVerLibroMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subVerLibroMayorActionPerformed
        LibroMayor libroMayor = new LibroMayor();
        libroMayor.setVisible(true);
    }//GEN-LAST:event_subVerLibroMayorActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAsientoContable;
    private javax.swing.JMenu menuImprimir;
    private javax.swing.JMenu menuLibroDiario;
    private javax.swing.JMenu menuLibroMayor;
    private javax.swing.JMenu menuUsuarios;
    private javax.swing.JMenuItem subAgregarAsiento;
    private javax.swing.JCheckBoxMenuItem subAgregarUsuario;
    private javax.swing.JCheckBoxMenuItem subEliminarUsuario;
    private javax.swing.JMenuItem subVerLibroDiario;
    private javax.swing.JMenuItem subVerLibroMayor;
    // End of variables declaration//GEN-END:variables
}