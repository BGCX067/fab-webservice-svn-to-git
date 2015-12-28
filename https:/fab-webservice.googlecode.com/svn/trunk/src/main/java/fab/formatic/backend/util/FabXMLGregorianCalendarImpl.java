package fab.formatic.backend.util;

import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FabXMLGregorianCalendarImpl extends FabXMLGregorianCalendar {
	
	private GregorianCalendar calendar;

	public FabXMLGregorianCalendarImpl(GregorianCalendar calendar) {
		super(calendar);
	}

	public GregorianCalendar getCalendar() {
		return calendar;
	}
	

}
