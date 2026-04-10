import javax.swing.JApplet;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

public class GlownyApplet extends JApplet implements ActionListener{
	int ruraWys = 150;
	int ruraX = 400;
	int przerwa = 150;
	
	int ptakY = 200;
	int ptakV = 0;
	
	Timer timer;
	Image img;
	@Override
	public void init() {
		setSize(500, 500);
		img = getImage(getDocumentBase(), "ptak.png");
		timer = new Timer(20, this);
        timer.start();
	}

	@Override
	public void paint(java.awt.Graphics g) {
		g.setColor(new Color(77, 129, 249));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(img, 30, ptakY, 45, 35, this);
		g.setColor(Color.green);
		g.fillRect(ruraX, 0, 50, ruraWys);
		g.fillRect(ruraX, ruraWys+przerwa, 50, getHeight());
	}
	public void actionPerformed(ActionEvent e) {
		ptakV += 1;
		ptakY += ptakV;
		
		ruraX -= 5;
		
		if(ruraX + 50 < 0) {
			ruraX = getWidth();
		}
		
		if (ptakY > getHeight()-20) {
			ptakY = getHeight()-20;
			ptakV = 0;
		}
		repaint();
	}
}
