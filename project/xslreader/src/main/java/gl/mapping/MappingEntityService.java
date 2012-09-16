package gl.mapping;

import gl.mapping.reader.ColumnNameToObjectProperties;
import gl.mapping.reader.ColumnNumberToObjectProperties;
import gl.mapping.reader.MappingIterator;
import gl.mapping.reader.PropertiesObjectAsColumnName;
import gl.mapping.reader.XLSReader;
import gl.mapping.reader.XLSReaderException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * MappingEntityService
 *
 * Service of mapping.
 *
 * @author Cristian Ceferino Llanos <cristian.llanos@globallogic.com>
 */
public class MappingEntityService<T> {

	private Authentication auth;
	private String key;
	private Class<T> bean;

	public MappingEntityService(String key, Class<T> bean, Authentication auth) {
		super();
		this.auth = auth;
		this.key = key;
		this.bean = bean;
	}
	
	public MappingEntityService(Authentication auth) {
		this.auth = auth;
	}

	/**
	 * Mapping a row with object. It use the column name for mapping each
	 * property. The column name are set from name of property the object.
	 *
	 * @throws XLSReaderException
	 */
	public List<T> mapping() throws XLSReaderException {
		return mapping(new PropertiesObjectAsColumnName<T>(key, bean, auth));
	}

	/**
	 * Mapping a row with object. It use the column name for mapping each
	 * property.
	 *
	 * @throws XLSReaderException
	 */
	public List<T> mapping(Map<String, String> mapping) throws XLSReaderException {

		return mapping(new ColumnNameToObjectProperties<T>(key, mapping, bean, auth));
	}

	/**
	 * Mapping a row with object. It use the column name for mapping each
	 * property.
	 *
	 * @throws XLSReaderException
	 */
	public List<T> mapping2(Map<Integer, String> mapping) throws XLSReaderException {

		return mapping(new ColumnNumberToObjectProperties<T>(key, mapping, bean, auth));
	}

	private List<T> mapping(XLSReader<T> reader) {

		MappingIterator<T> mappingIterator = reader.iterator();

		List<T> entities = new ArrayList<T>();
		while (mappingIterator.hasNext()) {
			entities.add(mappingIterator.next());
		}

		return entities;
	}
}
