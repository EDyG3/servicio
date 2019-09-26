/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scpaa;

import javax.swing.JOptionPane;

/**
 *
 * @author ar-mo
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
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
            JOptionPane.showMessageDialog(null, "Operación cancelada");
        }
    }
    
    void Regresar()
    {
        int Volver = JOptionPane.showConfirmDialog(null, "¿Cerrar sesión?");
        
        if(Volver == 0)
        {
            Login Regresar = new Login();
            Regresar.setVisible(true);
            dispose();
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "Operación cancelada...");
        }
    }
    
    void NuevoRegistro()
    {
        RegistrarActividad NuevoRegistro = new RegistrarActividad();
        NuevoRegistro.setVisible(true);
        dispose();
    }
    
    void NuevaParticipacion()
    {
        RegistrarParticipacion NuevaParticipacion = new RegistrarParticipacion();
        NuevaParticipacion.setVisible(true);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        RegistrarActividad = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();
        RegistrarParticipacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        Titulo.setText("ACTIVIDADES");

        RegistrarActividad.setText("REGISTRAR ACTIVIDAD");
        RegistrarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActividadActionPerformed(evt);
            }
        });

        Salir.setText("SALIR");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        Regresar.setText("CERRAR SESIÓN");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        RegistrarParticipacion.setText("REGISTRAR PARTICIPACIÓN");
        RegistrarParticipacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarParticipacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(Titulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Regresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Salir)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(RegistrarActividad)
                .addGap(124, 124, 124))
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(RegistrarParticipacion)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo)
                .addGap(26, 26, 26)
                .addComponent(RegistrarActividad)
                .addGap(18, 18, 18)
                .addComponent(RegistrarParticipacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salir)
                    .addComponent(Regresar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActividadActionPerformed
        NuevoRegistro();
    }//GEN-LAST:event_RegistrarActividadActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        Salir();
    }//GEN-LAST:event_SalirActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        Regresar();
    }//GEN-LAST:event_RegresarActionPerformed

    private void RegistrarParticipacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarParticipacionActionPerformed
        NuevaParticipacion();
    }//GEN-LAST:event_RegistrarParticipacionActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RegistrarActividad;
    private javax.swing.JButton RegistrarParticipacion;
    private javax.swing.JButton Regresar;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel Titulo;
    // End of variables declaration//GEN-END:variables
}
