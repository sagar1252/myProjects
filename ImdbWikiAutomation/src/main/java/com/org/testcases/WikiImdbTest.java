package com.org.testcases;

import java.util.Date;

import org.testng.annotations.Test;

import com.org.common.Property;
import com.org.page.ImdbHome;
import com.org.page.WikiHome;

import junit.framework.Assert;

public class WikiImdbTest {

	@Test
	public void testCase1() {
		Date imdbRealeaseDate;
		Date wikiRealeasedate;

		ImdbHome imdiPushpa = new ImdbHome();
		imdbRealeaseDate = imdiPushpa.getReleaseDate(Property.getProperty("imdbiMovieUrl"));

		WikiHome wikiPushpa = new WikiHome();
		wikiRealeasedate = wikiPushpa.getRealeaseDate(Property.getProperty("wikiMovieUrl"));

		Assert.assertEquals(true, imdbRealeaseDate.equals(wikiRealeasedate));

	}

}
