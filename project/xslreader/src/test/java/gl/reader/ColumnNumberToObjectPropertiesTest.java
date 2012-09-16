package gl.reader;

import gl.Client;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gdata.util.ServiceException;

public class ColumnNumberToObjectPropertiesTest extends XLSReaderTest {

	public void test()
			throws SecurityException, IllegalArgumentException, IOException,
			ServiceException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, NoSuchFieldException,
			InvocationTargetException {

		Map<Integer, String> mapping = new HashMap<Integer, String>();
		mapping.put(0, "nombre");
		mapping.put(1, "apellido");
		mapping.put(2, "dni");
		mapping.put(3, "direccion");

		ColumnNumberToObjectProperties<Client> reader = new ColumnNumberToObjectProperties<Client>(
				key, mapping, bean, auth);
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

}
