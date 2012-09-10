package gl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

import junit.framework.TestCase;

public class MapperBeanTest extends TestCase {

	private String[][] customersValid = {
			{ "Juan", "Fernandez", "30565890", "Alen 418 GC" },
			{ "Carlos", "Martinez", "27599890", "San Martin Guaymallen" },
			{ "Pedro", "Lainez", "27565890", "Benegas 23 San Martin" },
			{ "Luciana", "Toleo", "26565888", "San Lorenzo 589 Maipu" },
			{ "Marcelo", "Salmeron", "27565890", "Martinez de Rosa 56 Capital" },
			{ "Martin", "Caleri", "31565875", "J. Moldes 589 Capital" },
			{ "Matias", "Moreno", "20595800", "Moron 68 Maipu" },
			{ "Mariana", "Paleo", "25555890", "La Valle 87 Ciudad" },
			{ "Sandra", "Merino", "25667800", "Salta 33 GC" } };

	public void testMapper() throws AuthenticationException, MalformedURLException, IOException, ServiceException {

		//
		String xlsUrlSource = "https://docs.google.com/spreadsheet/ccc?key=0Ap9dpq9vAeVtdEZZc0lyNV9fQk5kVlpyaFI3dXM4Mnc";
		Class bean = Client.class;
		String[][] settingMapping = {{"1","name"},{"2","lastname"},{"3","dni"},{"4","address"}};		
		SourceMappingXLSFile sp = new SourceMappingXLSFile(xlsUrlSource, bean, settingMapping);

		MapperBean mb = new MapperBean();
		List<Client> customers = mb.mapper(sp);

//		int indexClient = new Double(Math.random()*10D).intValue();
//		Client c1 = customers.get(indexClient);
//		String nameClientValie = customersValid[indexClient][0]; 
//		assertEquals(c1.getName(), nameClientValie);

	}

}