package mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * Servlet implementation class Bean
 */
@WebServlet("/Bean")
public class Bean {

	
	//statisk l�nk till sk�netrafiken
	public String URL = "http://www.labs.skanetrafiken.se/v2.2/stationresults.asp?selPointFrKey=80000";

	//arraylist f�r de namn som plockas fram via apiGet()
	private ArrayList<String> names = new ArrayList<String>();

	public ArrayList<String> getNames() {
		return names;
	}

	
	public void setNames() {

		try {
			apiGet();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//Metoden f�r att h�mta api och f� fram informationen
	private void apiGet() throws IOException {

		URL line_api_url = new URL(URL);

		HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();

		linec.setDoInput(true);

		linec.setDoOutput(true);

		linec.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));

		String inputLine;

		String ApiResponse = "";

		while ((inputLine = in.readLine()) != null) {

			ApiResponse += inputLine;

		}
		in.close();
		System.out.println(ApiResponse);

		Document doc = convertStringToXMLDocument(ApiResponse);

		doc.getDocumentElement().normalize();

		Node nodeBody = doc.getElementsByTagName("soap:Body").item(0);

		NodeList nodeResult = (NodeList) nodeBody.getFirstChild().getFirstChild();

		Node nodelines = nodeResult.item(2);

		NodeList listOflines = nodelines.getChildNodes();

		for (int i = 0; i < listOflines.getLength(); i++) {

			NodeList allLine = listOflines.item(i).getChildNodes();

			for (int y = 0; y < allLine.getLength(); y++) {
				System.out.println(allLine.item(y).getTextContent());

				if (allLine.item(y).getNodeName().equals("Towards")) {

					names.add(allLine.item(y).getTextContent());

				}

			}
		}

	}

	//metod/factory f�r att g�ra om informationen till xml
	private Document convertStringToXMLDocument(String xmlString) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = null;

		try {

			builder = factory.newDocumentBuilder();

			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));

			return doc;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}