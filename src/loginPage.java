
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class loginPage extends javax.swing.JFrame {
    private File file;
    private int val=0;
    private String mes="Giris Basarili! Yonlendiriliyorsunuz";

    public loginPage() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user_loginBTN = new javax.swing.JButton();
        user_registerBTN = new javax.swing.JButton();
        user_pass = new javax.swing.JPasswordField();
        info_message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kullanici Girisi");

        jLabel1.setText("Kullanici Adi:");

        jLabel2.setText("Sifre:");

        user_loginBTN.setText("Giris Yap");
        user_loginBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_loginBTNActionPerformed(evt);
            }
        });

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
                .addGap(182, 182, 182)
                .addComponent(user_registerBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(info_message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(user_name, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(user_pass))
                        .addGap(18, 18, 18)
                        .addComponent(user_loginBTN)))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(user_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(user_loginBTN)))
                .addGap(34, 34, 34)
                .addComponent(user_registerBTN)
                .addGap(18, 18, 18)
                .addComponent(info_message)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void user_loginBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_loginBTNActionPerformed
        
        file=new File("users.bin");
        
        if(file.exists()){
            
           try(Scanner scan=new Scanner(new FileReader("users.bin"))){
               String name=user_name.getText();
               int check=0;
               String pass=new String(user_pass.getPassword());
               pass+="1789^s41Ab*29%1235@4$yG(%?{\\<C@X#Z1L9\\a!H?:)_d";
               while(scan.hasNextLine()){
                   String[] tmp=scan.nextLine().split(",");
                   if(tmp[0].equals(name)){
                       check=1;
                    if(!tmp[2].equals(pass)){
                       info_message.setForeground(Color.red);
                       info_message.setText("Sifre Yanlis!");                       
                   }else if(tmp[2].equals(pass)){
                       info_message.setForeground(new Color(0,100,0));
                       info_message.setText(mes);
                       
                        Timer timer=new Timer(600, null);
                        timer.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                        val++;
                        mes+=" # ";
                        info_message.setText(mes);
                        if(val==5){
                        setVisible(false);
                        System.exit(0);
                        timer.stop();
                    }
                }
                
            });
            timer.start();
                        }
                   }
               }
               if(check==0){
                       info_message.setForeground(Color.red);
                       info_message.setText("Kullanici Adi Bulunamadi!");                     
               }
           } catch (FileNotFoundException ex) { 
                Logger.getLogger(loginPage.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        }else{
            JOptionPane.showMessageDialog(this, "DataBase'de Hic Kullanici Yok!");
        }
        
    }//GEN-LAST:event_user_loginBTNActionPerformed

    public void loginInject(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginPage().setVisible(true);
            }
        });
    }
    
    private void user_registerBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_registerBTNActionPerformed
        registerPage reg=new registerPage();
        setVisible(false);
        reg.registerInject();
    }//GEN-LAST:event_user_registerBTNActionPerformed

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
            java.util.logging.Logger.getLogger(loginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new loginPage().setLocationRelativeTo(null);
            new loginPage().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel info_message;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton user_loginBTN;
    private javax.swing.JTextField user_name;
    private javax.swing.JPasswordField user_pass;
    private javax.swing.JButton user_registerBTN;
    // End of variables declaration//GEN-END:variables
}
