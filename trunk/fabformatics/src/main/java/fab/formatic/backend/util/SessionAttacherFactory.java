package fab.formatic.backend.util;

/**
 * @author gilang
 *
 */
public class SessionAttacherFactory {
	
	public static String attachSession(String[] value){
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<value.length;i++)
		{
			builder.append(value[i]);
		}
		return builder.toString();
	}

}
