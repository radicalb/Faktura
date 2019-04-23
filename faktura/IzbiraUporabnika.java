package faktura;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author radicalb
 */
public class IzbiraUporabnika extends javax.swing.JFrame {

    /**
     * Creates new form IzbiraUporabnika
     */
    public IzbiraUporabnika() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Izbira uporabnika");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "nalagam ..." }));

        jButton1.setText("Potrdi");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("Prosimo izberite uporabnika");

        jButton2.setText("Dodaj uporabnika");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Administrator");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

final static Charset ENCODING = StandardCharsets.UTF_8;
private String getPathFromTextFile(String aFileName){
    Path path = Paths.get(aFileName);
    try (Scanner scanner =  new Scanner(path, ENCODING.name())){
      while (scanner.hasNextLine()){
        return scanner.nextLine();
      }      
    }catch(IOException ie){
       System.out.print(ie);
    }
    return null;
}
    
private static String OS = System.getProperty("os.name").toLowerCase();

private static boolean isWindows() {
    return (OS.indexOf("win") >= 0);
}

private static boolean isUnix() {
    return (OS.indexOf("nux") >= 0);
}


    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.setLocationRelativeTo(null); //centriram okno
        try{

            java.sql.Driver d = null;
            java.sql.Connection c = null;
            java.sql.Statement s = null;
            java.sql.ResultSet rs = null;
            int SQLExceptionErrorCode=0;
            
            do{
            try {
              c = java.sql.DriverManager.getConnection (Faktura.databaseURL, Faktura.user, Faktura.password);
              System.out.println ("Connection established.");
              SQLExceptionErrorCode=0;
            }
            catch (java.sql.SQLException e) {
              System.out.println ("Unable to establish a connection through the driver manager.");
              SQLExceptionErrorCode=e.getErrorCode();
              if(e.getErrorCode()==335544472){
                 System.out.println("Unknown database username or password!"); 
           
                 JPanel panel = new JPanel(new BorderLayout(5, 5));

                JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
                label.add(new JLabel("Uporabniško ime", SwingConstants.RIGHT));
                label.add(new JLabel("Geslo", SwingConstants.RIGHT));
                panel.add(label, BorderLayout.WEST);

                JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
                JTextField username = new JTextField();
                controls.add(username);
                JPasswordField password = new JPasswordField();
                controls.add(password);
                panel.add(controls, BorderLayout.CENTER);
    
                 int action = JOptionPane.showConfirmDialog(null, panel,"Prijava v podatkovno bazo ni uspela! Prosim vnesite prijavne podatke.",JOptionPane.OK_CANCEL_OPTION); 
                 Faktura.user=username.getText();
                 Faktura.password=new String(password.getPassword());
                 System.out.println("User:"+Faktura.user);
                 System.out.println("Password:"+Faktura.password);
                 
              }else if(e.getErrorCode()==335544344){
                 System.out.println("Wrong db path! Reading from conf file!"); 
                 //linux
                 //String path=System.getProperty( "user.home" )+File.separator+"Faktura.settings.txt";
                 String path="Faktura.settings.txt";
                 if(Faktura.testMode==false){
                    path="Faktura.settings.txt";
                 }else{
                    path="Faktura.testsettings.txt";
                 }
                 String newDBPath = getPathFromTextFile(path);
                 
                 if(newDBPath!=null){
                     Faktura.databaseURL = newDBPath;
                     System.out.println(Faktura.databaseURL);
                 }else{
                     System.out.println("Cant find DB path conf file!!! Creating one.");
                     
                     File f = new File(path); 
                     //File dir = new File(f.getParent()); 
                     try {
                        //dir.mkdirs();
                        f.createNewFile();
                     } catch (IOException ex) {
                        Logger.getLogger(IzbiraUporabnika.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                     try {
                        PrintWriter outF = new PrintWriter(path);
                        outF.println(Faktura.databaseURL);
                        outF.close();  
                     } catch (FileNotFoundException ex) {
                                Logger.getLogger(IzbiraUporabnika.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     JOptionPane.showMessageDialog(null, "Uredi pot do podatkovne baze v datoteki: "+f.getAbsolutePath());
                     System.exit(0);
                 }
              }else{
                System.out.print(e.getErrorCode());
                System.exit(0);
              }
            }
            }while(SQLExceptionErrorCode!=0);
            
            s = c.createStatement ();
            rs = s.executeQuery ("select ime from prodajalec");
            
            jComboBox1.removeAllItems();
            while (rs.next ()) {
                String uporabnik = rs.getString ("ime");
                System.out.println (uporabnik);
                jComboBox1.addItem(uporabnik);
            }
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GlavnoOkno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Faktura.uporabnikGlobal=jComboBox1.getSelectedItem().toString();
        System.out.println (Faktura.uporabnikGlobal);
        
        
        if(jCheckBox1.isSelected()){
            JPasswordField pwd = new JPasswordField(10);  
            int action = JOptionPane.showConfirmDialog(null, pwd,"Administratorsko geslo",JOptionPane.OK_CANCEL_OPTION); 
            String adminPass=new String(pwd.getPassword());
            if(!(Faktura.notEmpty(adminPass))){
                JOptionPane.showMessageDialog(rootPane,"Vnesli ste napačno administratorsko geslo! Prijavljeni boste kot navaden uporabnik.");
                return;
            } 
            try{

                java.sql.Driver d = null;
                java.sql.Connection c = null;
                java.sql.Statement s = null;
                java.sql.ResultSet rs = null;
            
                try {
                    c = java.sql.DriverManager.getConnection (Faktura.databaseURL, Faktura.user, Faktura.password);
                    System.out.println ("Connection established.");
                }
                catch (java.sql.SQLException e) {
                    System.out.println ("Unable to establish a connection through the driver manager.");
                }
            
                s = c.createStatement ();
                rs = s.executeQuery("SELECT vrednoststring FROM nastavitve WHERE naziv='adminPass'");
            
                
                rs.next();
                //System.out.println (rs.getString("vrednoststring")+"|"+adminPass);
                if(adminPass.equals(rs.getString("vrednoststring"))){
                    Faktura.adminMode=true;
                }else{
                    JOptionPane.showMessageDialog(rootPane,"Vnesli ste napačno administratorsko geslo! Prijavljeni boste kot navaden uporabnik.");
                }
                
           
                c.close();
            
            } catch (SQLException ex) {
                Logger.getLogger(GlavnoOkno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        new GlavnoOkno().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String novUporabnik=JOptionPane.showInputDialog("Vnesite ime novega uporabnika/prodajalca");
        if(!(Faktura.notEmpty(novUporabnik))){
            return;
        }
        
        try{

            java.sql.Driver d = null;
            java.sql.Connection c = null;
            java.sql.Statement s = null;
            Boolean rs = null;
            
            try {
              c = java.sql.DriverManager.getConnection (Faktura.databaseURL, Faktura.user, Faktura.password);
              System.out.println ("Connection established.");
            }
            catch (java.sql.SQLException e) {
              System.out.println ("Unable to establish a connection through the driver manager.");
            }
            
            s = c.createStatement ();
            rs = s.execute("INSERT INTO prodajalec(ime) VALUES('"+novUporabnik+"')");
            
            jComboBox1.addItem(novUporabnik);
           
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GlavnoOkno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IzbiraUporabnika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IzbiraUporabnika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IzbiraUporabnika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IzbiraUporabnika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new IzbiraUporabnika().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
