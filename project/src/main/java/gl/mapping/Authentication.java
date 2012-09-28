package gl.mapping;

public class Authentication {

	private String gmailuser;
	private String gmailpass;

	public Authentication(String gmailuser, String gmailpass) {
		super();
		this.gmailuser = gmailuser;
		this.gmailpass = gmailpass;
	}

	public String getGmailuser() {
		return gmailuser;
	}

	public void setGmailuser(String gmailuser) {
		this.gmailuser = gmailuser;
	}

	public String getGmailpass() {
		return gmailpass;
	}

	public void setGmailpass(String gmailpass) {
		this.gmailpass = gmailpass;
	}

}
