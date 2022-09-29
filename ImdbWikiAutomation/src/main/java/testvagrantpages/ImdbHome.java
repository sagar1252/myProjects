package testvagrantpages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepages.BaseClass;

public class ImdbHome extends BaseClass {

	public ImdbHome() {
		super();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@id='releaseinfo_content']/table[1]")
	WebElement releaseDateTable;

	public Date getReleaseDate(String movieUrl) {

		driver.get(movieUrl);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5800)", "");
		WebElement division = driver.findElement(By.id("ipc-wrap-background-id"));
		java.util.List<WebElement> section = division.findElements(By.xpath("//section"));
		int sectionSize = section.size();
		String beforeXpath = "//*[@id='__next']/main/div/section[1]/div/section/div/div[1]/section[";
		String afterXpath = "]";
		for (int i = 0; i <= sectionSize; i++) {
			String actualXpath = beforeXpath + i + afterXpath;
			try {
				WebElement ele = driver.findElement(By.xpath(actualXpath));

				String sections = driver.findElement(By.xpath(actualXpath)).getAttribute("data-testid");

				if (sections != null && sections.equals("Details")) {
					WebElement realese = driver.findElement(By.xpath("//a[text()='Release date']"));
					System.out.println(realese.getText() + " ::");
					String realasedate = driver
							.findElement(By.xpath(beforeXpath + (i) + afterXpath + "/div[2]/ul/li[1]/div")).getText();
					System.out.println(realasedate.replaceAll(",", " ").substring(0, realasedate.indexOf("(")));
					if (realasedate.contains("India")) {
						String imdbRealeaseDate = realasedate.replaceAll(",", " ").substring(i,
								realasedate.indexOf("("));
						java.util.Date imdbiRealeaseDate1 = new SimpleDateFormat("dd MMMM yyyy")
								.parse(imdbRealeaseDate);
						return imdbiRealeaseDate1;
					} else {
						driver.findElement(By.xpath(beforeXpath + (i) + afterXpath + "/div[2]/ul/li[1]/div")).click();

						return realeaseDate();

					}
				}

			} catch (Exception e) {

				i++;
			}
		}
		System.out.println("Finish");
		return null;
	}

	public Date realeaseDate() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("...........Country Name Is Not Matching........ ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		java.util.List<WebElement> rows = releaseDateTable.findElements(By.tagName("tr"));

		// row
		int rownum = rows.size();
		String beforXpath = "//*[@id='releaseinfo_content']/table[1]/tbody/tr[";
		String afterXpath = "]/td[1]/a";

		for (int i = 1; i <= rownum; i++) {

			String actualxpath = beforXpath + i + afterXpath;
			try {
				WebElement ele = driver.findElement(By.xpath(actualxpath));

				if (ele.getText().equals("India")) {
					WebElement ele1 = driver.findElement(By.xpath(beforXpath + i + "]/td[2]"));

					System.out.println("Release Date Is= " + ele1.getText());
					String imdbRealeaseDate = ele1.getText().replaceAll(",", " ");
					java.util.Date imdbiRealeaseDate1 = new SimpleDateFormat("dd MMMM yyyy").parse(imdbRealeaseDate);
					return imdbiRealeaseDate1;
				}

			} catch (Exception e) {
				i++;
			}

		}
		return null;

	}

}
