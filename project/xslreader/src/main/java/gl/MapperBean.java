package gl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.google.gdata.client.spreadsheet.FeedURLFactory;
import com.google.gdata.client.spreadsheet.SpreadsheetQuery;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

public class MapperBean {

	public List<Client> mapper(SourceMappingXLSFile sp)
			throws AuthenticationException, MalformedURLException, IOException,
			ServiceException {

		bla();
		
		SpreadsheetService service = new SpreadsheetService(
				"MySpreadsheetIntegration-v1");

		// TODO: Authorize the service object for a specific user (see other
		// sections)

		// Define the URL to request. This should never change.
		// URL SPREADSHEET_FEED_URL = new URL(
		// "https://spreadsheets.google.com/feeds/spreadsheets/private/full");
		URL SPREADSHEET_FEED_URL = new URL(sp.getXlsUrlSource());

		// Make a request to the API and get all spreadsheets.
		SpreadsheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL,
				SpreadsheetFeed.class);
		List<SpreadsheetEntry> spreadsheets = feed.getEntries();

		// Iterate through all of the spreadsheets returned
		for (SpreadsheetEntry spreadsheet : spreadsheets) {
			// Print the title of this spreadsheet to the screen
			System.out.println(spreadsheet.getTitle().getPlainText());
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
