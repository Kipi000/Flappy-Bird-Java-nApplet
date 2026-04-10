import javax.swing.JApplet;

public class GlownyApplet extends JApplet {
	@Override
	public void init() {
	    // Tu wpisujesz to, co ma się stać przy starcie apletu
	    System.out.println("Aplet zainicjowany!");
	}

	@Override
	public void paint(java.awt.Graphics g) {
	    // Tu rysujesz grafikę
	    g.drawRect(50, 50, 100, 100); // Rysuje kwadrat
	    g.drawString("Mój pierwszy aplet", 60, 80);
	}
}
