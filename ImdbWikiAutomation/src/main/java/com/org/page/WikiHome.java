package com.org.page;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.common.BaseClass;

public class WikiHome extends BaseClass {
	public WikiHome() {
		super();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@id='mw-content-text']/div[1]/table[1]")
	WebElement releaseDateTable;

	public Date getRealeaseDate(String movieUrl) {

		driver.get(movieUrl);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");

		java.util.List<WebElement> rows = releaseDateTable.findElements(By.tagName("tr"));
		rows.size();
		// row
		int rownum = rows.size();

		String beforXpath = "//*[@id='mw-content-text']/div[1]/table[1]/tbody/tr[";
		String afterXpath = "]/th";

		for (int i = 1; i <= rownum; i++) {

			String actualxpath = beforXpath + i + afterXpath;
			try {

				WebElement ele = driver.findElement(By.xpath(actualxpath));

				if (ele.getText().equals("Release date")) {
					WebElement ele1 = driver
							.findElement(By.xpath("//*[@id='mw-content-text']/div[1]/table[1]/tbody/tr[" + i + "]/td"));

					String wikiDate = ele1.getText().replaceAll(",", " ");
					java.util.Date wikiRealeaseDate = new SimpleDateFormat("dd MMMM yyyy").parse(wikiDate);
					return wikiRealeaseDate;
				}

			} catch (Exception e) {
				i++;
			}

		}
		return null;

	}
}
