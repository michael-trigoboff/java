import java.awt.*;
import java.awt.event.*;
import javax.swing.JTextField;
//import javax.swing.event.*;

@SuppressWarnings("serial")
class JavaAppletContents extends Canvas implements ActionListener, Runnable {
	private JTextField		coords;
	private Color			bgColor = Color.green;
	private String			text;
	private Thread			blinker = new Thread(this);
	private boolean			blinking = false;
	private boolean			blinkState = false;

	private MouseAdapter	ma = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			coords.setText(String.format("x = %d, y = %d", e.getX(), e.getY()));
		}
	};

	JavaAppletContents(JTextField coords, String text) {
		this.coords = coords;
		this.text = text;
		addMouseListener(ma);
	}
	
	void start() {
		blinking = true;
		blinkState = false;
		blinker.start();
	}
	
	public void run() {
		while (blinking) {
			try { Thread.sleep(1000); } catch (InterruptedException e) { }
			blinkState = ! blinkState;
			repaint();
		}
	}

	void stop() {
		blinking = false;
	}
	
	// switch the background color
	private void switchColor() {
		bgColor = bgColor.equals(Color.green) ? Color.yellow : Color.green;
		repaint();
	}

	// button was pressed
	public void actionPerformed(ActionEvent e) {
		switchColor();
		coords.setText("");
	}

	public void paint(Graphics g) {
		Dimension	size = getSize();
		int			margin = 2;
		int			inMarginsW = size.width - 2 * margin;
		int			inMarginsH = size.height - 2 * margin;
		int			fontSize = inMarginsH / 8;
		FontMetrics	fm;
		int			textWidth;
		int			maxAscent;

		g.setColor(bgColor);
		g.fillRect(margin, margin, inMarginsW, inMarginsH);
		g.setColor(Color.blue);
		g.drawOval(margin, margin, inMarginsW, inMarginsH);
		if (blinkState) {
			g.setColor(Color.red);
			g.setFont(new Font("Courier", Font.BOLD, fontSize));
			fm = g.getFontMetrics();
			textWidth = fm.stringWidth(text);
			maxAscent =  fm.getMaxAscent();
			g.drawString(text, margin + inMarginsW / 2 - textWidth / 2,
							   margin + inMarginsH / 2 + maxAscent / 3);
		}
	}
}
