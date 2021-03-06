/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Model.GPos;
import Model.CPiece;
import Model.KMessage;
import Model.Users;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Nam Lee
 */
public class Main extends javax.swing.JFrame implements inReceiveMessage {

    ListenServer listenServer;

    JGoban Goban;
    JScrollPane jScroll;

    int GameState = 0;
    static final int WAIT = 0;
    static final int MY_TURN = 1;
    static final int YOU_WIN = 2;
    static final int YOU_LOSE = 3;
    boolean PLAYER_SS = false;
    boolean IS_BOSS = false;
    //
    static time t;
//
    StyledDocument doc;
    Style regular;
    Style def;

    Icon icon = new ImageIcon("C:\\Users\\Laptop TVT\\Documents\\NetBeansProjects\\CaroLTM\\src\\image\\haha.png");

    /**
     * Creates new form Main
     */
    public Main(ListenServer listenServer) {
        initComponents();
        // Thiết lập tiêu đề
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Thiết lập icon
        setIcon();

        setLayout(new BorderLayout());

        InitGame();
        setLocationRelativeTo(null);
        // Thiết lập lắng nghe từ server
        this.listenServer = listenServer;
        this.listenServer.receive = this;

        String yourUser = listenServer.user.getUsername().trim();
        lbYou.setText("Xin chào: " + yourUser);
        setTitle("Game caro online!! -- " + yourUser);
        lbTime.setText("00:00");
        //
        doc = jTextPane1.getStyledDocument();
        def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
        regular = doc.addStyle("regular", def);
        StyleConstants.setFontFamily(def, "SansSerif");
        jTextPane1.setEditable(false);
        this.t = new time(lbTime, listenServer, 30);
        try {
            //Lấy thông tin người chơi
            listenServer.SendMessage(28, null);
            listenServer.SendMessage(30, null);
            listenServer.SendMessage(29, null);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    void InitGame() {
        // vẽ bàn cờ
        Goban = new JGoban();
        Goban.setPreferredSize(new Dimension(500, 500));

        panelCaro.setViewportView(Goban);

        Goban.Sakiyomi = true;
        Goban.Kinjite = true;

        Goban.init(500, 500);
        Goban.Initialize();
        Goban.Draw();
    }

    void putStatus(String strStt) {
        //Viết trạng thái
        lblStatus.setText(strStt);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName1 = new javax.swing.JLabel();
        lblName2 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblScore1 = new javax.swing.JLabel();
        lblScore2 = new javax.swing.JLabel();
        txtChat = new javax.swing.JTextField();
        btn_haha = new javax.swing.JButton();
        btn_play = new javax.swing.JButton();
        panelCaro = new javax.swing.JScrollPane();
        lbYou = new javax.swing.JLabel();
        lbTime = new javax.swing.JLabel();
        btnExitRoom = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblName1.setText("Đối thủ 1");

        lblName2.setText("đối thủ 2");

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStatus.setText("Vui Lòng chờ ....");

        jLabel4.setFont(new java.awt.Font("OctemberScriptVi", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("X");

        jLabel5.setFont(new java.awt.Font("ThuphapXuan", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("O");

        lblScore1.setText("Điểm: ");

        lblScore2.setText("Điểm:");

        txtChat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChatKeyPressed(evt);
            }
        });

        btn_haha.setText("Haha");
        btn_haha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hahaMouseClicked(evt);
            }
        });
        btn_haha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hahaActionPerformed(evt);
            }
        });

        btn_play.setText("SS/BD/Chơi lại");
        btn_play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_playMouseClicked(evt);
            }
        });
        btn_play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_playActionPerformed(evt);
            }
        });

        panelCaro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCaroMouseClicked(evt);
            }
        });

        lbYou.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        lbYou.setForeground(new java.awt.Color(51, 51, 255));
        lbYou.setText("Bạn:");

        lbTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTime.setText("Thời gian...");

        btnExitRoom.setText("Thoát");
        btnExitRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitRoomMouseClicked(evt);
            }
        });
        btnExitRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitRoomActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCaro, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblName2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblScore2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTime))
                            .addComponent(lblScore1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbYou, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_play, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_haha))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExitRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbYou, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_play, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblName1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblScore1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTime)
                                .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(23, 23, 23)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(lblScore2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExitRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_haha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelCaro, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_playMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_playMouseClicked

    private void panelCaroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCaroMouseClicked
        // TODO add your handling code here:
        //Chơi cờ.

        // lấy vị trí click chuột
        int x = evt.getX();
        int y = evt.getY();

        // Tới lượt mình mới được đánh
        if (GameState == MY_TURN) {
            GPos pos = new GPos();
            //lấy vị trí bàn
            int offetX = Goban.getX();
            int offetY = Goban.getY();

            if (!Goban.GetPos(x - offetX, y - offetY, pos)) {
                return;
            }

            // neu trang thai rong
            if (Goban.Pieces[pos.x][pos.y].State == CPiece.EMPTY) {
                try {
                    // Chuyển trạng thái game sang đợi
                    GameState = WAIT;
                    putStatus("Đợi...");
                    this.t.setDieuKien(false);
                    lbTime.setText("WAIT...");
                    listenServer.SendMessage(30, pos);

                } catch (IOException ex) {
                    System.out.println(ex);
                }
            } else {
                putStatus("Không đánh được vào đây!");
            }
        } else {
            putStatus("Chưa tới lượt!");
        }

    }//GEN-LAST:event_panelCaroMouseClicked

    private void btn_hahaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hahaMouseClicked
        try {
            // TODO add your handling code here:
            String strMess = listenServer.user.getUsername().trim();
            StyleContext context = new StyleContext();
            Style labelStyle = context.getStyle(StyleContext.DEFAULT_STYLE);
            JLabel label = new JLabel(new ImageIcon(((new ImageIcon("C:\\Users\\Laptop TVT\\Documents\\NetBeansProjects\\CaroLTM\\src\\image\\haha.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
            StyleConstants.setComponent(labelStyle, label);
            doc.insertString(doc.getLength(), strMess + ":  ", regular);
            doc.insertString(doc.getLength(), "Ignored", labelStyle);
            doc.insertString(doc.getLength(), "\n", regular);
            // gửi dữ liệu lên khung chat textArea
            //Gửi chat tới server để server gửi lại đối thủ
            try {
                listenServer.SendMessage(40, strMess);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_hahaMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            // TODO add your handling code here:
            listenServer.SendMessage(100, listenServer.user);
            System.out.println("Đã gửi yêu càu đóng!");
            listenServer.closeLS();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnExitRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitRoomMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitRoomMouseClicked

    private void btnExitRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitRoomActionPerformed
        // TODO add your handling code here:
        try {
            // Thông báo thoát
            listenServer.SendMessage(39, listenServer.user);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    //bật giao diện chọn phòng
                    new RoomFrame(listenServer).setVisible(true);
                }
            });
            //Thoát
            this.dispose();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnExitRoomActionPerformed

    private void btn_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_playActionPerformed
        // TODO add your handling code here:
        try {
            if (IS_BOSS == true && PLAYER_SS == true) {
                listenServer.SendMessage(104, null);
                putStatus("Đến lượt bạn!");
            } else if (!IS_BOSS) {
                putStatus("Bạn đã sẵn sàng!");
                listenServer.SendMessage(103, null);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_playActionPerformed

    private void txtChatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChatKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String strMess = listenServer.user.getUsername().trim() + ":  " + txtChat.getText();
            // gửi dữ liệu lên khung chat textArea
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                try {
                    doc.insertString(doc.getLength(), strMess + "\n", doc.getStyle("regular"));
                } catch (BadLocationException ex) {
                }
                txtChat.setText("");
            }
            //Sau khi gửi thi set text fied  là rỗng
            txtChat.setText("");

            //Gửi chat tới server
            try {
                listenServer.SendMessage(40, strMess);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }//GEN-LAST:event_txtChatKeyPressed

    private void btn_hahaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hahaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hahaActionPerformed

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
            @Override
            public void run() {
                new LoginForm().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExitRoom;
    private javax.swing.JButton btn_haha;
    private javax.swing.JButton btn_play;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbYou;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblScore1;
    private javax.swing.JLabel lblScore2;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JScrollPane panelCaro;
    private javax.swing.JTextField txtChat;
    // End of variables declaration//GEN-END:variables

    // Ghi đè 
    @Override
    public void ReceiveMessage(KMessage msg) throws IOException {
        switch (msg.getType()) {
            case 30: // Lấy bàn cờ
            {
                Goban.Pieces = (CPiece[][]) msg.getObject();
                Goban.Draw();
                break;
            }
            case 31: {
                putStatus("Đã tới lượt bạn");
                GameState = MY_TURN;
                this.t.setT(30);
                this.t.setDieuKien(true);
                break;
            }
            case 32: {
                if (IS_BOSS) {
                    putStatus("Đã tới lượt bạn");
                    GameState = MY_TURN;
                    this.t.setT(30);
                    this.t.setDieuKien(true);
                }
                break;
            }
            case 34: // Thong tin 2 ng choi
            {
                Users[] arrUser = (Users[]) msg.getObject();
                if (arrUser != null && arrUser.length >= 2) {
                    lblName1.setText(arrUser[0].getUsername());
                    lblScore1.setText("" + arrUser[0].getScore());
                    lblName2.setText(arrUser[1].getUsername());
                    lblScore2.setText("" + arrUser[1].getScore());
                }
                break;
            }
            case 35: {
                if (PLAYER_SS == true) {
                    if ("win".equalsIgnoreCase(msg.getObject().toString())) {
                        GameState = YOU_WIN;
                        putStatus("Bạn đã chiến thắng");
                    } else if ("lose".equalsIgnoreCase(msg.getObject().toString())) {
                        GameState = YOU_LOSE;
                        putStatus("Bạn đã thua!!");
                    }
                    PLAYER_SS = false;
                }
                break;
            }
            case 36: {
                if (!IS_BOSS) {
                    putStatus("Hãy ấn sẵn sàng!");
                }
                break;
            }
            case 37: {
                putStatus("Chờ đối phương sẵn sàng!");
                break;
            }
            case 38: {
                if (IS_BOSS) {
                    putStatus("Nhấn bắt đầu để chơi!");
                    PLAYER_SS = true;
                }
                break;
            }
            case 40: // Recieve Message
            {
                String strMess = msg.getObject().toString();
                if (strMess.indexOf(":") != -1) {
                    try {
                        doc.insertString(doc.getLength(), strMess + "\n", doc.getStyle("regular"));
                    } catch (BadLocationException ex) {
                    }
                } else {
                    try {
                        StyleContext context = new StyleContext();
                        Style labelStyle = context.getStyle(StyleContext.DEFAULT_STYLE);
                        JLabel label = new JLabel(new ImageIcon(((new ImageIcon("C:\\Users\\Laptop TVT\\Documents\\NetBeansProjects\\CaroLTM\\src\\image\\haha.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
                        StyleConstants.setComponent(labelStyle, label);
                        doc.insertString(doc.getLength(), strMess + ":  ", regular);
                        doc.insertString(doc.getLength(), "Ignored", labelStyle);
                        doc.insertString(doc.getLength(), "\n", regular);
                    } catch (BadLocationException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
            case 101: {
                String str = msg.getObject().toString();
                if (str.equalsIgnoreCase("yes")) {
                    btn_play.setText("Bắt đầu");
                    IS_BOSS = true;
                } else {
                    btn_play.setText("Sẵn Sàng");
                }
                break;
            }
            case 102: {
                String str = msg.getObject().toString();
                lbTime.setText(str);
                break;
            }
        }
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/IconPlayer.jpg")));
    }
}
