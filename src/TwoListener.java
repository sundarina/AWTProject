import java.awt.*;
import java.awt.event.*;

public class TwoListener implements MouseMotionListener, MouseListener, WindowListener {
		private Frame f;
	    private TextField tf;

	    public TwoListener() {
	        f = new Frame("Two listeners example");
	        tf = new TextField(30);
	    }

	    public void launchFrame() {
	        Label label = new Label("Click and drag the mouse");
	        f.add(label, BorderLayout.NORTH);
	        f.add(tf, BorderLayout.SOUTH);
	        f.addMouseMotionListener(this);
	        f.addMouseListener(this);
	        f.addWindowListener(this); //связь
	        f.setSize(300, 200);
	        f.setVisible(true);
	    }
	    public void mouseDragged(MouseEvent e) {
	        String s = "Mouse dragging: X = " + e.getX() + " Y = " + e.getY();
	        tf.setText(s);
	    }

	    public void mouseEntered(MouseEvent e) {
	        String s = "The mouse entered";
	        tf.setText(s);
	    }

	    public void mouseExited(MouseEvent e) {
	        String s = "The mouse has left the building";
	        tf.setText(s);
	    }
	    public void mouseMoved(MouseEvent e) {    
	    }
	    
	    public void mousePressed(MouseEvent e) {    
	    }

	    public void mouseClicked(MouseEvent e) {    
	    }

	    public void mouseReleased(MouseEvent e) {    
	    }

		public void windowActivated(WindowEvent e) {
		}

		public void windowClosed(WindowEvent e) {
		}

		public void windowClosing(WindowEvent e) { //close the frame/window
			f.dispose();
			// System.exit(0);
		}

		public void windowDeactivated(WindowEvent e) {
		}

		public void windowDeiconified(WindowEvent e) {	
		}

		public void windowIconified(WindowEvent e) {		
		}

		public void windowOpened(WindowEvent e) {	
		}


	    public static void main(String args[]) {
	        TwoListener two = new TwoListener();
	        two.launchFrame();
	    }
}	