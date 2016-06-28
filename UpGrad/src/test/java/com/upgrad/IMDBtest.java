package com.upgrad;

import java.util.ArrayList;
import java.util.List;
import com.utils.ExcelReader;
import com.pageobjects.IMDB_Chart;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class IMDBtest {
	WebDriver wd = null;
	@Test()
	public void imdb250() throws Exception{
		wd =new FirefoxDriver();
		wd.get("http://www.imdb.com/chart/top");
		wd.manage().window().maximize();
		IMDB_Chart chart= new IMDB_Chart();
		List<WebElement> movies =chart.getMovieList(wd);
		
		ExcelReader xls= new ExcelReader();
		List<String> expectedList= (List<String>) xls.readExcel();
		
		Assert.assertTrue(movies.size()>0);
		if(movies.size()==expectedList.size()){
			for(int i=0;i<250;i++){
				Assert.assertEquals(movies.get(i).getText(), expectedList.get(i));
			}
		}
		else {
			Assert.fail();
		}
	}
	
	@AfterClass
	public void afterClass(){
		wd.close();
	}
}
