package login;

public class ResultLogin {

	private Boolean login;

	private String message;

	public ResultLogin(boolean verifyUser, String message) {
		this.login = verifyUser;
		this.message = message;
	}

	public Boolean getLogin() {
		return login;
	}

	public void setLogin(Boolean login) {
		this.login = login;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
