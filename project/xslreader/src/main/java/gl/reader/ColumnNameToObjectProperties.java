package gl.reader;

import gl.Authentication;

import java.io.IOException;
import java.util.Map;

import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.util.ServiceException;

public class ColumnNameToObjectProperties<T> extends XLSReader<T> {

	protected Map<String, String> mapping;

	public ColumnNameToObjectProperties(String key,
			Map<String, String> mapping, Class<T> bean, Authentication auth)
			throws IOException, ServiceException, InstantiationException,
			IllegalAccessException {
		super(key, bean, auth);
		this.mapping = mapping;
	}

	@Override
	protected T mergeRowAndEntity(ListEntry listEntry, T entity) {
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
