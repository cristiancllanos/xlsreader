package login.from;

public class LoginDaoFactory {

	private static LoginDao loginDao;

	public static LoginDao getInstance() {

		if (loginDao == null) {
			loginDao = new LoginEJB();
		}

		return loginDao;
	}
	
	public static void setLoginDao(LoginDao loginDao) {
		LoginDaoFactory.loginDao = loginDao;
	}
	
}
