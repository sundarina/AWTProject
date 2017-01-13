import java.awt.*;

/** Этот класс упрощает применение класса GridBagConstraints
  */

public class GBC extends GridBagConstraints {
	/** Строит обьект GBS, накладывая ограничения с помощью параметров gridx, gridy , 
	 * а все остальные огрничения накладываються 
	 * на сеточно-контейнерную компоновку по умолчанию 
	 * @param gridx местоположение сетки по горизонтали
	 * @param gridy  местоположение сетки по вертикали
	 * */
	
	public GBC(int gridx, int gridy) {
		this.gridx = gridx;
		this.gridy = gridy;
	}
	
	/** Строит обьект GBS, накладывая ограничения с помощью параметров gridx, gridy, gridwidth, gridheight 
	 * а все остальные огрничения накладываються 
	 * на сеточно-контейнерную компоновку по умолчанию 
	 * @param gridx местоположение сетки по горизонтали
	 * @param gridy  местоположение сетки по вертикали
	 * @param шаг сетки по горизонтали
	 * @param шаг сетки по вертикали
	 * 
	 * */

	public GBC(int gridx, int gridy, int gridwidth, int gridheight) {
		this.gridx = gridx;
		this.gridy = gridy;
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
	}
	
	/** Устанавливает привязку к сетке
	 * @param anchor Степень привязки
	 * @return this обьект для следующего изменения
	 * */
	
	public GBC setAnchor(int anchor) {
		this.anchor = anchor;
		return this;
	}
	
	/** Устанавливает направляние для заполнения
	 * @param fill Направление заполнения
	 * @return this обьект для следующего изменения
	 * */
	
	public GBC setFill(int fill) {
		this.fill = fill;
		return this;
	}
	
	/** Устанавливает веса ячеек
	 * @param weightx вес ячейки по горизонтали
	 * @param weighty вес ячейки по вертикали
	 * @return this обьект для следующего изменения
	 * */
	
	public GBC setWeight(double weightx, double weighty) {
		this.weightx = weightx;
		this.weighty = weighty;
		return this;
	}

	/** Вводит пробелы вокруг даннной ячейки
	 * @param distance пробел по всем направлениям
	 * @return this обьект для следующего изменения
	 * */
	
	public GBC setInsets(int distance) {
		this.insets = new Insets(distance, distance, distance, distance);
		return this;
	}
	
	/** Устанавливает внутреннее заполнение
	 * @param ipadx внутреннее заполнение по горизонтали
	 * @param ipady внутренние заполнение по вертикали
	 * @return this 
	 * */
	
	public GBC setIpad(int ipadx, int ipady){
		this.ipadx = ipadx;
		this.ipady = ipady;
		return this;
	}
}

