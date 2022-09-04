package com.automation.pagelibrary.assignment;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.automation.testutilities.TestBase;


public class HomePage extends TestBase {
	
	By AddToCartBtn = By.xpath("//*[@id=\"center_column\"]/ul/li//span[contains(text(), \"Add to cart\")]");
	By SuccessfullMsg = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2");
	By DressesBtn = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]");
	By SummerDressesBtn = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Summer Dresses\")]");
	By SummerDressesProduct = By.xpath("//*[@id=\"center_column\"]/ul/li[1]");
	By AddedToCartWindow = By.xpath("//*[@id=\"layer_cart\"]");
	By SignInBtn = By.xpath("//a[contains(text(), \"Sign in\")]");
	By CreateAccountBtn = By.id("SubmitCreate");
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	

	public boolean verifyDressesBtnDisplayed(){
		
		return driver.findElement(DressesBtn).isDisplayed();
	}
	

	public boolean verifySummerDressesBtnDisplayed(){
		action.moveToElement(driver.findElement(DressesBtn)).build().perform();
		action.moveToElement(driver.findElement(SummerDressesBtn)).build().perform();
		return driver.findElement(SummerDressesBtn).isDisplayed();
	}
	

	public void clickSummerDressesBtn(){
		action.moveToElement(driver.findElement(DressesBtn)).build().perform();
		action.moveToElement(driver.findElement(SummerDressesBtn)).build().perform();
		driver.findElement(SummerDressesBtn).click();

	}
	

	public boolean verifySummerDressesProductDisplayed(){
		action.moveToElement(driver.findElement(DressesBtn)).build().perform();
		action.moveToElement(driver.findElement(SummerDressesBtn)).build().perform();
		return driver.findElement(SummerDressesProduct).isDisplayed();
	}
	

	public List<WebElement> getDressesCount() {
		return driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));	

	}
	

	public boolean verifySAddToCartBtnDisplayed(){
		action.moveToElement(driver.findElement(SummerDressesProduct)).build().perform();
		//action.moveToElement(driver.findElement(AddToCartBtn)).build().perform();
		return driver.findElement(AddToCartBtn).isDisplayed();
	}
	

	public void addSummerDressToCart(){
		action.moveToElement(driver.findElement(SummerDressesProduct)).build().perform();
		action.moveToElement(driver.findElement(AddToCartBtn)).build().perform();
		driver.findElement(AddToCartBtn).click();

	}
	

	public boolean verifyAddedToCartSuccessfullMsgDisplayed(){
		driver.findElement(SuccessfullMsg).click();
		return driver.findElement(SuccessfullMsg).isDisplayed();
	}
	

	public boolean verifyAddToCartWindowDisplayed(){
		driver.findElement(AddedToCartWindow).click();
		return driver.findElement(AddedToCartWindow).isDisplayed();
	}
	
	
	public void verifySignInBtnNotClickable() {
		try {
			action.moveToElement(driver.findElement(SignInBtn)).build().perform();
			driver.findElement(SignInBtn).click();
		}
		catch(Exception e) {
			System.out.println("Element isn't clickable with exception"+e);

		}
		
	}
	
}
