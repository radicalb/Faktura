/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faktura;


/**
 *
 * @author radicalb
 */
public class Faktura {

    /**
     * @param args the command line arguments
     */
    public static String uporabnikGlobal;
    public static String databaseURL;
    public static String user = "sysdba";
    public static String password = "masterkey";
    public static boolean adminMode=false;
    public static boolean testMode=false;
    
    public static Object makeObj(final String item)  {
        return new Object() { public String toString() { return item; } };
    }
    
    public static boolean notEmpty(String s) {
        return (s != null && s.length() > 0);
    }
    
    public static void main(String[] args) {
        databaseURL = "jdbc:firebirdsql:localhost/3050:"+args[0]+"?sql_dialect=3";
        user = args[1];
        password = args[2];
        if(args.length>3){
            if(args[3].equalsIgnoreCase("TESTMODE")){
                testMode=true;
            }
        }
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
            java.util.logging.Logger.getLogger(GlavnoOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GlavnoOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GlavnoOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GlavnoOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        // TODO code application logic here
        new IzbiraUporabnika().setVisible(true);
    }
}