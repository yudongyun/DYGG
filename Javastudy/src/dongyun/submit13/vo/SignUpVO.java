package dongyun.submit13.vo;

public class SignUpVO {

	private String Id;
	private String Password;
	
	public SignUpVO() {
		
		
	}

	public SignUpVO(String id, String password) {
		super();
		Id = id;
		Password = password;
	}

	@Override
	public String toString() {
		return "SignUpVO [Id=" + Id + ", Password=" + Password + "]";
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	
	
	
	
	
	
	
	
}
