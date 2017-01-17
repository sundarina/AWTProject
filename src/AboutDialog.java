import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*Образец режимного диалогового окна, открытого до того момента, 
 * пока пользователь не нажмет кнопку Ок*/

public class AboutDialog extends JDialog {
	
	public AboutDialog(JFrame owner) {
		super(owner, "AboutDialog", true); //родитель, надпись, модальное окно
		//метка по центру окна
		add(new Label("Core Java \n By Cay Horstmannand Harry Cornell"), BorderLayout.CENTER);
		
		//при выборе КНОПКИ  Ок окно закрываеться
		
		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		JPanel panel = new JPanel();
		panel.add(ok);
		add(panel, BorderLayout.SOUTH);
		pack();
	}
}