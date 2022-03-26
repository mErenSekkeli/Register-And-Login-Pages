
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class registerPage extends javax.swing.JFrame {
    private int val=0;
    private String mes="Kayit Basarili! Yonlendiriliyorsunuz";
    public registerPage() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user_mail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        user_pass = new javax.swing.JPasswordField();
        user_pass2 = new javax.swing.JPasswordField();
        user_registerBTN = new javax.swing.JButton();
        info_message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kullanici Kaydi");

        jLabel1.setText("Kullanici Adi:");

        jLabel2.setText("E-mail:");

        jLabel3.setText("Sifre:");

        jLabel4.setText("Sifre Tekrar:");

        user_registerBTN.setText("Kaydol");
        user_registerBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_registerBTNActionPerformed(evt);
            }
        });

        info_message.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(user_registerBTN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(info_message, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(user_name, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(user_mail)
                            .addComponent(user_pass)
                            .addComponent(user_pass2))))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(user_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(user_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(user_pass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(user_registerBTN)
                .addGap(18, 18, 18)
                .addComponent(info_message)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void user_registerBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_registerBTNActionPerformed
       String pass=new String(user_pass.getPassword());
       String pass2=new String(user_pass2.getPassword());
      if(user_name.getText().equals("")){
          info_message.setForeground(Color.red);
          info_message.setText("Lutfen Kullanici Adi Girin.");
      }else if(user_name.getText().length()<6){
          info_message.setForeground(Color.red);
          info_message.setText("Lutfen Kullanici Adini En Az 6 Harfli Olarak Girin.");          
      }else if(user_mail.getText().equals("") || !user_mail.getText().contains("@")||!user_mail.getText().contains(".")){
          info_message.setForeground(Color.red);
          info_message.setText("Lutfen Mail Adresinizi Dogru Girin.");
      }else if(user_pass.getPassword().equals("")){
          info_message.setForeground(Color.red);
          info_message.setText("Lutfen Bir Sifre Girin.");
      }else if(pass.length()<8){
          info_message.setForeground(Color.red);
          info_message.setText("Lutfen En Az 8 Haneli Bir Sifre Girin.");          
      }else if(pass2.equals("")){
          info_message.setForeground(Color.red);
          info_message.setText("Lutfen Girdiginiz Sifreyi Tekrar Girin.");           
      }else if(!pass.equals(pass2)){
          info_message.setForeground(Color.red);
          info_message.setText("Lutfen Sifrelerin Ayni Oldugunu Dogrulayin.");           
      }else{
        try(FileWriter out=new FileWriter("users.bin")){
           
            String tmp=user_name.getText()+",";
            tmp+=user_mail.getText()+",";
            pass+="1789^s41Ab*29%1235@4$yG(%?{\\<C@X#Z1L9\\a!H?:)_d";
            tmp+=pass;
            info_message.setForeground(new Color(0,100,0));
            out.write(tmp+"\n");
            info_message.setText(mes);
            Timer timer=new Timer(800, null);
            timer.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    val++;
                    mes+=" # ";
                    info_message.setText(mes);
                    if(val==5){
                        setVisible(false);
                        loginPage log=new loginPage();
                        log.loginInject();
                        timer.stop();
                    }
                }
                
            });
            timer.start();
        } catch (IOException ex) {
              Logger.getLogger(registerPage.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
     
        
    }//GEN-LAST:event_user_registerBTNActionPerformed
public void registerInject(){
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registerPage().setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel info_message;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField user_mail;
    private javax.swing.JTextField user_name;
    private javax.swing.JPasswordField user_pass;
    private javax.swing.JPasswordField user_pass2;
    private javax.swing.JButton user_registerBTN;
    // End of variables declaration//GEN-END:variables
}
