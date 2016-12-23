import java.awt.*;
import java.net.URL;

import javax.swing.*;
import java.util.*;
import javax.swing.event.*;

/**
 * Фрейм с несколькими ползунками и текстовым полем для показа значений, на
 * которых по очереди устанавливаються ползунки
 */

public class SliderFrame extends JFrame {

	private JPanel sliderPanel;
	private JTextField textField;
	private ChangeListener listener;

	public SliderFrame() {
		sliderPanel = new JPanel();
		sliderPanel.setLayout(new GridLayout(7, 1));

		//общий приемник событий для всех ползунков
		
		listener = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				//обновить текстовое поле , если выбранный ползунок 
				//установился на отметке с другими значением

				JSlider sourse = (JSlider) e.getSource();
				textField.setText("" + sourse.getValue());
			}
		};
		
		//вывести простой ползунок

		JSlider slider = new JSlider();
		addSlider(slider, "Plain");
		
		//ввести ползунок с основными и неосновными отметками
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Ticks");
		
		//ввести позунок , привязываемый к отметкам
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Snap to ticks");
		
		//ползунок без отметок
		
		slider =  new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(false);
		addSlider(slider, "No slider");
		
		// ввести инвертированный ползунок
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setInverted(true);
		addSlider(slider, "Inverted");
		
		//ввести ползунок с цифровыми обозначениями отметок
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Labels");
		
		//с буквенными обозначениями
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		
		Dictionary<Integer, Component> labelTable = new Hashtable<>();
		labelTable.put(0, new JLabel ("A"));
		labelTable.put(20, new JLabel ("B"));
		labelTable.put(40, new JLabel ("C"));
		labelTable.put(60, new JLabel ("D"));
		labelTable.put(80, new JLabel ("E"));
		labelTable.put(100, new JLabel ("F"));
		
		slider.setLabelTable(labelTable);
		addSlider(slider, "Custom labels");
		
		//ползунок с пиктограммами отметок
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		
		
		
		labelTable = new Hashtable<Integer, Component>();
		labelTable.put(0, new JLabel(createImageIcon("1.gif", "1")));
		labelTable.put(20, new JLabel (createImageIcon("2.gif", "2")));
		labelTable.put(40, new JLabel (createImageIcon("3.gif", "3")));
		labelTable.put(60, new JLabel (createImageIcon("4.gif", "4")));
		labelTable.put(80, new JLabel (createImageIcon("5.gif", "5")));
		labelTable.put(100, new JLabel (createImageIcon("6.gif", "6")));

		slider.setLabelTable(labelTable);
		addSlider(slider, "Icon Labels");
		
		//текстовое поле для показана значения, в котором установлен ползунок
		
		textField = new JTextField();
		add(sliderPanel, BorderLayout.CENTER);
		add(textField, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
	}

	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * выводит ползунки на панели и привязывает к ним приемник событий
	 *
	 * @param s
	 * @param description
	 */

	public void addSlider(JSlider s, String description) {
		s.addChangeListener(listener);
		JPanel panel = new JPanel();
		panel.add(s);
		panel.add(new Label(description));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		GridBagConstraints gbs = new GridBagConstraints();
		gbs.gridy = sliderPanel.getComponentCount();
		gbs.anchor = GridBagConstraints.WEST;
		sliderPanel.add(panel, gbs);
	}

	public static void main(String[] args) {
		SliderFrame sliderframe = new SliderFrame();

	}

}
