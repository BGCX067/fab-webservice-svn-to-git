package fab.formatic.web.dto.inheritance;

import javax.xml.bind.annotation.XmlRootElement;

import fab.formatic.web.dto.Number;

@XmlRootElement
public class DoubleNumber extends Number {
	
	private double doubleNumber;
	
	public DoubleNumber(double doubleNumber) {
		this.doubleNumber=doubleNumber;
	}

	public double getDoubleNumber() {
		return doubleNumber;
	}

	public void setDoubleNumber(double doubleNumber) {
		this.doubleNumber = doubleNumber;
	}
	
	

}
