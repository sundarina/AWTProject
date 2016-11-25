import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;;

public class PaintCircle extends WindowAdapter implements ActionListener {

	Frame frame;
	Button button;
	Panel panel, panel2;
	int x;
	int y;
	int radius;
	
	TextField xField, yField, radiusField;
	
	public PaintCircle() {
		panel2 = new Panel(){
			
			public void paint(Graphics g) {
				 
				 g.setColor(new Color((int)(Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
				 g.fillOval(x-radius, y-radius, 2*radius, 2*radius);
				 
			}
		};
		
		panel = new Panel();
		
		
		
		xField = new TextField(10);
		xField.setText("0");
		yField = new TextField(10);
		yField.setText("0");
		radiusField =  new TextField(10);
		radiusField.setText("0");
		
		x = (Integer.parseInt(xField.getText()));
		y = (Integer.parseInt(yField.getText()));
		radius = (Integer.parseInt(radiusField.getText()));
		
		button = new Button("OK");
		frame =  new Frame();
		frame.add(panel2, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		panel.add(xField);
		panel.add(yField);
		panel.add(radiusField);
		panel.add(button);
		frame.setSize(400, 300);
		frame.addWindowListener(this);
		frame.setVisible(true);
		button.addActionListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button){
			x = (Integer.parseInt(xField.getText()));
			y = (Integer.parseInt(yField.getText()));
			radius = (Integer.parseInt(radiusField.getText()));
			panel2.repaint();
		}
	}
		
	public void windowClosing(WindowEvent e) { // close the frame/window
		frame.dispose();
	}

	public static void main(String[] args) {
		PaintCircle pc = new PaintCircle();
	}

}
