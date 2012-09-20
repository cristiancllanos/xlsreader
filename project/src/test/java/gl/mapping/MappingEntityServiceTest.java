package gl.mapping;

import gl.entities.Cliente;
import gl.mapping.reader.XLSReaderException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

public class MappingEntityServiceTest extends TestCase {

	private final String[][] customersValid = {
			{ "Juan", "Fernandez", "30565890", "Alen 418 GC" },
			{ "Carlos", "Martinez", "27599890", "San Martin Guaymallen" },
			{ "Pedro", "Lainez", "27565890", "Benegas 23 San Martin" },
			{ "Luciana", "Toleo", "26565888", "San Lorenzo 589 Maipu" },
			{ "Marcelo", "Salmeron", "27565890", "Martinez de Rosa 56 Capital" },
			{ "Martin", "Caleri", "31565875", "J. Moldes 589 Capital" },
			{ "Matias", "Moreno", "20595800", "Moron 68 Maipu" },
			{ "Mariana", "Paleo", "25555890", "La Valle 87 Ciudad" },
			{ "Sandra", "Merino", "25667800", "Salta 33 GC" } };

	public void test() throws XLSReaderException {

		final String key = "0Ap9dpq9vAeVtdEZZc0lyNV9fQk5kVlpyaFI3dXM4Mnc";
		final Authentication auth = new Authentication("xxxxxxxxx@gmail.com", "******");
		
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("nombre", "nombre");
		mapping.put("apellido", "apellido");
		mapping.put("dni", "dni");
		mapping.put("direccion", "direccion");

		MappingEntityService<Cliente> mappingCliente = new MappingEntityService<Cliente>(
				key, Cliente.class, auth);

		List<Cliente> customers = mappingCliente.mapping(mapping);

		int indexClient = new Double(Math.random() * 10D).intValue();
		Cliente c1 = customers.get(indexClient);
		String nameClientValie = customersValid[indexClient][0];
		assertEquals(c1.getNombre(), nameClientValie);

	}

}
