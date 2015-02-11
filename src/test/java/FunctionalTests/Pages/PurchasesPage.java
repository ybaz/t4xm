package FunctionalTests.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// * Created for W-xmlm by Fill on 12.01.2015.
public class PurchasesPage extends ProductsFamilyPage {
    public static final By appDownloadButton = By.xpath("//a[@href='/products/installer/main/downloader/']");
    public static final By lastPurchaseRow = By.xpath("//table[@id='datatable2']/tbody/tr[1]");


    public PurchasesPage(WebDriver driver){super(driver);}

}
