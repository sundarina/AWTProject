import java.awt.*;
import java.util.Scanner;


public class RectangleGrid {
	private Frame f;
	int amount;
	private Button[] buttons = new Button[amount]; 
	Panel p;

	Color c = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
	
	public RectangleGrid(int amount) {
		this.amount = amount;
		buttons = new Button[amount]; 
		f = new Frame("Grid Example");
		p = new Panel();
	}
	
	public void launchFrame() {

		f.setSize(400, 400);
		p.setSize(300, 300);
		p.setLayout(new GridLayout(amount/2, 2));
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button(i + "");
			p.add(buttons[i]);
			c = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
			buttons[i].setBackground(c);
		}
		f.add(p, BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите число прямоугольников: ");
		int amount = scanner.nextInt();
		scanner.close();
		
		RectangleGrid grid = new RectangleGrid(amount);
		grid.launchFrame();
	}
}
