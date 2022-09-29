package testVagrant.testvagrantprohect;

import java.io.IOException;
import java.util.Date;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepages.Property;
import testvagrantpages.ImdbHome;
import testvagrantpages.WikiHome;

public class WikiImdbTest {
	public Date imdbRealeaseDate;
	public Date wikiRealeasedate;

	@BeforeMethod
	public void setup() throws IOException {
		ImdbHome imdiPushpa = new ImdbHome();
		imdbRealeaseDate = imdiPushpa.getReleaseDate(Property.getProperty("PushpaimdbiUrl"));

		WikiHome wikiPushpa = new WikiHome();
		wikiRealeasedate = wikiPushpa.getRealeaseDate(Property.getProperty("PushpawikiUrl"));

	}

	@Test
	public void testCase1() {

		if (imdbRealeaseDate.equals(wikiRealeasedate)) {
			System.out.println("Realease Date is matching");

		} else {
			System.out.println("Realease is Not Mtching");
		}

	}

}
