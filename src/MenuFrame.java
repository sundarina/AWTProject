import java.awt.event.*;
import javax.swing.*;

public class MenuFrame extends JFrame {

	/**
	 * Фрейм с обрацом строки меню
	 */

	private final static int DEFAULT_WIDTH = 300;
	private final static int DEFAULT_HEIGHT = 200;
	private Action saveAction;
	private Action saveAsAction;
	private JCheckBoxMenuItem readonlyItem;
	private JPopupMenu popup;

	/** Обработчик действий, выводящий имя действия в поток System.out */

	class TestAction extends AbstractAction {
		public TestAction(String name) {
			super(name);
		}

		public void actionPerformed(ActionEvent event) {
			System.out.println(getValue(Action.NAME) + " selected.");
		}
	}

	public MenuFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(new TestAction("New"));

		// применение оперативных клавиш

		JMenuItem openItem = fileMenu.add(new TestAction("Open"));
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));

		fileMenu.addSeparator();

		saveAction = new TestAction("Save");
		JMenuItem saveItem = fileMenu.add(saveAction);
		saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

		saveAsAction = new TestAction("Save As");
		fileMenu.add(saveAsAction);
		fileMenu.addSeparator();

		fileMenu.add(new AbstractAction("Exit") {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		// продемонстрировать применение флажков и кнопок-переключателей

		readonlyItem = new JCheckBoxMenuItem("Read-Only");
		readonlyItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				boolean saveOk = !readonlyItem.isSelected();
				saveAction.setEnabled(saveOk);
				saveAsAction.setEnabled(saveOk);

			}
		});

		ButtonGroup group = new ButtonGroup();

		JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert");
		insertItem.setSelected(true);
		JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("Overtype");
		group.add(insertItem);
		group.add(overtypeItem);

		// применение пиктограммы с 411 (415 в книге)

		Action cutAction = new TestAction("Cut");
		Action copyAction = new TestAction("Copy");
		Action pasteAction = new TestAction("Paste");

		JMenu editMenu = new JMenu("Edit");
		// применение вложенных меню

		JMenu optionMenu = new JMenu("Options");
		optionMenu.add(readonlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overtypeItem);

		editMenu.add(optionMenu);

		// клавиши быстрого доступа

		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');

		JMenuItem indexItem = new JMenuItem("Index");
		indexItem.setMnemonic('I');
		helpMenu.add(indexItem);

		// клавиша быстрого доступа, используя обьект действия

		Action aboutAction = new TestAction("About");
		aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
		helpMenu.add(aboutAction);

		// ввести все меню верхнего уровня в строку меню

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

		// вслывающие меню

		popup = new JPopupMenu();
		popup.add(cutAction);
		popup.add(copyAction);
		popup.add(pasteAction);

		JPanel panel = new JPanel();
		panel.setComponentPopupMenu(popup);

		add(panel);
		setVisible(true);
		// чтобы обойти програмную ошибку 4966109

		panel.addMouseListener(new MouseAdapter() {
		});

	}

	public static void main(String[] args) {
		MenuFrame mf = new MenuFrame();
	}

}
