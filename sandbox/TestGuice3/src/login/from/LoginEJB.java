package login.from;

public class LoginEJB implements LoginDao {

	@Override
	public boolean verifyUser(String user, String pass) {
		return true;
	}

}
