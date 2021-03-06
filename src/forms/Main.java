/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

/**
 *
 * @author Lachgar
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        Tracker = new javax.swing.JButton();
        Vehicule = new javax.swing.JButton();
        Position = new javax.swing.JButton();
        Affecter = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        Chercherv = new javax.swing.JButton();
        ChercherT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Géolocalisation des véhicules");

        desktopPane.setForeground(new java.awt.Color(0, 204, 255));

        Tracker.setBackground(new java.awt.Color(204, 204, 204));
        Tracker.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Tracker.setText("Gestion Trackers");
        Tracker.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Tracker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrackerActionPerformed(evt);
            }
        });
        desktopPane.add(Tracker);
        Tracker.setBounds(500, 320, 190, 40);

        Vehicule.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Vehicule.setText("Gestion Des Véhicules");
        Vehicule.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Vehicule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehiculeActionPerformed(evt);
            }
        });
        desktopPane.add(Vehicule);
        Vehicule.setBounds(500, 370, 190, 40);

        Position.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Position.setText("Gestion Des Positions");
        Position.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PositionActionPerformed(evt);
            }
        });
        desktopPane.add(Position);
        Position.setBounds(500, 420, 190, 40);

        Affecter.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Affecter.setText("AffecterTracker pour Véhicule ");
        Affecter.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Affecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AffecterActionPerformed(evt);
            }
        });
        desktopPane.add(Affecter);
        Affecter.setBounds(710, 420, 250, 40);

        jButton5.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jButton5.setText("Déconnexion");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton5);
        jButton5.setBounds(640, 480, 120, 40);

        Chercherv.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Chercherv.setText("Chercher Position Par Vehicule");
        Chercherv.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Chercherv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CherchervActionPerformed(evt);
            }
        });
        desktopPane.add(Chercherv);
        Chercherv.setBounds(710, 320, 250, 40);

        ChercherT.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        ChercherT.setText("Chercher Position Par un Tracker");
        ChercherT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ChercherT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChercherTActionPerformed(evt);
            }
        });
        desktopPane.add(ChercherT);
        ChercherT.setBounds(710, 370, 250, 40);

        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu Principal");
        jLabel1.setToolTipText("");
        desktopPane.add(jLabel1);
        jLabel1.setBounds(630, 250, 280, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\list.png")); // NOI18N
        desktopPane.add(jLabel2);
        jLabel2.setBounds(580, 240, 60, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1405, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TrackerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrackerActionPerformed
        // TODO add your handling code here:
         TrackerForm tf = new TrackerForm();
        desktopPane.add(tf);
        tf.setVisible(true);
    }//GEN-LAST:event_TrackerActionPerformed

    private void VehiculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehiculeActionPerformed
        // TODO add your handling code here:
         VehiculeForm vf = new  VehiculeForm();
        desktopPane.add(vf);
        vf.setVisible(true);
    }//GEN-LAST:event_VehiculeActionPerformed

    private void PositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PositionActionPerformed
        // TODO add your handling code here:
         PositionForm pf = new  PositionForm();
        desktopPane.add(pf);
        pf.setVisible(true);
    }//GEN-LAST:event_PositionActionPerformed

    private void AffecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AffecterActionPerformed
        // TODO add your handling code here:
         VehiculeTracker v = new  VehiculeTracker();
        desktopPane.add(v);
        v.setVisible(true);
    }//GEN-LAST:event_AffecterActionPerformed

    private void CherchervActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CherchervActionPerformed
        // TODO add your handling code here:
        FindPositionV fd = new FindPositionV();
        desktopPane.add(fd);
        fd.setVisible(true);
    }//GEN-LAST:event_CherchervActionPerformed

    private void ChercherTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChercherTActionPerformed
        // TODO add your handling code here:
          FindPositionT fp = new FindPositionT();
        desktopPane.add(fp);
        fp.setVisible(true);
    }//GEN-LAST:event_ChercherTActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
           System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Affecter;
    private javax.swing.JButton ChercherT;
    private javax.swing.JButton Chercherv;
    private javax.swing.JButton Position;
    private javax.swing.JButton Tracker;
    private javax.swing.JButton Vehicule;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}
