import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator extends WindowAdapter implements ActionListener, Runnable {

	Dialog dialog;
	Label label;
	Frame frame;
	Panel p, pSpecial;
	Button dialogButton, b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bDot, bMyltiply, bMinus, bPlus, bDivided, bEqually,
			bSqrt, bX, bPercent, bC, bCE, bBack, bPlMin;
	TextField tf;
	double d1, d2, d3;
	boolean frac = false;
	char op;
	boolean opc = false, ope = false;

	@Override
	public void run() {  // для чередования заголовка окна
		while (true) {
			char ch = frame.getTitle().charAt(0);
			frame.setTitle(frame.getTitle().substring(1, frame.getTitle().length()) + Character.toString(ch));
			try {
				Thread.sleep(200); //ожидание
			} catch (InterruptedException ie) {
				System.out.println(ie.getMessage());
			}
		}

	}

	public Calculator(String str) {

		dialog = new Dialog(frame, "Massage", true);
		label = new Label();
		dialogButton = new Button("Ok");
		dialog.setLayout(new FlowLayout());
		dialog.add(label);
		dialog.add(dialogButton);
		dialogButton.addActionListener(this);

		tf = new TextField(20);
		tf.setEditable(false); //запрет ввода текста в поле
		tf.setFont(new Font("Dialog",Font.BOLD,12));	
		tf.setText("0");
		
		b1 = new Button("1");
		b1.addActionListener(this);
		b1.setBackground(new Color(67, 205, 128));
		b2 = new Button("2");
		b2.addActionListener(this);
		b2.setBackground(new Color(124, 205, 124));
		b3 = new Button("3");
		b3.addActionListener(this);
		b3.setBackground(new Color(0, 205, 102));
		b4 = new Button("4");
		b4.addActionListener(this);
		b4.setBackground(new Color(78, 238, 148));
		b5 = new Button("5");
		b5.addActionListener(this);
		b5.setBackground(new Color(144, 238, 144));
		b6 = new Button("6");
		b6.addActionListener(this);
		b6.setBackground(new Color(0, 238, 118));
		b7 = new Button("7");
		b7.addActionListener(this);
		b7.setBackground(new Color(84, 255, 159));
		b8 = new Button("8");
		b8.addActionListener(this);
		b8.setBackground(new Color(154, 255, 154));
		b9 = new Button("9");
		b9.addActionListener(this);
		b9.setBackground(new Color(0, 255, 127));
		b0 = new Button("0");
		b0.addActionListener(this);
		b0.setBackground(new Color(84, 139, 84));
		bDot = new Button(".");
		bDot.addActionListener(this);
		bDot.setBackground(new Color(46, 139, 87));
		bMinus = new Button("-");
		bMinus.addActionListener(this);
		bMinus.setBackground(new Color(0, 205, 0));
		bPlus = new Button("+");
		bPlus.addActionListener(this);
		bPlus.setBackground(new Color(0, 139, 69));
		bDivided = new Button("/");
		bDivided.addActionListener(this);
		bDivided.setBackground(new Color(0, 255, 0));
		bMyltiply = new Button("*");
		bMyltiply.addActionListener(this);
		bMyltiply.setBackground(new Color(0, 238, 0));
		bEqually = new Button("=");
		bEqually.addActionListener(this);
		bEqually.setBackground(new Color(69, 139, 0));
		bSqrt = new Button("√");
		bSqrt.addActionListener(this);
		bSqrt.setBackground(new Color(118, 238, 0));
		bX = new Button("1/x");
		bX.addActionListener(this);
		bX.setBackground(new Color(102, 205, 0));
		bPercent = new Button("%");
		bPercent.addActionListener(this);
		bPercent.setBackground(new Color(127, 255, 0));
		bPlMin = new Button("+/-");
		bPlMin.addActionListener(this);
		bPlMin.setBackground(new Color(0, 139, 0));
		bC = new Button("C");
		bC.setBackground(new Color(154, 205, 50 ));
		bC.addActionListener(this);
		bCE = new Button("CE");
		bCE.addActionListener(this);
		bCE.setBackground(new Color(179, 238, 58));
		bBack = new Button("Back");
		bBack.addActionListener(this);
		bBack.setBackground(new Color(179, 238, 58));


		frame = new Frame("Culculator ");
		frame.add(tf, BorderLayout.NORTH);

		pSpecial = new Panel();
		pSpecial.setLayout(new FlowLayout());
		pSpecial.add(bBack);
		pSpecial.add(bCE);
		pSpecial.add(bC);
		frame.add(pSpecial, BorderLayout.SOUTH);
		
		p = new Panel();
		p.setLayout(new GridLayout(4, 5));
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(bDivided);
		p.add(bPercent);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(bMyltiply);
		p.add(bSqrt);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(bMinus);
		p.add(bX);
		p.add(bDot);
		p.add(b0);
		p.add(bPlus);
		p.add(bPlMin);
		p.add(bEqually);
		
		frame.add(p, BorderLayout.CENTER);
		frame.addWindowListener(this);
		frame.setSize(300, 250);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String s = tf.getText();
		String str;
		if (!frac)
			str = s.substring(0, s.length() - 1);
		else
			str = s;
		
		if (e.getSource() == bBack) {
			if (frac) {
				if (str.charAt(str.length() - 1) == '.')
					frac = false;
				else
					tf.setText(str.substring(0, str.length() - 1));
			} else {
				if (!str.equals("0"))
					tf.setText(str.substring(0, str.length() - 1) + ".");
			}
			if (tf.getText().equals("."))
				tf.setText("0.");
			
		} else if (e.getSource() == bCE) {
			tf.setText("0.");
			frac = false;
			opc = false;
			
		} else if (e.getSource() == bC) {
			tf.setText("0.");
			d1 = 0;
			d2 = 0;
			frac = false;
			opc = false;
			ope = false;
			
		} else if (e.getSource() == bPlus) {
			if (ope) {
				d2 = Double.parseDouble(str);
				d3 = calc(d1, d2, op);
				String dn = Double.toString(d3);
				if (dn.charAt(dn.length() - 1) == '0')
					dn = dn.substring(0, dn.length() - 1);
				tf.setText(dn);
				ope = false;
				str = dn;
			}
			d1 = Double.parseDouble(str);
			opc = true;
			op = '+';
			
		} else if (e.getSource() == bMinus) {
			if (ope) {
				d2 = Double.parseDouble(str);
				d3 = calc(d1, d2, op);
				String dn = Double.toString(d3);
				if (dn.charAt(dn.length() - 1) == '0')
					dn = dn.substring(0, dn.length() - 1);
				tf.setText(dn);
				ope = false;
				str = dn;
			}
			d1 = Double.parseDouble(str);
			opc = true;
			op = '-';
			
		} else if (e.getSource() == bMyltiply) {
			if (ope) {
				d2 = Double.parseDouble(str);
				d3 = calc(d1, d2, op);
				String dn = Double.toString(d3);
				if (dn.charAt(dn.length() - 1) == '0')
					dn = dn.substring(0, dn.length() - 1);
				tf.setText(dn);
				ope = false;
				str = dn;
			}
			d1 = Double.parseDouble(str);
			opc = true;
			op = '*';
			
		} else if (e.getSource() == bDivided) {
			if (ope) {
				d2 = Double.parseDouble(str);
				d3 = calc(d1, d2, op);
				String dn = Double.toString(d3);
				if (dn.charAt(dn.length() - 1) == '0')
					dn = dn.substring(0, dn.length() - 1);
				tf.setText(dn);
				ope = false;
				str = dn;
			}
			d1 = Double.parseDouble(str);
			opc = true;
			op = '/';
			
		} else if (e.getSource() == bDot) {
			frac = true;
			
		} else if (e.getSource() == bEqually) {
			if (ope) {
				d2 = Double.parseDouble(str);
				d3 = calc(d1, d2, op);
				String dn = Double.toString(d3);
				if (dn.charAt(dn.length() - 1) == '0')
					dn = dn.substring(0, dn.length() - 1);
				tf.setText(dn);
				d1 = d3;
				opc = false;
				ope = false;
			}
			
		} else if (e.getSource() == bPercent) {
			if (ope) {
				double temp = Double.parseDouble(tf.getText());
				String tmp = Double.toString(d1 * temp / 100);
				if (tmp.charAt(tmp.length() - 1) == '0')
					tmp = tmp.substring(0, tmp.length() - 1);
				tf.setText(tmp);
			} else
				tf.setText("0.");
			
		} else if (e.getSource() == bSqrt) {
			double temp = Double.parseDouble(tf.getText());
			String tmp = Double.toString(Math.sqrt(temp));
			if (tmp.charAt(tmp.length() - 1) == '0')
				tmp = tmp.substring(0, tmp.length() - 1);
			tf.setText(tmp);
			
		} else if (e.getSource() == bX) {
			double temp = Double.parseDouble(tf.getText());
			String tmp = Double.toString(1 / temp);
			if (tmp.equals("Infinity")) {
				label.setText("Cannot divided by zero");
				dialog.setSize(150, 90);
				dialog.setResizable(false);
				dialog.setVisible(true);
			} else {
				if (tmp.charAt(tmp.length() - 1) == '0')
					tmp = tmp.substring(0, tmp.length() - 1);
				tf.setText(tmp);
			}

		} else if (e.getSource() == bPlMin) {
			double temp = Double.parseDouble(tf.getText());
			if (temp != 0) {
				String tmp = Double.toString(-1 * temp);
				if (tmp.charAt(tmp.length() - 1) == '0')
					tmp = tmp.substring(0, tmp.length() - 1);
				tf.setText(tmp);
			} else
				tf.setText("0.");

		} else if (e.getSource() == dialogButton) {
			dialog.setVisible(false);
			
		} else {
			if (opc) {
				tf.setText("0.");
				frac = false;
				str = "0";
				ope = true;
				opc = false;
			}
			if (frac)
				tf.setText(str + e.getActionCommand());
			else {
				if (str.equals("0")) {
					tf.setText("");
					tf.setText(e.getActionCommand() + ".");
				} else
					tf.setText(str + e.getActionCommand() + ".");
			}
		}
	}

	public double calc(double a, double b, char ch) {
		double c = 0;
		switch (ch) {
		case '+':
			c = a + b;
			break;
		case '-':
			c = a - b;
			break;
		case '*':
			c = a * b;
			break;
		case '/':
			c = a / b;
			break;
		}
		return c;
	}

	public void windowClosing(WindowEvent e) {
		frame.dispose();
	}

	public static void main(String args[]) {
		Calculator c = new Calculator("Calculator ");
		Thread t = new Thread(c); //запуск потока для чередования заголовка окна
		t.start();
	}

}
