package gl.mapping.reader;

import gl.mapping.Authentication;

import java.util.Map;

import com.google.gdata.data.spreadsheet.ListEntry;

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

	public ColumnNumberToObjectProperties(String key,
			Map<Integer, String> mapping, Class<T> bean, Authentication auth) {
		super(key, bean, auth);
		this.mapping = mapping;
	}

	@Override
	protected T mergeRowAndEntity(ListEntry listEntry, T entity) throws XLSReaderException {
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
