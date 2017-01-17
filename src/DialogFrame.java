import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


//фрейм со строкой меню. File => About 

public class DialogFrame extends JFrame {
	
	public static final int DEFAULT_WIGTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	private AboutDialog dialog;
	
	
	
	public DialogFrame(){
		setSize(DEFAULT_WIGTH, DEFAULT_HEIGHT);
		
		//сконструировать меню Файл
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		//ввести в меню пункты About и Exid
		
		//при выборе About меню открывается Диалоговое окно
		
		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
			
				if (dialog == null) { //первый раз
					dialog = new AboutDialog(DialogFrame.this);
					dialog.setVisible(true);
				}
			}
		});
		
		fileMenu.add(aboutItem);
		
		// при выборе Exid - выход из программы
		
		JMenuItem exidItem = new JMenuItem("Exid");
		exidItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		fileMenu.add(exidItem);
		setVisible(true);
	}



	public static void main(String[] args) {
	
		DialogFrame d = new DialogFrame();

	}

}
