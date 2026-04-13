import javax.swing.*;
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
	
	JPanel obraz = new JPanel() {
		public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(77, 129, 249));
    		g.fillRect(0, 0, getWidth(), getHeight());
    		g.drawImage(img, 30, ptakY, 45, 35, this);
    		g.setColor(Color.green);
    		g.fillRect(ruraX, 0, 50, ruraWys);
    		g.fillRect(ruraX, ruraWys+przerwa, 50, getHeight());
	}
	};
	public void init() {
		setSize(500, 500);
		add(obraz);
		img = getImage(getDocumentBase(), "ptak.png");
		timer = new Timer(20, this);
        timer.start();
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
        		ptakV = -12;
        	}
        });
        
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
		if (ptakY < 0) {
			ptakY = 0;
			ptakV = 0;
		}
		obraz.repaint();
	}
}
