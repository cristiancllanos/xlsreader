package gl.reader;

import gl.Authentication;
import gl.Client;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

public class XLSReaderTest extends TestCase {

	private final String key = "0Ap9dpq9vAeVtdEZZc0lyNV9fQk5kVlpyaFI3dXM4Mnc";
	private final Class<Client> bean = Client.class;
	private final Authentication auth = new Authentication(
			"cristiancllanos@gmail.com", "gl123456");

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

	public void testMappingColumnNameToObjectProperties()
			throws SecurityException, IllegalArgumentException, IOException,
			ServiceException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, NoSuchFieldException,
			InvocationTargetException {

		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("nombre", "nombre");
		mapping.put("apellido", "apellido");
		mapping.put("dni", "dni");
		mapping.put("direccion", "direccion");

		ColumnNameToObjectProperties<Client> reader = new ColumnNameToObjectProperties<Client>(
				key, mapping, Client.class, auth);
		MappingIterator<Client> mappingIterator = reader.iterator();
		
		List<Client> customers = new ArrayList<Client>();
		while (mappingIterator.hasNext()) {
			customers.add(mappingIterator.next());
		}

		int indexClient = new Double(Math.random() * 10D).intValue();
		Client c1 = customers.get(indexClient);
		String nameClientValie = customersValid[indexClient][0];
		assertEquals(c1.getNombre(), nameClientValie);

	}
	
	public static void main(String[] arg) {
		try {
			new XLSReaderTest().testMappingColumnNameToObjectProperties();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
