package fab.formatic.backend.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

public abstract class FabXMLGregorianCalendar extends XMLGregorianCalendar {
	
	private GregorianCalendar calendar;
	
	public FabXMLGregorianCalendar(GregorianCalendar calendar) {
		this.calendar=calendar;
	}
	
	@Override
	public void add(Duration arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compare(XMLGregorianCalendar arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDay() {
		return calendar.get(GregorianCalendar.DATE);
	}

	@Override
	public BigInteger getEon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigInteger getEonAndYear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getFractionalSecond() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHour() {
		return calendar.get(GregorianCalendar.HOUR);
	}

	@Override
	public int getMinute() {
		return calendar.get(GregorianCalendar.MINUTE);
	}

	@Override
	public int getMonth() {
		return calendar.get(GregorianCalendar.MONTH);
	}

	@Override
	public int getSecond() {
		return calendar.get(GregorianCalendar.SECOND);
	}

	@Override
	public TimeZone getTimeZone(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTimezone() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public QName getXMLSchemaType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getYear() {
		return calendar.get(GregorianCalendar.YEAR);
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public XMLGregorianCalendar normalize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDay(int arg0) {
		calendar.set(GregorianCalendar.DAY_OF_MONTH, arg0);
	}

	@Override
	public void setFractionalSecond(BigDecimal arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHour(int arg0) {
		calendar.set(GregorianCalendar.HOUR, arg0);

	}

	@Override
	public void setMillisecond(int arg0) {
		calendar.set(GregorianCalendar.MILLISECOND, arg0);

	}

	@Override
	public void setMinute(int arg0) {
		calendar.set(GregorianCalendar.MINUTE, arg0);

	}

	@Override
	public void setMonth(int arg0) {
		calendar.set(GregorianCalendar.MONTH, arg0);
	}

	@Override
	public void setSecond(int arg0) {
		calendar.set(GregorianCalendar.SECOND, arg0);

	}

	@Override
	public void setTimezone(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setYear(BigInteger arg0) {
		//calendar.set(GregorianCalendar.YEAR, (Integer)arg0);

	}

	@Override
	public void setYear(int arg0) {
		calendar.set(GregorianCalendar.YEAR, arg0);

	}

	@Override
	public GregorianCalendar toGregorianCalendar() {
		return calendar;
	}

	@Override
	public GregorianCalendar toGregorianCalendar(TimeZone arg0, Locale arg1,
			XMLGregorianCalendar arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toXMLFormat() {
		// TODO Auto-generated method stub
		return null;
	}

}
