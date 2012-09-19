package gl.reader;

import gl.entities.Cliente;
import gl.mapping.reader.ColumnNameToObjectProperties;
import gl.mapping.reader.MappingIterator;
import gl.mapping.reader.XLSReaderException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColumnNameToObjectPropertiesTest extends XLSReaderTest {

	public void test() throws XLSReaderException {

		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("nombre", "nombre");
		mapping.put("apellido", "apellido");
		mapping.put("dni", "dni");
		mapping.put("direccion", "direccion");

		ColumnNameToObjectProperties<Cliente> reader = new ColumnNameToObjectProperties<Cliente>(
				key, mapping, bean, auth);
		MappingIterator<Cliente> mappingIterator = reader.iterator();

		List<Cliente> customers = new ArrayList<Cliente>();
		while (mappingIterator.hasNext()) {
			customers.add(mappingIterator.next());
		}

		int indexClient = new Double(Math.random() * 10D).intValue();
		Cliente c1 = customers.get(indexClient);
		String nameClientValie = customersValid[indexClient][0];
		assertEquals(c1.getNombre(), nameClientValie);

	}

}
