package woistwalter;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import woistwalter.model.Family;

public class FamilyXMLSerializer {

	private static final String HOST = "localhost";
	private static final int PORT = 2222;

	/*
	 * Serializes the given family into a XML document.
	 */
	public void Serialize(Family fam) {

		try (Socket skt = new Socket(HOST, PORT)) {

			try (ObjectOutputStream objectOutput = new ObjectOutputStream(skt.getOutputStream())) {

				objectOutput.writeObject(fam);

			} catch (IOException e) {

			}
		} catch (IOException e1) {
		}
	}

}
