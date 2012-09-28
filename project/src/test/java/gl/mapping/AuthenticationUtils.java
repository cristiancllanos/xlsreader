package gl.mapping;

public class AuthenticationUtils {

	private static Authentication auth;

	public static Authentication getAuthentication() {
		if (auth == null) {
			String username = System.getProperty("username");
			String password = System.getProperty("password");
			auth = new Authentication(username, password);
		}
		return auth;
	}

}
