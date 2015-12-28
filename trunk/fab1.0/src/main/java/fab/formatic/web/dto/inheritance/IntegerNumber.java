package fab.formatic.web.dto.inheritance;

import javax.xml.bind.annotation.XmlRootElement;

import fab.formatic.web.dto.Number;

@XmlRootElement
public class IntegerNumber extends Number {
	
	private Integer integerNumber;
	
	public IntegerNumber(Integer integerNumber) {
		this.integerNumber=integerNumber;
	}

	public Integer getIntegerNumber() {
		return integerNumber;
	}

	public void setIntegerNumber(Integer integerNumber) {
		this.integerNumber = integerNumber;
	}
	
	

}
