//import java.applet.*;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class JavaApplet extends JApplet {
	private JPanel				lowerPanel;
	private JavaAppletContents	content;
	private JTextField			coords;
	private JButton				switchColorBtn;

	public void init() {
		String textParm = getParameter("text");

		super.init();

		// set up GUI for this applet
		setLayout(new BorderLayout());
		lowerPanel = new JPanel(new BorderLayout());
		switchColorBtn = new JButton("Switch Color");
		lowerPanel.add(switchColorBtn, BorderLayout.EAST);
		coords = new JTextField(15);
		coords.setEditable(false);
		coords.setHorizontalAlignment(JTextField.CENTER);
		lowerPanel.add(coords, BorderLayout.WEST);
		add(lowerPanel, BorderLayout.SOUTH);
		content = new JavaAppletContents(coords, textParm == null ? "No HTML Text": textParm);
		add(content, BorderLayout.CENTER);		
		switchColorBtn.addActionListener(content);
	}

	public void start() {
		super.start();
		content.start();
	}

	public void stop() {
		super.stop();
		content.stop();
	}

	public void destroy() {
		super.destroy();
	}
}
