package gl.mapping.reader;

import gl.mapping.Authentication;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;

/**
 * XLSReader
 *
 * Handler mapping of a XLS file to anything object.
 * Offer a interface like iterator.
 *
 * @author Cristian Ceferino Llanos <cristian.llanos@globallogic.com>
 *
 * @param <T> same object type.
 */
public abstract class XLSReader<T> implements Iterable<T> {

	private String key;
	private Class<T> bean; 
	private Authentication auth;
	private List<T> entities = new ArrayList<T>();

	public XLSReader(String key, Class<T> bean, Authentication auth) {
		super();
		this.key = key;
		this.bean = bean;
		this.auth = auth;
	}

	public MappingIterator<T> iterator() {
		try {
			mapping();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return new MappingIterator<T>(entities);
	}

	private void mapping() throws XLSReaderException {

		try{
		
			SpreadsheetService service = new SpreadsheetService("MySpreadsheetIntegration-v1");
	
			service.setUserCredentials(auth.getUsername(), auth.getPassword());
	
			final String url = "https://spreadsheets.google.com/feeds/worksheets/"+key+"/private/full";
			final URL SPREADSHEET_FEED_URL = new URL(url);
	
			WorksheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL, WorksheetFeed.class);
			WorksheetEntry worksheetEntry = feed.getEntries().get(0);
			URL listFeedUrl = worksheetEntry.getListFeedUrl();
	
			ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
			
			for (ListEntry listEntry : listFeed.getEntries()) {
				T entity = bean.newInstance();
				mergeRowAndEntity(listEntry, entity);
				entities.add(entity);
			}
		
		}catch (Exception e){
			throw new XLSReaderException(e);
		}
	}

	protected T setValue(String value, String property, T entity) throws XLSReaderException	{

		try{
			Field field = entity.getClass().getDeclaredField(property);
			Constructor constructor = field.getType().getConstructor(String.class);
			Object valueObject = constructor.newInstance(value);
			String nameSetMethod = "set" + property.substring(0, 1).toUpperCase() + property.substring(1, property.length());
			Method setMethod = entity.getClass().getMethod(nameSetMethod, field.getType());
			Object[] params = { valueObject };
			setMethod.invoke(entity, params);
		}catch(Exception e){
			throw new XLSReaderException(e);
		}

		return entity;
	}
	
	protected abstract T mergeRowAndEntity(ListEntry listEntry, T entity) throws XLSReaderException;
	
}
