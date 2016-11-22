import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class CashMachine extends WindowAdapter {

	Frame frame;
	Panel panel;
	Button buttonShoot, buttonRefill;
	TextField textFieldInput;
	TextField textFieldOutput;

	int result = 0;

	public CashMachine() {

		frame = new Frame("ATM");
		panel = new Panel();

		textFieldInput = new TextField("" + result); // ?
		textFieldOutput = new TextField("" + result);
		buttonShoot = new Button("Shoot");
		buttonRefill = new Button("Refill");
	}

	public void launchFrame() {
		buttonShoot.addActionListener(new IncActionListener());
		buttonRefill.addActionListener(new DecActionListener());
		frame.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 2));
		panel.add(new Button("Balance"));
		panel.add(textFieldInput);
		panel.add(new Button("Money: "));
		panel.add(textFieldOutput);
		panel.add(buttonShoot);
		panel.add(buttonRefill);
		frame.addWindowListener(this);
		frame.setSize(500, 400);
		frame.setVisible(true);
	}

	public void windowClosing(WindowEvent e) { // close the frame/window
		frame.dispose();
	}

	public static void main(String[] args) {
		CashMachine cashMachine = new CashMachine();
		cashMachine.launchFrame();
		
	}

	class IncActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textFieldInput.setText("" + (Integer.parseInt(textFieldInput.getText()) - Integer.parseInt(textFieldOutput.getText())));
		}
	}

	class DecActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textFieldInput.setText("" + (Integer.parseInt(textFieldInput.getText()) + Integer.parseInt(textFieldOutput.getText())));
		}
	}
}