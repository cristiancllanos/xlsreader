package gl.reader;

import gl.Authentication;

import java.io.IOException;
import java.util.Map;

import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.util.ServiceException;

public class ColumnNumberToObjectProperties<T> extends XLSReader<T> {

	private Map<Integer, String> mapping;

	public ColumnNumberToObjectProperties(String key,
			Map<Integer, String> mapping, Class<T> bean, Authentication auth)
			throws IOException, ServiceException, InstantiationException,
			IllegalAccessException {
		super(key, bean, auth);
		this.mapping = mapping;
	}

	@Override
	protected T mergeRowAndEntity(ListEntry listEntry, T entity) {
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
