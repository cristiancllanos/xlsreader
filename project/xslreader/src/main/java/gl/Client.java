package gl;

/**
 * 
 * Bean ejemplo para mapear un xls con un objeto.
 * 
 * @author Cristian Ceferino Llanos <cristian.llanos@globallogic.com>
 *
 */
public class Client {

	private String name;
	private String lastname;
	private String dni;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
