/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scpaa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ar-mo
 */
public class RegistrarParticipacion extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarParticipacion
     */
    public RegistrarParticipacion() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    void Salir()
    {
        int Salir = JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?");
        
        if(Salir == 0)
        {
            System.exit(0);
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "Operación cancelada...");
        }
    }
    
    void Regresar()
    {
        int Volver = JOptionPane.showConfirmDialog(null, "¿Desea regresar al menú principal?");
        
        if(Volver == 0)
        {
            MenuPrincipal AbrirMenuPrin = new MenuPrincipal();
            AbrirMenuPrin.setVisible(true);
            dispose();
        }
    }
    
    void ObtenerID()
    {
        txtPeriodo = (String)PeriodoActividad.getSelectedItem();
        txtAnio = (String)AnioActividad.getSelectedItem();
        txtNombre = (String)Actividades.getSelectedItem();
        
        String sql = ("SELECT IDActividad FROM actividad WHERE PeriodoActividad='"+txtPeriodo+"' AND AnioActividad='"+txtAnio+"' AND NombreActividad='"+txtNombre+"';");
        
        try
        {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next())
            {
                IDAct[0] = rs.getString(1);
            }
        }

        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error...");
            System.out.print(e);
        }
    }
    
    void ConsultarActividades()
    {
        txtPeriodo = (String)PeriodoActividad.getSelectedItem();
        txtAnio = (String)AnioActividad.getSelectedItem();
        String sql = ("SELECT NombreActividad FROM actividad WHERE PeriodoActividad='"+txtPeriodo+"' AND AnioActividad='"+txtAnio+"';");
                
        if(txtPeriodo.equals(Vacio) || txtAnio.equals(Vacio))
        {
            JOptionPane.showMessageDialog(null, "No ha elegido alguna opción");
        }
        
        else
        {
            try
            {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                while(rs.next())
                {
                    Actividades.addItem(rs.getString("NombreActividad"));
                }
            }

            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error...");
                System.out.print(e);
            }
        }        
    }
    
    void ObtenerRegistros()
    {
        DefaultTableModel Modelo = new DefaultTableModel();
        Modelo.addColumn("Número de control");
        Modelo.addColumn("CURP");
        Modelo.addColumn("Nombres");
        Modelo.addColumn("Apellido paterno");
        
        tabRegistrados.setModel(Modelo);
        
        String sql = "SELECT alumno.NumControl,CURP,Nombres,ApellidoPat FROM alumno INNER JOIN participacion ON alumno.NumControl=participacion.NumControl INNER JOIN actividad on participacion.IDActividad=actividad.IDActividad WHERE actividad.IDActividad='"+IDAct[0]+"';";
        
        try
        {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next())
            {
                Registro[0] = rs.getString(1);
                Registro[1] = rs.getString(2);
                Registro[2] = rs.getString(3);
                Registro[3] = rs.getString(4);
                
                Modelo.addRow(Registro);
            }
        }
        
        catch(SQLException e)
                {
                    System.out.print(e.getMessage());
                }
    }
    
    void GenerarRegistro()
    {
        
        
        if(IDAct[0].equals("") || txtNumControl.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Hay campos vacios");
        }

        else
        {
            int Guardar = JOptionPane.showConfirmDialog(null, "Desea registrar la nueva actividad?");

            if(Guardar == 0)
            {
                try
                {
                    PreparedStatement pst = cn.prepareStatement("INSERT INTO participacion (NumControl,IDActividad) VALUES (?,?)");

                    pst.setString(1, txtNumControl.getText());
                    pst.setString(2, IDAct[0]);

                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Datos Guardados...");
                }

                catch (SQLException e)
                {                    
                    JOptionPane.showMessageDialog(this, "Ha Ocurrido Un Error");
                    System.out.println(e);
                }
            }

            else
            {
                JOptionPane.showMessageDialog(this, "Operación Cancelada");
            }
        }        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        Finalizar = new javax.swing.JButton();
        REGRESAR = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        PeriodoActividad = new javax.swing.JComboBox();
        AnioActividad = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Actividades = new javax.swing.JComboBox();
        btnConsultar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtNumControl = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabRegistrados = new JTable(){

            public boolean isCellEditable(int rowIndex, int colIndex) {

                return false; //Las celdas no son editables.

            }
        };
        jCheckBox1 = new javax.swing.JCheckBox();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        Finalizar.setText("SALIR");
        Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarActionPerformed(evt);
            }
        });

        REGRESAR.setText("REGRESAR");
        REGRESAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REGRESARActionPerformed(evt);
            }
        });

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setText("SELECCIONAR PERIODO DE LA ACTIVIDAD: ");

        PeriodoActividad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELIJA UNA OPCIÓN", "Enero - Julio", "Agosto - Diciembre" }));

        AnioActividad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELIJA UNA OPCIÓN", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039" }));

        jLabel2.setText("SELECCIONAR AÑO DE LA ACTIVIDAD: ");

        jLabel3.setText("REGISTRO DE PARTICIPACIÓN DE ESTUDIANTES");

        jLabel4.setText("SELECCIONAR ACTIVIDAD: ");

        btnConsultar.setText("CONSULTAR ACTIVIDADES");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jLabel5.setText("INGRESAR NUMERO DE CONTROL:");

        txtNumControl.setEnabled(false);
        txtNumControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumControlActionPerformed(evt);
            }
        });

        tabRegistrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número de control", "CURP", "Nombres", "Apellido paterno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabRegistrados);

        jCheckBox1.setText("Aceptar");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PeriodoActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AnioActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(btnConsultar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(REGRESAR)
                        .addGap(95, 95, 95)
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Finalizar)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(95, 95, 95))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Actividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox1))
                            .addComponent(txtNumControl, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PeriodoActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnioActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(btnConsultar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Actividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNumControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Finalizar)
                    .addComponent(REGRESAR)
                    .addComponent(btnRegistrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarActionPerformed
        Salir();
    }//GEN-LAST:event_FinalizarActionPerformed

    private void REGRESARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REGRESARActionPerformed
        Regresar();
    }//GEN-LAST:event_REGRESARActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        Actividades.removeAllItems();
        Actividades.addItem("ELIJA UNA OPCIÓN");
        ConsultarActividades();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void txtNumControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumControlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumControlActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(aceptar)
        {
            ObtenerID();
            
            PeriodoActividad.setEnabled(false);
            AnioActividad.setEnabled(false);
            btnConsultar.setEnabled(false);
            Actividades.setEnabled(false);
            
            txtNumControl.setEnabled(true);
            
            ObtenerRegistros();
            
            aceptar = false;
        }
        
        else
        {
            PeriodoActividad.setEnabled(true);
            AnioActividad.setEnabled(true);
            btnConsultar.setEnabled(true);
            Actividades.setEnabled(true);
            
            txtNumControl.setEnabled(false);
            
            aceptar = true;
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        GenerarRegistro();
        ObtenerRegistros();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(RegistrarParticipacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarParticipacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarParticipacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarParticipacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarParticipacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Actividades;
    private javax.swing.JComboBox AnioActividad;
    private javax.swing.JButton Finalizar;
    private javax.swing.JComboBox PeriodoActividad;
    private javax.swing.JButton REGRESAR;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tabRegistrados;
    private javax.swing.JTextField txtNumControl;
    // End of variables declaration//GEN-END:variables
Conectar cc= new Conectar();
Connection cn= cc.conexion();
String txtPeriodo, txtAnio, Vacio = "ELIJA UNA OPCIÓN", txtNombre;
String []Registro = new String[4];
String []IDAct = new String[1];
boolean aceptar = true;
}
