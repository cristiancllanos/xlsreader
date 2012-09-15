package gl.reader;

import gl.Authentication;

import java.io.IOException;
import java.util.HashMap;

import com.google.gdata.util.ServiceException;

public class PropertiesObjectAsColumnName<T> extends ColumnNameToObjectProperties<T> {

	public PropertiesObjectAsColumnName(String key, Class<T> bean,
			Authentication auth) throws IOException, ServiceException,
			InstantiationException, IllegalAccessException {
		super(key, null, bean, auth);
		super.mapping = new HashMap<String, String>();
		//TODO: set properties with reflection
	}
	
}
