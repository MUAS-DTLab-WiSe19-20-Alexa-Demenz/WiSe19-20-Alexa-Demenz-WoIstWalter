package woistwalter;

import java.beans.XMLDecoder;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import woistwalter.model.Family;

public class FamilyXMLDeserializer {

	private final static String URL = "http://localhost:2221";

	public Family Deserialize() {
		URL url = null;
		Family fam = null;

		try {
			url = new URL(URL);
			try {
				URLConnection conn = url.openConnection();
				conn.connect();

				try (XMLDecoder dec = new XMLDecoder(conn.getInputStream())) {
					fam = (Family) dec.readObject();
					return fam;
				} catch (Exception ex) {
					// Failed to read the xml from the server
				}
			} catch (MalformedURLException e1) {
				// Failed to open the given URL
			}

		} catch (IOException e) {
			// Failed to connect to the given URL.
		}

		return fam;
	}
}
