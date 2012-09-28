package gl.mapping;

public class AuthenticationUtils {

	private static Authentication auth;

	public static Authentication getAuthentication() {
		if (auth == null) {
			String gmailuser = System.getProperty("gmailuser");
			String gmailpass = System.getProperty("gmailpass");
			auth = new Authentication(gmailuser, gmailpass);
		}
		return auth;
	}

}
