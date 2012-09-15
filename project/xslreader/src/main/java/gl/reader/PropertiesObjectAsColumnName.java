package gl.reader;

import gl.Authentication;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import com.google.gdata.util.ServiceException;

/**
 * PropertiesObjectAsColumnName
 *
 * Mapping a row with object.
 * It use the column name for mapping each property.
 * The column name are set from name of property the object.
 *
 * @author Cristian Ceferino Llanos <cristian.llanos@globallogic.com>
 *
 * @param <T> same object type.
 */
public class PropertiesObjectAsColumnName<T> extends ColumnNameToObjectProperties<T> {

	public PropertiesObjectAsColumnName(String key, Class<T> bean, Authentication auth) 
	throws IOException, ServiceException,
			InstantiationException, IllegalAccessException, SecurityException,
			IllegalArgumentException, NoSuchMethodException,
			NoSuchFieldException, InvocationTargetException {

		super(key, null, bean, auth);

		super.mapping = new HashMap<String, String>();
		
		for (Field field : bean.getFields()) {
			String property = field.getName();
			String nameSetMethod = "set" + property.substring(0, 1).toUpperCase() + property.substring(1, property.length());
			boolean isAccessible = false;
			try{
				Method setMethod = bean.getClass().getMethod(nameSetMethod, field.getDeclaringClass());
				isAccessible = setMethod != null;
			} catch (NoSuchMethodException e) {
				isAccessible = false;
			} catch (SecurityException e) {
				isAccessible = false;
			}

			if (isAccessible) {
				super.mapping.put(property, property);
			}
		}
	}
	
}
