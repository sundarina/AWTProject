import java.awt.*;
public class LayoutExample {
	private Frame f;
	private Button b1;
	private Button b2;

	public LayoutExample() {
		f = new Frame("GUI example");
		b1 = new Button("Press Me");
		b2 = new Button("Don’t press Me");
	}

	public void launchFrame() {
		f.setLayout(new FlowLayout()); //принимает обьект класса Менеджера размещения
		f.add(b1);
		f.add(b2);
		f.pack(); // утснавливает размер контейнера под размер внутреннего содержимого
		f.setVisible(true);
	}

	public static void main(String args[]) {
		LayoutExample guiWindow = new LayoutExample();
		guiWindow.launchFrame();
	}
}