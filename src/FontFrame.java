import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.JFrame;

public class FontFrame extends JFrame {
	
	/**Фрейм, в котором сеточно-контейнерная компоновка 
	 * служит для расположения компонентов,
	 * предназначеных для выбора шрифта */
	
	public static final int TEXT_ROWS = 10;
	public static final int TEXT_COLUMNS = 20;
	
	private JComboBox<String> face; //комбинированный список
	private JComboBox<Integer> size;
	
	private JCheckBox bold; //флажки
	private JCheckBox italic;
	private JTextArea sample;

	public FontFrame() {
		GridBagLayout layout  = new GridBagLayout(); //сеточно контейнерная компоновка
		setLayout(layout);
		
		ActionListener listener = EventHandler.create(ActionListener.class, this, "updateSample");
		
		JLabel faceLabel = new JLabel("Face: ");
		face = new JComboBox<>(new String[] {"Serif", "SansSerif", "Monospaced", "Dialog", "DialogInput"});
		
		face.addActionListener(listener);
		
		JLabel sizeLabel = new JLabel("Size: ");
		
		size = new JComboBox<>(new Integer[] {8, 10, 15, 18, 24, 36, 48 });
		size.addActionListener(listener);
		
		bold = new JCheckBox("Bold");
		bold.addActionListener(listener);
		
		italic = new JCheckBox("Italic");
		italic.addActionListener(listener);
		
		sample = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
		sample.setText("Five little monkeys jumping on the bed, one fell off and bamped his head");
		sample.setBackground(Color.BLACK);
		sample.setEnabled(false);
		sample.setLineWrap(true); //включен авто режим переноса
		sample.setBorder(BorderFactory.createEtchedBorder()); //рамка пустая
		
		//ввести компоненты в сетку, использую служебный класс
		
		//добавл компонентов во фрейм
		
		add(faceLabel, new GBC(0,0).setAnchor(GBC.EAST)); //первая ячейка сверху слева (0,0) выровнено внутри ячейки (восток) 
		add(face, new GBC(1, 0).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1)); 
		add(sizeLabel, new GBC(0, 1).setAnchor(GBC.EAST)); //вторая ячейка сверху слева (0,1) выровнено внутри ячейки (восток) 
		add(size, new GBC(1, 1).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
		add(bold, new GBC(0, 2, 2,1).setAnchor(GBC.CENTER).setWeight(100, 100)); //вторая ячейка сверху слева (0,1) выровнено внутри ячейки (восток) 
		add(italic, new GBC(0, 3, 2,1).setAnchor(GBC.CENTER).setWeight(100, 100));//вторая ячейка сверху слева (0,1) выровнено внутри ячейки (восток) 
		add(sample, new GBC(2, 0, 1, 4).setFill(GBC.BOTH).setWeight(100, 100));
		setSize(600, 400);  //размер фрейма
		//pack();
		setVisible(true);
		updateSample(); 
	}
	
	//метод обновления при действиях
	
	public void updateSample() {
		String fontFace = (String)face.getSelectedItem();   //название, которое выбрал позьзователь 
		int fontStyle = (bold.isSelected() ? Font.BOLD : 0) + (italic.isSelected() ? Font.ITALIC : 0); // опр стиль
		int fontSize = size.getItemAt(size.getSelectedIndex()); //размер, выбраный пользователем
		Font font = new Font(fontFace, fontStyle, fontSize); //название шрифта, стиль, размер
		sample.setFont(font);
		sample.repaint();					
	}
	
	public static void main(String[] args) {
		FontFrame f = new FontFrame();
	}

}
