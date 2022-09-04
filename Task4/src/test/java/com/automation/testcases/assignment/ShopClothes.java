package com.automation.testcases.assignment;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.pagelibrary.assignment.HomePage;
import com.automation.testutilities.TestBase;


public class ShopClothes extends TestBase {
	HomePage homepage;

	public ShopClothes() {
		super();
	}

	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homepage=new HomePage();
	}
	
	
	@Test(priority=1,description="Verify summer dress can be added to cart and not possible to proceed to sign in section")
	public void addSummerdressToCart() {
		Assert.assertTrue(homepage.verifyDressesBtnDisplayed());
		Assert.assertTrue(homepage.verifySummerDressesBtnDisplayed());
		homepage.clickSummerDressesBtn();
		Assert.assertTrue(homepage.verifySummerDressesProductDisplayed());
		Assert.assertEquals(homepage.getDressesCount().size(), 3);
		Assert.assertTrue(homepage.verifySAddToCartBtnDisplayed());
		homepage.addSummerDressToCart();
		Assert.assertTrue(homepage.verifyAddToCartWindowDisplayed());
		Assert.assertTrue(homepage.verifyAddedToCartSuccessfullMsgDisplayed());
		homepage.verifySignInBtnNotClickable();

	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
