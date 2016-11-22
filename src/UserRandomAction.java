import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*1. Написать программу, которая вызывает графический пользовательский интерфейс с такими функциями:
слева находятся панель и кнопка, после нажатия на которую панель меняет свой цвет на случайный;
справа находятся текстовое поле с 0 и две кнопки, при нажатии на которые значение в поле или увеличивается или уменьшается.*/

public class UserRandomAction extends WindowAdapter {

	Frame frame;
	Panel panel1;
	Panel panel2;
	Button button, buttonPlus, buttonMinus, buttonPressResult;
	TextField textField;
	int counter = 0;

	Color c = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));

	public UserRandomAction() {

		frame = new Frame("HELOOOOOO");
		panel1 = new Panel();
		panel2 = new Panel();
		textField = new TextField("" + counter);
		button = new Button("Press me now!");
		buttonPressResult = new Button("GOOOOOD!");
		buttonPlus = new Button("+");
		buttonMinus = new Button("-");

	}

	public void launchFrame() {
		button.addActionListener(new ButtonListener());
		buttonPlus.addActionListener(new IncActionListener());
		buttonMinus.addActionListener(new DecActionListener());
		frame.add(panel1, BorderLayout.CENTER);
		panel1.setBackground(Color.YELLOW);
		panel1.setLayout(new GridLayout(2, 1));
		panel1.add(button);
		button.setBackground(Color.GREEN);
		panel1.add(buttonPressResult);
		frame.add(panel2, BorderLayout.SOUTH);
		panel2.setLayout(new GridLayout(3, 1));
		panel2.add(buttonMinus);
		buttonMinus.setBackground(Color.ORANGE);
		panel2.add(textField);
		panel2.add(buttonPlus);
		buttonPlus.setBackground(Color.RED);
		frame.addWindowListener(this);
		frame.setSize(500, 400);
		frame.setVisible(true);

	}

	public void windowClosing(WindowEvent e) { // close the frame/window
		frame.dispose();
	}

	public static void main(String[] args) {
		UserRandomAction useR = new UserRandomAction();
		useR.launchFrame();
	}

	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			panel1.setBackground(
					new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
			buttonPressResult.setBackground(
					new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
		}

	}

	class IncActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textField.setText("" + ++counter);
		}
	}

	class DecActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textField.setText("" + --counter);
		}
	}

}
