package gl.entities;

/**
 * Cliente
 *
 * Entity class.
 *
 * @author Cristian Ceferino Llanos <cristian.llanos@globallogic.com>
 */
public class Cliente {

	private String nombre;
	private String apellido;
	private String dni;
	private String direccion;

	public Cliente(){
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
