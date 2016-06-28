package com.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IMDB_Chart {
	List<WebElement> elementList = new ArrayList<WebElement>();

	public  List <WebElement> getMovieList(WebDriver wd){
		String xpathStart=".//*[@id='main']/div/span/div/div/div[2]/table/tbody/tr[";
		String xpathEnd="]/td[2]/a";
		for(int i=1;i<=250;i++){
			elementList.add(wd.findElement(By.xpath(xpathStart+i+xpathEnd)));
		}
		return elementList;
	}
}
