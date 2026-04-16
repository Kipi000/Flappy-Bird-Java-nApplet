import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GlownyApplet extends JApplet implements ActionListener, MouseListener{
	Random Rand = new Random();
	
	int ruraWys = Rand.nextInt(300);
	int ruraX = 450;
	int przerwa = Rand.nextInt(50)+120;
	
	int ptakY = 200;
	int ptakV = 0;
	
	int n = 0;
	
	Timer timer;
	Image img;
	
	boolean gameOver = false;
	
	JPanel obraz = new JPanel() {
		public void paintComponent(Graphics g) {
            g.setColor(new Color(77, 129, 249));
    		g.fillRect(0, 0, getWidth(), getHeight());
    		g.drawImage(img, 30, ptakY, 45, 35, this);
    		g.setColor(Color.green);
    		g.fillRect(ruraX, 0, 50, ruraWys);
    		g.fillRect(ruraX, ruraWys+przerwa, 50, getHeight());
    		 if (gameOver == true) {
    			 g.setColor(new Color(77, 129, 249));
    			 g.fillRect(0, 0, getWidth(), getHeight());
                 g.setColor(Color.red);
                 g.setFont(new Font("Arial", Font.BOLD, 30));
                 g.drawString("GAME OVER", 170, 220);
                 g.setColor(Color.white);
                 g.drawString("LICZBA PUNKTÓW: "+n, 110, 270);
             }else {
            	 g.setColor(Color.white);
            	 g.drawString("Liczba punktów "+n, 200, 20);
             }
	}
	};
	public void init() {
		setSize(500, 500);
		add(obraz);
		img = getImage(getDocumentBase(), "ptak.png");
		timer = new Timer(20, this);
        timer.start();
        addMouseListener(this);
	}
    public void mousePressed(MouseEvent e) {
		ptakV = -12;
		n = n + 1;
	}
	
    public void gameOver() {
        gameOver = true;
        timer.stop();
    }
    
	public void actionPerformed(ActionEvent e) {
		ptakV += 1;
		ptakY += ptakV;
		
		ruraX -= 5;
		
		if(ruraX + 50 < 0) {
			ruraWys = Rand.nextInt(300);
			przerwa = Rand.nextInt(50)+120;
			ruraX = getWidth();
		}
		
		if (ptakY > getHeight()-20) {
			gameOver();
		}
		if (ptakY < 0) {
			ptakY = 0;
			ptakV = 0;
		}
		Rectangle ptak = new Rectangle(30, ptakY, 40, 25);
        Rectangle ruraGorna = new Rectangle(ruraX, 0, 50, ruraWys);
        Rectangle ruraDolna = new Rectangle(ruraX, ruraWys + przerwa, 50, getHeight());

        if (ptak.intersects(ruraGorna) || ptak.intersects(ruraDolna)) {
            gameOver();
        }
		obraz.repaint();
	}
	public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
