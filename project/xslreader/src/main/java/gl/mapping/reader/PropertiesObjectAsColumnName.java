package gl.mapping.reader;

import gl.mapping.Authentication;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

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

	public PropertiesObjectAsColumnName(String key, Class<T> bean, Authentication auth) throws XLSReaderException{
		super(key, null, bean, auth);
		
		try{
	
			super.mapping = new HashMap<String, String>();
			
			for (Field field : bean.getDeclaredFields()) {
				String property = field.getName();
				String nameSetMethod = "set" + property.substring(0, 1).toUpperCase() + property.substring(1, property.length());
				boolean isAccessible = false;
				try{
					Method setMethod = bean.getMethod(nameSetMethod, field.getType());
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
		}catch (Exception e){
			throw new XLSReaderException(e);
		}
	}
	
}
