import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class FleeingButton extends WindowAdapter implements ActionListener, MouseMotionListener {

	private Frame frame;
	private JButton button;


	private Dialog dialog;
	private Label label;
	private JButton dialogButton;

	public FleeingButton() {

		frame = new Frame("Fleeng button");
		button = new JButton("Press me!");
		button.setFocusPainted(false);

		dialog = new Dialog(frame, "Massage", true);
		label = new Label();
		dialogButton = new JButton("Ok");

		frame.add(button);
		frame.setLayout(null);

		button.setBackground(
				new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
		button.setSize(button.getPreferredSize());
		button.setLocation(150, 150);
		button.addActionListener(this);

		frame.addMouseMotionListener(this);
		frame.addWindowListener(this);

		frame.setSize(600, 400);
		frame.setLocation(300, 200);
		frame.setBackground(
				new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
		frame.setVisible(true);

		dialog.setLayout(new FlowLayout());
		dialog.add(label);
		dialog.add(dialogButton);
		dialogButton.setBackground(
				new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
		dialogButton.addActionListener(this);

	}

	int Rad;

	// Функция анализирующая положение кнопки и мыши и действие

	protected void MoveGetdirection(int x_position, int y_position)// функция
																	// анализирует
																	// близость
																	// мышки к
																	// нопке
	{

		Rad = (int) (this.button.getWidth() * 1.2); // радиус окружности в
													// которой находится
													// кнопка
		int x_centerbutton = this.button.getLocation().x + (this.button.getWidth() / 2);// Абсцисса
		// середины
		// кнопки
		int y_centerbutton = this.button.getLocation().y + (this.button.getHeight() / 2);// Ордината
		// середины
		// кнопки

		int rast = (int) (2
				* Math.sqrt(Math.pow(x_position - x_centerbutton, 2) + Math.pow(y_position - y_centerbutton, 2)));
		if (rast < Rad) {
			int dx = Rad - rast;// приращение по икс
			int dy = Rad - rast;// приращение по игрек

			// меняем на обратное если вверх и влево
			if (x_position > x_centerbutton) {
				dx = -dx;
			}
			if (y_position > y_centerbutton) {
				dy = -dy;
			}
			this.MoveDButton(dx, dy, x_centerbutton, y_centerbutton);// Далее
																		// двигаем
																		// кнопку,
																		// проверяя
																		// есть
																		// место
																		// для
																		// перемещения
		}
	}

	// Метод анализирующий свободное расстояние для перемещения

	int bonus = 20;

	protected void MoveDButton(int dx, int dy, int x_centerbutton, int y_centerbutton) {
		// если двигать вправо
		if (dx > 0) {// если справа есть место
			if (x_centerbutton + this.button.getWidth() / 2 + dx < this.frame.getWidth()) {
				this.button.setLocation(this.button.getLocation().x += dx, this.button.getLocation().y);// Двигаем
			} else {
				this.button.setLocation(bonus, this.button.getLocation().y); 
			}
		}
		// если двигать вниз
		if (dy > 0) {// если внизу есть место
			if (y_centerbutton + this.button.getHeight() / 2 + dy < this.frame.getHeight()) {
				this.button.setLocation(this.button.getLocation().x, this.button.getLocation().y += dy);// Двигаем
			} else {
				this.button.setLocation(this.button.getLocation().x, bonus);
			}
		}
		// если двигать влево
		if (dx < 0) {// если слева есть место
			if (x_centerbutton - this.button.getWidth() / 2 > -dx) {
				this.button.setLocation(this.button.getLocation().x += dx, this.button.getLocation().y);// Двигаем
			} else {
				this.button.setLocation(this.frame.getWidth() - (this.button.getWidth() + bonus),
						this.button.getLocation().y);
			}
		}
		// если двигать вверх
		if (dy < 0) {// если вверху есть место
			if (y_centerbutton - (this.button.getHeight() / 2) > -dy) {
				this.button.setLocation(this.button.getLocation().x, this.button.getLocation().y += dy);// Двигаем
			} else {
				this.button.setLocation(this.button.getLocation().x,
						this.frame.getHeight() - (this.button.getHeight() + bonus));
			}
		}
	}

	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {

		if (e.getModifiers() == 16)
			this.MoveGetdirection(e.getX(), e.getY());

	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {

		this.MoveGetdirection(e.getX(), e.getY());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button) {

			label.setText("Winning!!!");
			dialog.setSize(150, 90);
			dialog.setBackground(
					new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
			dialog.setResizable(false);
			dialog.setVisible(true);

		} else {
			if (e.getSource() == dialogButton) {
				dialog.setVisible(false);
			}
		}
	}

	public void windowClosing(WindowEvent e) { // close the frame/window
		frame.dispose();
	}

	public static void main(String[] args) {
		new FleeingButton();

	}
}
