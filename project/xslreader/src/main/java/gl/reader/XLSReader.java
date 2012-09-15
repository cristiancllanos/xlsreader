package gl.reader;

import gl.Authentication;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;
import com.google.gdata.util.ServiceException;

public abstract class XLSReader<T> implements Iterator<T> {

	List<T> entities = new ArrayList<T>();

	public XLSReader(String key, Class<T> bean, Authentication auth) throws IOException, ServiceException, InstantiationException, IllegalAccessException {

		SpreadsheetService service = new SpreadsheetService("MySpreadsheetIntegration-v1");

		service.setUserCredentials(auth.getUsername(), auth.getPassword());

		final String url = "https://docs.google.com/spreadsheet/ccc?key="+key;
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
	}

	protected T setValue(String value, String property, T entity){
		//TODO: set value with reflection
		return entity;
	}
	
	protected abstract T mergeRowAndEntity(ListEntry listEntry, T entity);
	
	public boolean hasNext(){
		return true;
	}

	public T next(){
		return null;
	}

	public void remove(){
		
	}

}
