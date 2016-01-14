import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class StatusBar extends JComponent {
	
	double x = 0;
	Color tempC = Color.black;
	
	public void paintComponent(Graphics g){
		
		g.setColor(Color.black);
		g.drawRect(20, 10, 200, 50);
		g.fillRect(20, 10, (int) x, 50);
	}
	
	public void setNewValues(double tempx){
		x = tempx;
		repaint();
	}
}
