package login;

import login.from.LoginDao;
import login.from.LoginEJB;

public class LoginServiceImpl implements LoginService {

	@Override
	public ResultLogin login(String user, String pass) {
		
		LoginDao login = new LoginEJB(); 
		
		boolean verifyUser = login.verifyUser(user, pass);
		String message = null;
		if(verifyUser){
			message = "User or password invalid";
		}
		
		return new ResultLogin(verifyUser, message);
	}

}
