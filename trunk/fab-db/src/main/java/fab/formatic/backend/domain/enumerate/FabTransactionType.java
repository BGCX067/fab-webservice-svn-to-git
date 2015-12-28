package fab.formatic.backend.domain.enumerate;



public enum FabTransactionType {
	
	ACTIVATION(1),
	RESUMPTION(2),
	SUSPENSION(3),
	TERMINATION(4), UNKNOWN(5);
	
	private Integer value;
	
	public static final String ENUM_CLASS_NAME=FabTransactionType.class.getCanonicalName();
	
	private FabTransactionType(Integer value) {
		this.value=value;
	}
	
	public Integer getValue() {
		return value;
	}

	public static FabTransactionType fromInteger(Integer value){
		switch(value)
		{
		case 1:
			return ACTIVATION;
		case 2:
			return SUSPENSION;
		case 3:
			return RESUMPTION;
		case 4:
			return TERMINATION;
			default:
				return UNKNOWN;
		}
	}
	
	public int toIntValue()
	{
		switch(this)
		{
		case ACTIVATION:
			return 1;
		case SUSPENSION:
			return 2;
		case TERMINATION:
			return 3;
			default:
				return 0;
		}
	}
	
	public String toString()
	{
		switch(this){
		case ACTIVATION:
			return "ACTIVATION";
		case RESUMPTION:
			return "RESUMPTION";
		case SUSPENSION:
			return "SUSPENSION";
		case TERMINATION:
			return "TERMINATION";
		default:
			return "UNKNOWN";
		}
	}
	
	public FabTransactionType fromString(String transType){
		if(transType.equals("ACTIVATION")){
			return FabTransactionType.ACTIVATION;
		}else if(transType.equals("RESUMPTION")){
			return FabTransactionType.RESUMPTION;
		}else if(transType.equals("SUSPENSION")){
			return FabTransactionType.SUSPENSION;
		}else if(transType.equals("TERMINATION")){
			return FabTransactionType.TERMINATION;
		}else{
			return FabTransactionType.UNKNOWN;
		}
		
	}

}
