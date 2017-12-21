import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private Image img;
	private double width,height;
	 
	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }
	 
	  public ImagePanel(Image img) {
	    this.img = img;
	    
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }
	 
	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0,(ImageObserver) this);
	  }
}
