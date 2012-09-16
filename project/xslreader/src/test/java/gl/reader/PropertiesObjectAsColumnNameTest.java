package gl.reader;

import gl.entities.Cliente;
import gl.mapping.reader.MappingIterator;
import gl.mapping.reader.PropertiesObjectAsColumnName;
import gl.mapping.reader.XLSReaderException;

import java.util.ArrayList;
import java.util.List;

public class PropertiesObjectAsColumnNameTest extends XLSReaderTest {

	public void test() throws XLSReaderException {

		PropertiesObjectAsColumnName<Cliente> reader = new PropertiesObjectAsColumnName<Cliente>(
				key, bean, auth);
		MappingIterator<Cliente> mappingIterator = reader.iterator();
		
		List<Cliente> customers = new ArrayList<Cliente>();
		while (mappingIterator.hasNext()) {
			customers.add(mappingIterator.next());
		}

		int indexClient = new Double(Math.random() * 10D).intValue();
		Cliente c1 = customers.get(indexClient);
		String nameClientValie = customersValid[indexClient][0];
		assertEquals(nameClientValie, c1.getNombre());

	}
}