package com.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IMDB_Chart {
	WebElement[][] elementList = new WebElement[250][3];

	public  WebElement[][] getMovieList(WebDriver wd){
		String xpathStart=".//*[@id='main']/div/span/div/div/div[2]/table/tbody/tr[";
		String xpathEnd="]/td[2]/a";
		for(int i=0;i<250;i++){
			elementList[i][0]=wd.findElement(By.xpath(xpathStart+(i+1)+xpathEnd));
			elementList[i][1]=wd.findElement(By.xpath(xpathStart+(i+1)+"]/td[2]/span"));
			elementList[i][2]=wd.findElement(By.xpath(xpathStart+(i+1)+"]/td[3]/strong"));
		}
		return elementList;
	}
}
