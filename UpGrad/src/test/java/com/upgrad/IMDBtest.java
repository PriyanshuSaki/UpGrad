package com.upgrad;

import java.util.ArrayList;
import java.util.List;
import com.utils.ExcelReader;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class IMDBtest {

	@Test()
	public void imdb250() throws Exception{
		WebDriver wd = new FirefoxDriver();
		wd.get("http://www.imdb.com/chart/top");
		wd.manage().window().maximize();
		String xpathStart=".//*[@id='main']/div/span/div/div/div[2]/table/tbody/tr[";
		String xpathEnd="]/td[2]/a";
		
		List<String> movies = new ArrayList<String>();
		
		for(int i=1;i<=250;i++){
			//System.out.println(wd.findElement(By.xpath(xpathStart+i+xpathEnd)).getText());
			movies.add(wd.findElement(By.xpath(xpathStart+i+xpathEnd)).getText());
		}
		
		wd.close();
		
		ExcelReader xls= new ExcelReader();
		List<String> expectedList= (List<String>) xls.readExcel();
		
		Assert.assertTrue(movies.size()>0);
		if(movies.size()==expectedList.size()){
			for(int i=0;i<250;i++){
				Assert.assertEquals(movies.get(i), expectedList.get(i));
			}
		}
		else {
			Assert.fail();
		}
	}
}
