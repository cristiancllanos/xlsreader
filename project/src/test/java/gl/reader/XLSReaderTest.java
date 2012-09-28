package gl.reader;

import gl.entities.Cliente;
import gl.mapping.Authentication;
import gl.mapping.AuthenticationUtils;
import junit.framework.TestCase;

public abstract class XLSReaderTest extends TestCase {

	protected final String key = "0Ap9dpq9vAeVtdEZZc0lyNV9fQk5kVlpyaFI3dXM4Mnc";
	protected Class<Cliente> bean = Cliente.class;
	protected Authentication auth = AuthenticationUtils.getAuthentication();

	protected final String[][] customersValid = {
			{ "Juan", "Fernandez", "30565890", "Alen 418 GC" },
			{ "Carlos", "Martinez", "27599890", "San Martin Guaymallen" },
			{ "Pedro", "Lainez", "27565890", "Benegas 23 San Martin" },
			{ "Luciana", "Toleo", "26565888", "San Lorenzo 589 Maipu" },
			{ "Marcelo", "Salmeron", "27565890", "Martinez de Rosa 56 Capital" },
			{ "Martin", "Caleri", "31565875", "J. Moldes 589 Capital" },
			{ "Matias", "Moreno", "20595800", "Moron 68 Maipu" },
			{ "Mariana", "Paleo", "25555890", "La Valle 87 Ciudad" },
			{ "Sandra", "Merino", "25667800", "Salta 33 GC" } };

}
