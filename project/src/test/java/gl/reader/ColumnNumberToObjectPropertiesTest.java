package gl.reader;

import gl.entities.Cliente;
import gl.mapping.reader.ColumnNumberToObjectProperties;
import gl.mapping.reader.MappingIterator;
import gl.mapping.reader.XLSReaderException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColumnNumberToObjectPropertiesTest extends XLSReaderTest {

	public void test() throws XLSReaderException {

		Map<Integer, String> mapping = new HashMap<Integer, String>();
		mapping.put(0, "nombre");
		mapping.put(1, "apellido");
		mapping.put(2, "dni");
		mapping.put(3, "direccion");

		ColumnNumberToObjectProperties<Cliente> reader = new ColumnNumberToObjectProperties<Cliente>(
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
