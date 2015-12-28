package fab.formatic.web.dto.inheritance;

import javax.xml.bind.annotation.XmlRootElement;

import fab.formatic.web.dto.Number;

@XmlRootElement
public class StringNumber extends Number {
	
	private String stringNumber;
	
	public StringNumber(String stringNumber) {
		this.stringNumber=stringNumber;
	}

	public String getStringNumber() {
		return stringNumber;
	}

	public void setStringNumber(String stringNumber) {
		this.stringNumber = stringNumber;
	}

	
}
