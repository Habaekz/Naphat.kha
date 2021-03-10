import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.applet.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class paint extends Applet{
	
	 public void paint(Graphics graphics) {
	        /* We would be using this method only for the sake
	         * of brevity throughout the current section. Note
	         * that the Graphics class has been acquired along
	         * with the method that we overrode. */
		 	//graphics.setColor(Color.black);
	        //graphics.drawLine(40, 30, 330, 380);
		 	graphics.setColor(Color.red);
		 	graphics.fillRect(100, 100, 100, 100);
		 	graphics.setColor(Color.red);
		 	graphics.drawRect(100, 100, 100, 100);
		 	graphics.setColor(Color.green);
	        graphics.drawOval(10, 10, 100, 100);
	        
		 	
	    }

	    public static void main(String[] args) {
	        paint canvas = new paint();
	        JFrame frame = new JFrame();
	        frame.setSize(400, 400);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().add(canvas);
	        frame.setVisible(true);
	    }
	
}
