package fab.formatic.backend.domain.enumerate;


public enum FabTypeCharging {
	
	EXPIRATION(1),
	QUOTA(2);
	
	private Integer value;
	
	public static final String ENUM_CLASS_NAME=FabTypeCharging.class.getCanonicalName();
	
	private FabTypeCharging(Integer value) {
		this.value=value;
	}
	
	public static FabTypeCharging fromInteger(Integer value){
		switch(value){
		case 1:
			return EXPIRATION;
		case 2:
			return QUOTA;
		default:
			return null;
		}
	}
	
	public int toIntValue()
	{
		switch(this)
		{
		case EXPIRATION:
			return 1;
		case QUOTA:
			return 2;
			default:
				return 0;
		}
	}
	
	public String toString()
	{
		switch(this){
		case EXPIRATION:
			return "EXPIRATION";
		case QUOTA:
			return "QUOTA";
		default:
			return "";
		}
	}

	public Integer getValue() {
		return value;
	}
	
	

}
