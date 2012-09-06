package test;

import junit.framework.TestCase;
import login.LoginService;
import login.LoginServiceImpl;
import login.ResultLogin;
import login.from.LoginDao;
import login.from.LoginDaoFactory;

public class LoginServiceTest extends TestCase {

	private String user = "Pepe"; 
	private String pass = "132456";
	
	@Override
	protected void setUp() throws Exception {
		
		/*
		 * Variable global.
		 * Cuidado de setearla y quitarla tearDown.
		 * Si el tearDown falla entorpece las demas pruebas.
		 * Imposibilita pruebas en paralelo.
		 * Para agregar otra dependencia hay que tener cuidado de inicializarla.
		 * A medida que la app crece, crecen las fabricas, y desminulle la productividad.
		 * Crece el nivel de complejidad para el mantenimiento. 
		 */
		LoginDaoFactory.setLoginDao(new LoginDao() {
			@Override
			public boolean verifyUser(String u, String p) {
				return user.equals(u)&&pass.equals(p);
			}
		});
	}
	
	public void test(){
		LoginService loginService = new LoginServiceImpl();
		ResultLogin resultLogin = loginService.login(user, pass);
		assertTrue("Usuario que debiera existir no existe.",resultLogin.getLogin());
	}

	@Override
	protected void tearDown() throws Exception {
		LoginDaoFactory.setLoginDao(null);
	}

	
}
