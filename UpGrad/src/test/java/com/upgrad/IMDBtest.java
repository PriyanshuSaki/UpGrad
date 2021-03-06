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
		
		//getting all the movies , their release year and ratings from the website
		WebElement[][] movies =chart.getMovieList(wd);
		
		//fetching the stored data
		ExcelReader xls= new ExcelReader();
		String[][] expectedList=  xls.readExcel();
	
		//asserting the fetched data with the data from excel
		Assert.assertTrue(movies.length>0);
		if(movies.length==expectedList.length){
			for(int i=0;i<250;i++){
				Assert.assertEquals(movies[i][0].getText(), expectedList[i][0]);
				Assert.assertEquals(movies[i][1].getText(), expectedList[i][1]);
				Assert.assertEquals(movies[i][2].getText(), expectedList[i][2]);
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
