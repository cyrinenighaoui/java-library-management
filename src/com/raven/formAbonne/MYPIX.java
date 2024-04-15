import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.net.URL;


public class MYPIX extends javax.swing.JFrame {
/**
 * 
 */
private static final long serialVersionUID = 1L;
public void myFrame (){

}

/**
 * Creates new form MYPIX
 */
public MYPIX() {
 //   initComponents();
try {
    this.setSize(200, 200);
    URL url = new URL("http://i.imgur.com/xiVXrCD.jpg");
    BufferedImage image = ImageIO.read(url);
    MYJ = new JLabel(new ImageIcon(image));
    image = ImageIO.read(url);
    this.add(MYJ);

} catch (IOException e) {
    e.printStackTrace();

         ImageIcon I22 = new ImageIcon();
                MYJ.setIcon(I22);
}

}

public static void main(String args[]) {

java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        new MYPIX().setVisible(true);
    }
});
}
private javax.swing.JLabel MYJ; 
// End of variables declaration                   
 } 