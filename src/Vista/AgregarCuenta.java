
package Vista;

import Modelo.Cuenta;
import Modelo.SqlCuenta;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fragno
 */
public class AgregarCuenta extends javax.swing.JFrame {

    private ArrayList<Cuenta> cuentas = new ArrayList<>();
    private SqlCuenta sqlCt = new SqlCuenta();
    SqlCuenta sqlCuenta = new SqlCuenta();
    public AgregarCuenta() {
        initComponents();   
        iniciar();
    }
    
    private void iniciar(){
        this.cuentas = sqlCuenta.planCuenta();
        for(Cuenta c:this.cuentas  ){
            if (c.getRecibeSaldo()==false){
                System.out.println(c.getCodigo().substring(2));
                this.comboCuentas.addItem(c.getNombre()+" "+ c.getCodigo());
            }
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboCuentas = new javax.swing.JComboBox<>();
        txtNewCuenta = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rBtnRecibeSaldo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        comboCuentas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtNewCuenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNewCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewCuentaActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregar.setText("agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Cuenta padre:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        rBtnRecibeSaldo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rBtnRecibeSaldo.setText("Recibe saldo");
        rBtnRecibeSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnRecibeSaldoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtNewCuenta))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(btnAgregar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(rBtnRecibeSaldo)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNewCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(rBtnRecibeSaldo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        Cuenta padre = null ;
        for(Cuenta c : this.cuentas){
            if (c.getCodigo().substring(c.getCodigo().length()-3).
                    equals(this.comboCuentas.getSelectedItem().toString().
                            substring(this.comboCuentas.getSelectedItem().toString().length()-3))){
                padre=c;
                break;
            }
        }
        
          
        String codigoPadre = padre.getCodigo();
        int indx = codigoPadre.indexOf('0');
        System.out.println(indx);
        String newcod = codigoPadre.substring(0,indx);

        System.out.println(newcod);
        Integer cant =0;
        if (indx==2){
            for (Cuenta c : this.cuentas){
                if (c.getCodigo().substring(0,indx).equals(newcod)){
                    cant+=1;
                }
            }
            newcod=newcod + cant.toString();
        }else{
            for (Cuenta c : this.cuentas){
                if (c.getCodigo().substring(0,indx).equals(newcod) && 
                        c.getCodigo().substring(2).equals("0")){
                    cant+=1;
                }
            }
            newcod=newcod + cant.toString()+"0";
            
        }
        if (cant > 9){
            JOptionPane.showMessageDialog(null, "No se puenden agragar mas cuentas, invierta en un buen sistema");
            return;
        }
        
        System.out.println(newcod);
        if (!(this.rBtnRecibeSaldo.isSelected()) && !(newcod.substring(2).equals("0"))){
             JOptionPane.showMessageDialog(null, "Error! Cuenta hoja debe recibir saldo");
             return;
        }
        Cuenta newCuenta= new Cuenta();
        newCuenta.setCodigo(newcod);
        newCuenta.setRecibeSaldo(rBtnRecibeSaldo.isSelected());
        newCuenta.setEmpresa(padre.getEmpresa());
        newCuenta.setNombre(txtNewCuenta.getText());
        newCuenta.setTipo(padre.getTipo());
      
        if(this.sqlCt.agregar(newCuenta)){
             JOptionPane.showMessageDialog(null, "Cuenta agregada");
        }
       
        iniciar();
        clean();
        
       
    }//GEN-LAST:event_btnAgregarActionPerformed

    
    public void clean(){
        this.rBtnRecibeSaldo.setSelected(false);
        this.txtNewCuenta.setText("");
    }
    private void txtNewCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewCuentaActionPerformed

    private void rBtnRecibeSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnRecibeSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rBtnRecibeSaldoActionPerformed


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
            java.util.logging.Logger.getLogger(AgregarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarCuenta().setVisible(true);
            }
        });
    }

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> comboCuentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton rBtnRecibeSaldo;
    private javax.swing.JTextField txtNewCuenta;
    // End of variables declaration//GEN-END:variables
}