package login;

import login.from.LoginDao;
import login.from.LoginDaoFactory;

public class LoginServiceImpl implements LoginService {

	@Override
	public ResultLogin login(String user, String pass) {
		
		LoginDao login = LoginDaoFactory.getInstance(); 
		
		boolean verifyUser = login.verifyUser(user, pass);
		String message = null;
		if(!verifyUser){
			message = "User or password invalid";
		}else{
			//code
			//load session
			//register event
			//define promotions
		}
		
		return new ResultLogin(verifyUser, message);
	}

}
