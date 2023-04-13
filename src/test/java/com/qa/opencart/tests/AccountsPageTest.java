package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	public void accPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());

		//accPage=loginPage.doLogin("qatestertest@gmail.com","Test@123");
		
	}
	@Test
	public void accPageTitleTest() {
		String actTitle = accPage.getAccountsPageTitle();
		Assert.assertEquals(AppConstants.ACCOUNT_PAGE_TITLE_VALUE, actTitle);
		//Assert.assertEquals(actTitle ,"My Account");
	}
	@Test
	public void accPageURLTest() {
		String actURL = accPage.getAccountsPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.ACCOUNT_PAGE_URL_FRACTION_VALUE));
	}
	@Test
	public void accLogoutLinkExistTest() {
		accPage.isLogoutLinkExist();
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	@Test
	public void accPageHeadersTest() {
		List<String> actualAccHeaderList = accPage.getAccountPageHeaderList();
		System.out.println("acc page header list;"+ actualAccHeaderList);
		Assert.assertEquals(actualAccHeaderList.size(),AppConstants.ACCOUNT_PAGE_HEADERS_COUNT);
	}
	
	@Test
	public void accPageHeadersValueTest() {
		List<String> actualAccHeaderList = accPage.getAccountPageHeaderList();
		System.out.println("acc page header list;"+ actualAccHeaderList);
		System.out.println("exp page header list"+AppConstants.EXCEPTED_ACCOUNT_PAGE_HEADERS_LIST);
		Assert.assertEquals(actualAccHeaderList,AppConstants.EXCEPTED_ACCOUNT_PAGE_HEADERS_LIST);
	}
	@Test
	public void searchTest() {
		searchPage=accPage.performSearch("Macbook");
		Assert.assertTrue(searchPage.getSearchProductCount()>0);
	}
	
	

}
