package gl.reader;

import gl.Client;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.google.gdata.util.ServiceException;

public class PropertiesObjectAsColumnNameTest extends XLSReaderTest {

	public void test()
			throws SecurityException, IllegalArgumentException, IOException,
			ServiceException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, NoSuchFieldException,
			InvocationTargetException {

		PropertiesObjectAsColumnName<Client> reader = new PropertiesObjectAsColumnName<Client>(
				key, bean, auth);
		MappingIterator<Client> mappingIterator = reader.iterator();
		
		List<Client> customers = new ArrayList<Client>();
		while (mappingIterator.hasNext()) {
			customers.add(mappingIterator.next());
		}

		int indexClient = new Double(Math.random() * 10D).intValue();
		Client c1 = customers.get(indexClient);
		String nameClientValie = customersValid[indexClient][0];
		assertEquals(nameClientValie, c1.getNombre());

	}
}