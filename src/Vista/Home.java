package Vista;

import Modelo.SqlAsientos;
import Modelo.SqlEditor;
import Modelo.SqlEmpresa;
import Modelo.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Home extends javax.swing.JFrame {

    public static Borrar frmBorr;
    public static Registro frmReg;
    public static RegistrarAsiento frmRegAsis;
    public static LibroDiario frmLibDia;
    public static LibroMayor frmLibMay;
    public static PlanDeCuentas frmPlan;
    public static AgregarCuenta frmAgrCta;
    public static Usuario mod;
    public static String actividad;
    public static String empresa;
    public static String cuit;
    public static Home home;
    public static AgregarCliente frmAgrCli;
    public static ModificarCliente frmModCli;
    public static StockManual frmStoMan;
    public static StockAutomatico frmStoAut;
    public static VentaContado frmVenCon;
    public static VerCliente frmVerCli;
    
    
    
    public Home() {
        initComponents();
        setResizable(false);
    }

    public Home(Usuario mod) {
        initComponents();
        setResizable(false);
        Home.mod = mod;
        Home.home = new Home();

        switch (mod.getTipoUsuario()) {
            case 1:
                break;
            case 2:
                menuUsuarios.setVisible(false);
                subAgregarCuenta.setVisible(false);
                break;
            case 3:
                menuUsuarios.setVisible(false);
                subAgregarAsiento.setVisible(false);
                menuAsientoContable.setVisible(false);
                btnRegistrarAsiento.setVisible(false);
                
                break;
            default:
                break;
        }
        this.txtUsuario.setText(mod.getNombre());
        Timer t = new Timer(1000, updateClockAction);
        t.start();

        SqlAsientos asiSql = new SqlAsientos();
        //this.txtCantAsientos.setText(asiSql.cantidadAsientos(30, mod).toString());
        SqlEditor sqlEditor = new SqlEditor();
        this.txtEditor.setText(sqlEditor.TraerTexto(mod.getNombre()));
        SqlEmpresa sqlEmpresa = new SqlEmpresa();
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String fecha = sdf.format(date);
        String inicioAct = sqlEmpresa.inicioActividad(mod.getEmpresa());
        if(Integer.parseInt((inicioAct.substring(5, 7)) + (inicioAct.substring(8, 10))) <= Integer.parseInt((fecha.substring(5, 7)) + (fecha.substring(8, 10)))){
            this.txtActividad.setText("Fecha de inicio de actividades: " + fecha.substring(0, 4) + inicioAct.substring(4, 10));
        } else{
            String año = String.valueOf(Integer.parseInt(fecha.substring(0, 4)) - 1);
            this.txtActividad.setText("Fecha de inicio de actividades: " + año + inicioAct.substring(4, 10));
        }
        String empresa = sqlEmpresa.empresa(mod.getEmpresa());
        String cuit = sqlEmpresa.cuit(mod.getEmpresa());
        this.txtEmpresa.setText(empresa);
        this.txtCuit.setText("Cuit: " + cuit);
        this.actividad = txtActividad.getText();
        this.empresa = txtEmpresa.getText();
        this.cuit = txtCuit.getText();
        
        
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public static String getCuit() {
        return cuit;
    }

    public static void setCuit(String cuit) {
        Home.cuit = cuit;
    }

    public static Usuario getMod() {
        return mod;
    }

    public static void setMod(Usuario mod) {
        Home.mod = mod;
    }

    public static Home getHome() {
        return home;
    }

    public static void setHome(Home home) {
        Home.home = home;
    }
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        jTxtReloj = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEditor = new javax.swing.JTextArea();
        btnGuardad = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrarAsiento = new javax.swing.JButton();
        btnPlanDeCuentas = new javax.swing.JButton();
        gftfudttug = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtEmpresa = new javax.swing.JLabel();
        txtActividad = new javax.swing.JLabel();
        txtCuit = new javax.swing.JLabel();
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
        subAgregarCuenta = new javax.swing.JMenuItem();
        menuCliente = new javax.swing.JMenu();
        subAgregarCliente = new javax.swing.JRadioButtonMenuItem();
        subVerCliente = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        subStockFil = new javax.swing.JCheckBoxMenuItem();
        subStockBusc = new javax.swing.JCheckBoxMenuItem();
        menuSesion = new javax.swing.JMenu();
        subCerrarSesion = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Note pad");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Usuario:");

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jTxtReloj.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N

        txtEditor.setColumns(20);
        txtEditor.setRows(5);
        jScrollPane1.setViewportView(txtEditor);

        btnGuardad.setText("Guardar");
        btnGuardad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardadActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTxtReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardad)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnGuardad)
                    .addComponent(btnLimpiar))
                .addGap(56, 56, 56)
                .addComponent(jTxtReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        btnRegistrarAsiento.setBackground(new java.awt.Color(51, 255, 255));
        btnRegistrarAsiento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegistrarAsiento.setText("Registrar asiento");
        btnRegistrarAsiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAsientoActionPerformed(evt);
            }
        });

        btnPlanDeCuentas.setBackground(new java.awt.Color(51, 255, 255));
        btnPlanDeCuentas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPlanDeCuentas.setText("Plan de cuentas");
        btnPlanDeCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlanDeCuentasActionPerformed(evt);
            }
        });

        gftfudttug.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resurces/pantera-band-1994.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gftfudttug, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRegistrarAsiento)
                        .addGap(18, 18, 18)
                        .addComponent(btnPlanDeCuentas)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPlanDeCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(gftfudttug, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        txtEmpresa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtActividad.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txtCuit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(303, 303, 303))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(txtActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(315, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        subAgregarCuenta.setText("Agregar cuenta");
        subAgregarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subAgregarCuentaActionPerformed(evt);
            }
        });
        menuPlanDeCuentas.add(subAgregarCuenta);

        jMenuBar1.add(menuPlanDeCuentas);

        menuCliente.setText("Cliente");

        subAgregarCliente.setSelected(true);
        subAgregarCliente.setText("Agregar cliente");
        subAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subAgregarClienteActionPerformed(evt);
            }
        });
        menuCliente.add(subAgregarCliente);

        subVerCliente.setSelected(true);
        subVerCliente.setText("Ver cliente");
        subVerCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subVerClienteActionPerformed(evt);
            }
        });
        menuCliente.add(subVerCliente);

        jMenuBar1.add(menuCliente);

        jMenu1.setText("Stock");

        subStockFil.setSelected(true);
        subStockFil.setText("Ver stock por filtros");
        subStockFil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subStockFilActionPerformed(evt);
            }
        });
        jMenu1.add(subStockFil);

        subStockBusc.setSelected(true);
        subStockBusc.setText("Ver stock por búsqueda");
        subStockBusc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subStockBuscActionPerformed(evt);
            }
        });
        jMenu1.add(subStockBusc);

        jMenuBar1.add(jMenu1);

        menuSesion.setText("Sesion");

        subCerrarSesion.setSelected(true);
        subCerrarSesion.setText("Cerrar  sesion");
        subCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subCerrarSesionActionPerformed(evt);
            }
        });
        menuSesion.add(subCerrarSesion);

        jMenuBar1.add(menuSesion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(439, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(361, 361, 361)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subAgregarUsuarioActionPerformed

        if (frmReg == null) {
            frmReg = new Registro(mod);
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
            frmRegAsis = new RegistrarAsiento(mod, this);
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

    private void btnPlanDeCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlanDeCuentasActionPerformed
        
        if (frmPlan == null) {
            frmPlan = new PlanDeCuentas();
            frmPlan.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frmPlan.setVisible(true);
        }
        
    }//GEN-LAST:event_btnPlanDeCuentasActionPerformed

    private void btnRegistrarAsientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAsientoActionPerformed
        
        if (frmRegAsis == null) {
            frmRegAsis = new RegistrarAsiento(mod, this);
            frmRegAsis.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frmRegAsis.setVisible(true);
        }
        
    }//GEN-LAST:event_btnRegistrarAsientoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        
        this.txtEditor.setText("");
        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardadActionPerformed
        
        SqlEditor sqlEditor = new SqlEditor();
        if(!(sqlEditor.guardadTexto(this.txtEditor.getText(), this.txtUsuario.getText()))){
            JOptionPane.showMessageDialog(null, "Error al guardar, intente nuevamente");
        }else{
            JOptionPane.showMessageDialog(null, "Se ha guardado correctamente");
        }
    }//GEN-LAST:event_btnGuardadActionPerformed

    private void subCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subCerrarSesionActionPerformed
        
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
        JOptionPane.showMessageDialog(null, "Sesion cerrada");
        
    }//GEN-LAST:event_subCerrarSesionActionPerformed

    private void subAgregarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subAgregarCuentaActionPerformed
       
        if (frmAgrCta == null) {
            frmAgrCta = new AgregarCuenta(this);
            frmAgrCta.setVisible(true);
        }
        
        
        
        
    }//GEN-LAST:event_subAgregarCuentaActionPerformed

    private void subAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subAgregarClienteActionPerformed
        
        if (frmAgrCli == null) {
            frmAgrCli = new AgregarCliente(this);
            frmAgrCli.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frmAgrCli.setVisible(true);
        }
        
    }//GEN-LAST:event_subAgregarClienteActionPerformed

    private void subVerClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subVerClienteActionPerformed
        
        if (frmVerCli == null) {
            frmVerCli = new VerCliente(this);
            frmVerCli.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frmVerCli.setVisible(true);
        }
        
    }//GEN-LAST:event_subVerClienteActionPerformed

    private void subStockFilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subStockFilActionPerformed
        
        if (frmStoMan == null) {
            frmStoMan = new StockManual(this);
            frmStoMan.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frmStoMan.setVisible(true);
        }
        
    }//GEN-LAST:event_subStockFilActionPerformed

    private void subStockBuscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subStockBuscActionPerformed
       
        if (frmStoAut == null) {
            frmStoAut = new StockAutomatico(this);
            frmStoAut.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frmStoAut.setVisible(true);
        }
        
    }//GEN-LAST:event_subStockBuscActionPerformed

    
    
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
    
    
    
    /*public void agregarAsiento(){
        this.txtCantAsientos.setText(String.valueOf((Integer.valueOf(txtCantAsientos.getText()))+1));
    }
    */
    
    ActionListener updateClockAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();

            jTxtReloj.setText(now.get(Calendar.HOUR_OF_DAY) + " : " + now.get(Calendar.MINUTE) + " : " + now.get(Calendar.SECOND));
        }
    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardad;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPlanDeCuentas;
    private javax.swing.JButton btnRegistrarAsiento;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel gftfudttug;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jTxtReloj;
    private javax.swing.JMenu menuAsientoContable;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuLibroDiario;
    private javax.swing.JMenu menuLibroMayor;
    private javax.swing.JMenu menuPlanDeCuentas;
    private javax.swing.JMenu menuSesion;
    private javax.swing.JMenu menuUsuarios;
    private javax.swing.JMenuItem subAgregarAsiento;
    private javax.swing.JRadioButtonMenuItem subAgregarCliente;
    private javax.swing.JMenuItem subAgregarCuenta;
    private javax.swing.JCheckBoxMenuItem subAgregarUsuario;
    private javax.swing.JCheckBoxMenuItem subCerrarSesion;
    private javax.swing.JCheckBoxMenuItem subEliminarUsuario;
    private javax.swing.JCheckBoxMenuItem subStockBusc;
    private javax.swing.JCheckBoxMenuItem subStockFil;
    private javax.swing.JCheckBoxMenuItem subVerCliente;
    private javax.swing.JMenuItem subVerLibroDiario;
    private javax.swing.JMenuItem subVerLibroMayor;
    private javax.swing.JCheckBoxMenuItem subVerPlanDeCuentas;
    private javax.swing.JLabel txtActividad;
    private javax.swing.JLabel txtCuit;
    private javax.swing.JTextArea txtEditor;
    private javax.swing.JLabel txtEmpresa;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
