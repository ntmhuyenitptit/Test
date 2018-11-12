 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Model.KMessage;
import Model.Users;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nam Lee
 */
public class LoginForm extends javax.swing.JFrame implements inReceiveMessage {

    static public Users user = null;
    static public String IP;
    static public String Port;
    static public Socket socket = null;

    ListenServer listenServer = null;

    /**
     * Creates new form Main
     */
    public LoginForm() {
        initComponents();
        setLocationRelativeTo(null);
        setIcon();
        connectServer();
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/IconPlayer.jpg")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tx_username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tx_password = new javax.swing.JPasswordField();
        bt_login = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        bt_dangky = new javax.swing.JButton();
        tx_username_dk = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tx_password_dk = new javax.swing.JTextField();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("ĐĂNG NHẬP");

        jLabel1.setText("User Name:");

        tx_username.setText("admin");

        jLabel3.setText("Password:");

        tx_password.setText("admin");
        tx_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_passwordActionPerformed(evt);
            }
        });
        tx_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tx_passwordKeyPressed(evt);
            }
        });

        bt_login.setText("Login");
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(262, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tx_password, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(tx_username))
                                .addGap(74, 74, 74))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(bt_login)
                                .addGap(34, 34, 34))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(bt_login)
                .addGap(30, 30, 30))
        );

        jTabbedPane2.addTab("Đăng Nhập", jPanel1);

        jLabel4.setText("Username");

        bt_dangky.setText("Đăng ký");
        bt_dangky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_dangkyActionPerformed(evt);
            }
        });

        tx_username_dk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_username_dkActionPerformed(evt);
            }
        });

        jLabel5.setText("ĐĂNG KÝ");

        jLabel6.setText("Password");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tx_username_dk, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tx_password_dk, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_dangky)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel5)
                    .addContainerGap(292, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_username_dk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tx_password_dk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bt_dangky)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel5)
                    .addContainerGap(136, Short.MAX_VALUE)))
        );

        jTabbedPane2.addTab("Đăng Ký", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
        // TODO add your handling code here:
        String username;
        String password;

        username = tx_username.getText();
        password = String.valueOf(tx_password.getPassword());

        if (username.compareTo("") == 0 || password.compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Chưa điền đủ", "Lỗi", 1);
            return;
        }

        if (listenServer != null) {
            try {
                listenServer.SendMessage(0, new Users(username, password));
            } catch (IOException ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bt_loginActionPerformed

    private void tx_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tx_passwordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n') {
            bt_loginActionPerformed(null);
        }
    }//GEN-LAST:event_tx_passwordKeyPressed

    private void tx_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tx_passwordActionPerformed

    private void tx_username_dkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_username_dkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tx_username_dkActionPerformed

    private void bt_dangkyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_dangkyActionPerformed
        // TODO add your handling code here: bam nut dang ký
        String username;
        String password;

        username = tx_username_dk.getText();
        password = tx_password_dk.getText();

        if (username.compareTo("") == 0 || password.compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Chưa điền đủ", "Lỗi", 1);
            return;
        }

        if (listenServer != null) {
            try {
                listenServer.SendMessage(1, new Users(username, password));
            } catch (IOException ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bt_dangkyActionPerformed

    void connectServer() {
        IP = "127.0.0.1";
        Port = "1234";

        try {
            if (socket == null) {
                socket = new Socket(IP, Integer.parseInt(Port));
                listenServer = new ListenServer(socket);
                listenServer.receive = this;
                listenServer.start();
            }
        } catch (UnknownHostException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Không tìm thấy server", "Lỗi", 1);
            return;
        } catch (IOException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Không tìm thấy server", "Lỗi", 1);
            System.exit(0);
        }
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new LoginForm().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_dangky;
    private javax.swing.JButton bt_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPasswordField tx_password;
    private javax.swing.JTextField tx_password_dk;
    private javax.swing.JTextField tx_username;
    private javax.swing.JTextField tx_username_dk;
    // End of variables declaration//GEN-END:variables

    @Override
    public void ReceiveMessage(KMessage msg) throws IOException {
        switch (msg.getType()) {
            case 0: {
                user = (Users) msg.getObject();
                if (user != null) {
                    listenServer.user = user;
                    //JOptionPane.showMessageDialog(null, "Ok", "Message", 1);

                    /* Create and display the form */
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            System.out.println("Đã tham gia!");
                            //new Main(listenServer).setVisible(true);
                            new RoomFrame(listenServer).setVisible(true);
                        }
                    });
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!", "Lỗi đăng nhập", 1);
                }
                break;
            }
            case 1: {
                JOptionPane.showMessageDialog(null, msg.getObject(), "Message", 1);
                break;
            }

        }

    }
}
