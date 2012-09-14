package gl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gdata.client.spreadsheet.FeedURLFactory;
import com.google.gdata.client.spreadsheet.SpreadsheetQuery;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;
import com.google.gdata.util.ServiceException;

public class MapperBean {

	public List<Client> mapper(SourceMappingXLSFile sp, Authentication auth)
			throws IOException, ServiceException, InstantiationException, IllegalAccessException {

		SpreadsheetService service = new SpreadsheetService(
				"MySpreadsheetIntegration-v1");
		service.setUserCredentials(auth.getUsername(), auth.getPassword());

		URL SPREADSHEET_FEED_URL = new URL(sp.getXlsUrlSource());

		// spreadsheet
		WorksheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL,
				WorksheetFeed.class);
		WorksheetEntry worksheetEntry = feed.getEntries().get(0);
		URL listFeedUrl = worksheetEntry.getListFeedUrl();

		ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);

		List<Object> list = new ArrayList<Object>();
		
		for (ListEntry entry : listFeed.getEntries()) {
			
			String id = entry.getId().substring(entry.getId().lastIndexOf('/') + 1);

			System.out.println("-- Fila -- id: " + id + "  title: " + entry.getTitle().getPlainText());
			
			Object object = sp.getBean().newInstance();
			
			int numeroCol = -1 ;
			for (String nombreCol : entry.getCustomElements().getTags()) {
				numeroCol++;
				String valueCell = entry.getCustomElements().getValue(nombreCol);
				
				System.out.println("\t Col"+numeroCol+" " + nombreCol+"="+valueCell);
				
				String property = sp.getSettingMapping().get(numeroCol);
				if(property==null)
					property = sp.getSettingMapping().get(nombreCol);
				
				
				boolean isSetColumn = property!=null;
				
				
				
			}
			
			
		}

		return null;
	}

	public void bla() throws IOException, ServiceException {
		String username = "cristian.llanos@gmail.com";
		String password = "";
		String spreadsheet = "Clientes";
		SpreadsheetService service = new SpreadsheetService(
				"MySpreadsheetIntegration-v1");
		service.setUserCredentials(username, password);
		FeedURLFactory factory = FeedURLFactory.getDefault();
		SpreadsheetQuery spreadsheetQuery = new SpreadsheetQuery(
				factory.getSpreadsheetsFeedUrl());
		spreadsheetQuery.setTitleQuery(spreadsheet);
		SpreadsheetFeed spreadsheetFeed = service.query(spreadsheetQuery,
				SpreadsheetFeed.class);
		List<SpreadsheetEntry> spreadsheets = spreadsheetFeed.getEntries();
		
		System.out.println(spreadsheets.size());
		
	}

}
