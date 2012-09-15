package gl.reader;

import gl.Authentication;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.util.ServiceException;

/**
 * ColumnNumberToObjectProperties
 *
 * Mapping a row with object.
 * It use the column number for mapping each property.
 *
 * @author Cristian Ceferino Llanos <cristian.llanos@globallogic.com>
 *
 * @param <T> same object type.
 */
public class ColumnNumberToObjectProperties<T> extends XLSReader<T> {

	private Map<Integer, String> mapping;

	public ColumnNumberToObjectProperties(String key,Map<Integer, String> mapping, Class<T> bean, Authentication auth)
	throws IOException, ServiceException, InstantiationException,
			IllegalAccessException, SecurityException,
			IllegalArgumentException, NoSuchMethodException,
			NoSuchFieldException, InvocationTargetException {
		super(key, bean, auth);
		this.mapping = mapping;
	}

	@Override
	protected T mergeRowAndEntity(ListEntry listEntry, T entity)
	throws SecurityException, IllegalArgumentException,
			NoSuchMethodException, NoSuchFieldException,
			IllegalAccessException, InvocationTargetException,
			InstantiationException {
		int numberColumn = -1;
		for (String nameColumn : listEntry.getCustomElements().getTags()) {
			numberColumn++;
			String value = listEntry.getCustomElements().getValue(nameColumn);
			String property = mapping.get(numberColumn);
			if (property != null) {
				setValue(value, property, entity);
			}
		}
		return entity;
	}

}
