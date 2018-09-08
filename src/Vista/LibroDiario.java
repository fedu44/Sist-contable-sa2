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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

public class LibroDiario extends javax.swing.JFrame {

    private ArrayList<Renglon> renglones = new ArrayList<Renglon>();
    private DefaultTableModel tModel;
    private String fecha;
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
        jTextDia = new javax.swing.JTextField();
        jTextMes = new javax.swing.JTextField();
        jTextAnio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

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
                "Cuenta", "Debe", "Haber"
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

        jTextMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMesActionPerformed(evt);
            }
        });

        jLabel1.setText(" DIa                  Mes                Año");

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
                        .addGap(124, 124, 124)
                        .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRegLayout.createSequentialGroup()
                                .addComponent(jTextDia, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextMes, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnIr)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelRegLayout.setVerticalGroup(
            panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIr))
                .addGap(50, 50, 50)
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

    
    private void agregarRenglones(Renglon renglon){
        String cuenta = renglon.getCuenta();
        double debe = renglon.getDebe();
        double haber = renglon.getHaber();
        this.tModel.addRow(new Object[]{cuenta, debe, haber});
    }
    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        
        Calendar c = Calendar.getInstance();
        try{
        c.setTime(sdf.parse(this.fecha));
        }catch(ParseException ex){
            JOptionPane.showMessageDialog(null, "asodsoaidj");
        }
        c.add(Calendar.DATE, -1);  
        this.fecha = sdf.format(c.getTime()); 
        

    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdelanteActionPerformed
        
        
        Calendar c = Calendar.getInstance();
        try{
        c.setTime(sdf.parse(this.fecha));
        }catch(ParseException ex){
            JOptionPane.showMessageDialog(null, "asodsoaidj");
        }
        c.add(Calendar.DATE, 1);  
        this.fecha = sdf.format(c.getTime()); 
        
    }//GEN-LAST:event_btnAdelanteActionPerformed

    private void btnIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrActionPerformed
        
        SqlAsientos asiSql = new SqlAsientos();
        this.renglones = null;
        Asiento asi = new Asiento();
        String dia = jTextDia.getText();
        String mes = jTextMes.getText();
        String anio = jTextAnio.getText();
        this.fecha = dia + '-' + mes + '-' + anio;
        this.sdf.setLenient(false);
        try {
            Date date = this.sdf.parse(fecha);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Fecha invalida");
        }
        this.fecha = anio + '-' + mes + '-' + dia;
        asi.setFecha(fecha);
        renglones = asiSql.asientoCuentaPorFecha(asi);
        if(renglones != null){
            for(Renglon renglon : renglones){
                agregarRenglones(renglon);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay asientos realizados en la fecha indicada");
        }
    }//GEN-LAST:event_btnIrActionPerformed

    private void jTextMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMesActionPerformed



    private void limpiar() {

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

    public void actualizarRegistrarAsiento() {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdelante;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnIr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextAnio;
    private javax.swing.JTextField jTextDia;
    private javax.swing.JTextField jTextMes;
    private javax.swing.JPanel panelReg;
    private javax.swing.ButtonGroup radBtnGrupo;
    private javax.swing.JTable tablaAsiento;
    // End of variables declaration//GEN-END:variables

}
