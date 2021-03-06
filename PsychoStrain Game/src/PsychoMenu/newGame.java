/*
 * newGame.java
 *
 * Created on September 28, 2008, 3:16 AM
 */

package PsychoMenu;

import PsychoGame.Engine;
import java.awt.Font;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author  lsdfx
 */
public class newGame extends javax.swing.JFrame {

  public static int dificultad = 1; //si el default fuera 0, pues JA... NO
  
    
    /** Creates new form newGame */
    public newGame() {
      if(Engine.selectedProfile.equals("<No Profile Loaded>")){
        profilePanel a = new profilePanel();
        int n = JOptionPane.showConfirmDialog(this, "Deseas crear un nuevo perfil?","Juego Nuevo",JOptionPane.YES_NO_OPTION,3);
          if(n==0){          
            a.show(); this.dispose();
          }else{
            JOptionPane.showMessageDialog(this, "Primero carga un perfil");
        }
      }else{
        initComponents();
        setFields();
        setCrazy();      
    }
   }
    
   public void setCrazy(){
    try {
      Font crazy = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/byte.ttf"));
      crazy = crazy.deriveFont(14f);
      jRadioButton1.setFont(crazy);
      jRadioButton2.setFont(crazy);
      jRadioButton3.setFont(crazy);
      jRadioButton4.setFont(crazy);
      jButton1.setFont(crazy);
      jButton2.setFont(crazy);
      jLabel2.setFont(crazy);
    } catch (Exception ex) {}
  }

    public void setFields(){
     jRadioButton1.setSelected(true);
    }

    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    jPanel1 = new javax.swing.JPanel();
    jRadioButton1 = new javax.swing.JRadioButton();
    jLabel2 = new javax.swing.JLabel();
    jRadioButton2 = new javax.swing.JRadioButton();
    jRadioButton3 = new javax.swing.JRadioButton();
    jRadioButton4 = new javax.swing.JRadioButton();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Empezar Nuevo Juego");
    setLocationByPlatform(true);
    setResizable(false);

    jPanel1.setBackground(new java.awt.Color(1, 1, 1));

    jRadioButton1.setBackground(new java.awt.Color(0, 0, 0));
    buttonGroup1.add(jRadioButton1);
    jRadioButton1.setFont(new java.awt.Font("Chiller", 0, 20));
    jRadioButton1.setForeground(new java.awt.Color(0, 255, 0));
    jRadioButton1.setText("Normal");
    jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jRadioButton1ActionPerformed(evt);
      }
    });

    jLabel2.setBackground(new java.awt.Color(0, 0, 0));
    jLabel2.setFont(new java.awt.Font("Chiller", 1, 24));
    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("Dificultad:");

    jRadioButton2.setBackground(new java.awt.Color(0, 0, 0));
    buttonGroup1.add(jRadioButton2);
    jRadioButton2.setFont(new java.awt.Font("Chiller", 0, 20));
    jRadioButton2.setForeground(new java.awt.Color(0, 255, 0));
    jRadioButton2.setText("Dificil");
    jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jRadioButton2ActionPerformed(evt);
      }
    });

    jRadioButton3.setBackground(new java.awt.Color(0, 0, 0));
    buttonGroup1.add(jRadioButton3);
    jRadioButton3.setFont(new java.awt.Font("Chiller", 0, 20));
    jRadioButton3.setForeground(new java.awt.Color(0, 255, 0));
    jRadioButton3.setText("Extremo");
    jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jRadioButton3ActionPerformed(evt);
      }
    });

    jRadioButton4.setBackground(new java.awt.Color(0, 0, 0));
    buttonGroup1.add(jRadioButton4);
    jRadioButton4.setFont(new java.awt.Font("Chiller", 0, 20));
    jRadioButton4.setForeground(new java.awt.Color(0, 255, 0));
    jRadioButton4.setText("NIGHTMARE");
    jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jRadioButton4ActionPerformed(evt);
      }
    });

    jButton1.setBackground(new java.awt.Color(0, 0, 0));
    jButton1.setFont(new java.awt.Font("Chiller", 1, 18));
    jButton1.setForeground(new java.awt.Color(0, 255, 0));
    jButton1.setText("Comenzar!");
    jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    jButton1.setContentAreaFilled(false);
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton2.setBackground(new java.awt.Color(0, 0, 0));
    jButton2.setFont(new java.awt.Font("Chiller", 1, 18));
    jButton2.setForeground(new java.awt.Color(0, 255, 0));
    jButton2.setText("Cancelar");
    jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    jButton2.setContentAreaFilled(false);
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel2)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jRadioButton1)
              .addComponent(jRadioButton2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jRadioButton3)
              .addComponent(jRadioButton4)))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel2)
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jRadioButton1)
          .addComponent(jRadioButton3))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jRadioButton2)
          .addComponent(jRadioButton4))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jButton2)
          .addComponent(jButton1))
        .addGap(53, 53, 53))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
  this.hide();
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
  dispose(); Menu.setControl(false);
  startGame(1,Engine.selectedProfile,dificultad);
}//GEN-LAST:event_jButton1ActionPerformed

private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
// TODO add your handling code here:
  dificultad =1;
}//GEN-LAST:event_jRadioButton1ActionPerformed

private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
// TODO add your handling code here:
  dificultad = 2;
}//GEN-LAST:event_jRadioButton2ActionPerformed

private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
// TODO add your handling code here:
  dificultad = 3;
}//GEN-LAST:event_jRadioButton3ActionPerformed

private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
// TODO add your handling code here:
  dificultad = 4;
  JOptionPane.showMessageDialog(null,"Suerte, la vas a necesitar...");
}//GEN-LAST:event_jRadioButton4ActionPerformed

//Este metodo que crees que haga?
  public void startGame(int newOrLoad, String HackerName, int dificultad) {    
    Engine.dificultad = dificultad;
    Engine.staticOpt.saveConfig();
    Engine.setDefaults();
    
    
    if(newOrLoad==1){ //ya ni me acuerdo por que puse esto pero por el nombre sera para diferenciar si es new game o no
      try {
        Menu.setControl(false); //FLOW CONTROL, de nuevo, borra esto y el apocalipsis comienza
        this.dispose(); //ya no sirvo, AN HERO
      } catch (Exception ex) {
        System.out.println(ex); //si algo pasa, avisar con estilo
      }
    }
  }
  
    /**
    * @param args the command line arguments
    */
    
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JRadioButton jRadioButton1;
  private javax.swing.JRadioButton jRadioButton2;
  private javax.swing.JRadioButton jRadioButton3;
  private javax.swing.JRadioButton jRadioButton4;
  // End of variables declaration//GEN-END:variables

}
