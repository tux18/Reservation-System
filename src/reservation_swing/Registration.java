
package reservation_swing;

import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;

public class Registration extends javax.swing.JFrame {

  
    
    public Registration() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Registration Form");
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        cancel_reg = new javax.swing.JButton();
        lname = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        repass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(22, 160, 133));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Lucida Sans", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registration");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("First Name");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Last Name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        jPanel2.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 159, 28));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Password");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 95, -1, -1));

        register.setBackground(new java.awt.Color(0, 121, 107));
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setText("Register");
        register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        jPanel2.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 269, 188, 42));

        cancel_reg.setBackground(new java.awt.Color(0, 121, 107));
        cancel_reg.setForeground(new java.awt.Color(255, 255, 255));
        cancel_reg.setText("Cancel");
        cancel_reg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_regActionPerformed(evt);
            }
        });
        jPanel2.add(cancel_reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 317, 188, 26));
        jPanel2.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 160, 28));
        jPanel2.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 170, 28));
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 160, 28));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Contact Number");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Username");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 170, 30));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Retype Password");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));
        jPanel2.add(repass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 170, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancel_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_regActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancel_regActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        
        String user = username.getText();
        String pass = password.getText();
        String number = contact.getText();
        String first = fname.getText();
        String last = lname.getText();
        String rtype = repass.getText();
        boolean flag = true;
        
        
        
        
        try{
            
              Class.forName("com.mysql.jdbc.Driver");
              Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
              
              if("".equals(user) && "".equals(pass) && "".equals(number) && "".equals(first) && "".equals(last)
                      && "".equals(rtype)){
                JOptionPane.showMessageDialog(null, "Please Input the Missing FIelds", "Error",JOptionPane.ERROR_MESSAGE);
                
                
              }else if (!pass.equals(rtype)){
                JOptionPane.showMessageDialog(null, "Password do not match", "Error",JOptionPane.ERROR_MESSAGE);
                  
                    repass.setText("");
              }else{
                    PreparedStatement query =  conn.prepareStatement(""
                      + "INSERT INTO employee (username,password,contact_num,fname,lname)"
                      + "VALUES (" + "'" +user + "'" + ","+"'" + pass + "'"+","+ "'"+number+"'"+","+
                             "'"+ first+"'"+","+"'"+last+"'" +")");
                    
                    query.execute(); // EXECUTE THE QUERY
                    JOptionPane.showMessageDialog(null, "Successfully Registered", "Registration",JOptionPane.INFORMATION_MESSAGE);
                    username.setText("");
                    password.setText("");
                    contact.setText("");
                    fname.setText("");
                    lname.setText("");
                    repass.setText("");
              }
              

              
        }catch(HeadlessException | ClassNotFoundException | SQLException e){
            System.out.print(e);
//              JOptionPane.showMessageDialog(null, "No Connection", "Connection",JOptionPane.ERROR_MESSAGE);
         }
        
        
        
        
        
    }//GEN-LAST:event_registerActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_reg;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lname;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton register;
    private javax.swing.JPasswordField repass;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
