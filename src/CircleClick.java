
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;;

public class CircleClick extends WindowAdapter implements ActionListener, MouseListener {
	Frame frame;
	Panel panel, panel2;
	int x;
	int y;
	int radius;
	TextField radiusField;
	Button buttonGo;
	Button buttonStop;

	int mas[][] = new int[6][3];
	int counter = 0;

	public CircleClick() {
		panel2 = new Panel() {
			public void paint(Graphics g) {

				for (int i = 0; i < mas.length; i++) {

					g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
							(int) (Math.random() * 255)));
					g.fillOval(mas[i][0] - mas[i][2], mas[i][1] - mas[i][2], 2 * mas[i][2], 2 * mas[i][2]);
					if (counter == 6) {
						counter = 0;
					}
				}
			}
		};

		panel = new Panel();

		buttonGo = new Button("Gooooo!");
		buttonStop = new Button("Stop");

		radiusField = new TextField(10);
		radiusField.setText("0");

		radius = (Integer.parseInt(radiusField.getText()));

		frame = new Frame();
		frame.add(panel2, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		panel.add(radiusField);
		panel.add(buttonGo);
		panel.add(buttonStop);
		frame.setSize(400, 300);
		frame.addWindowListener(this);
		frame.setVisible(true);
		panel2.addMouseListener(this);
		buttonGo.addActionListener(this);
		buttonStop.addActionListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		mas[counter][0] = e.getX();
		mas[counter][1] = e.getY();
		mas[counter][2] = (Integer.parseInt(radiusField.getText()));
		counter++;
		panel2.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == buttonGo) {
			for (int i = 0; ; i++) {
				
					mas[counter][0] = (int) (Math.random() * 400);
					mas[counter][1] = (int) (Math.random() * 300);
					mas[counter][2] = (Integer.parseInt(radiusField.getText()));
					counter++;
					panel2.update(panel2.getGraphics());
				
			}
		}
	}

	public void windowClosing(WindowEvent e) { // close the frame/window
		frame.dispose();
	}

	public static void main(String[] args) {
		CircleClick pc = new CircleClick();
	}
}
