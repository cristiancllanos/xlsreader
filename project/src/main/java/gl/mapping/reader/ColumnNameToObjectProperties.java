package gl.mapping.reader;

import gl.mapping.Authentication;

import java.util.Map;

import com.google.gdata.data.spreadsheet.ListEntry;

/**
 * ColumnNameToObjectProperties
 * 
 * Mapping a row with object. It use the column name for mapping each property.
 * 
 * @author Cristian Ceferino Llanos <cristian.llanos@globallogic.com>
 * 
 * @param <T>
 *            same object type.
 */
public class ColumnNameToObjectProperties<T> extends XLSReader<T> {

	protected Map<String, String> mapping;

	public ColumnNameToObjectProperties(String key,
			Map<String, String> mapping, Class<T> bean, Authentication auth) {
		super(key, bean, auth);
		this.mapping = mapping;
	}

	@Override
	protected T mergeRowAndEntity(ListEntry listEntry, T entity) throws XLSReaderException {
		for (String nameColumn : listEntry.getCustomElements().getTags()) {
			String value = listEntry.getCustomElements().getValue(nameColumn);
			String property = mapping.get(nameColumn);
			if (property != null) {
				setValue(value, property, entity);
			}
		}
		return entity;
	}

}
