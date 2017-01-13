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
	
	private JComboBox<String> face;
	private JComboBox<Integer> size;
	
	private JCheckBox bold;
	private JCheckBox italic;
	private JTextArea sample;

	public FontFrame() {
		GridBagLayout layout  = new GridBagLayout();
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
		sample.setEnabled(false);
		sample.setLineWrap(true);
		sample.setBorder(BorderFactory.createEtchedBorder());
		
		//ввести компоненты в сетку, использую служебный класс
		
		add(faceLabel, new GBC(0,0).setAnchor(GBC.EAST));
		add(face, new GBC(1, 0).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
		add(sizeLabel, new GBC(0, 1).setAnchor(GBC.EAST));
		add(size, new GBC(1, 1).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
		add(bold, new GBC(0, 2, 2,1).setAnchor(GBC.CENTER).setWeight(100, 100));
		add(italic, new GBC(0, 3, 2,1).setAnchor(GBC.CENTER).setWeight(100, 100));
		add(sample, new GBC(2, 0, 1, 4).setFill(GBC.BOTH).setWeight(100, 100));
		pack();
		setVisible(true);
		updateSample();
	}
	
	public void updateSample() {
		String fontFace = (String)face.getSelectedItem();
		int fontStyle = (bold.isSelected() ? Font.BOLD : 0) + (italic.isSelected() ? Font.ITALIC : 0);
		int fontSize = size.getItemAt(size.getSelectedIndex());
		Font font = new Font(fontFace, fontStyle, fontSize);
		sample.setFont(font);
		sample.repaint();					
	}
	
	public static void main(String[] args) {
		FontFrame f = new FontFrame();
	}

}
