package FunctionalTests.Pages;

import org.openqa.selenium.By;

// * Created for W-xmlm by Fill on 12.01.2015.
public class ProductsFamilyPage extends AuthorizedUserPage {
    public static final By investmentPackagesItem = By.xpath("//a[contains(text(), '  Investment packages')]");
    public static final By itProductsItem = By.xpath("//a[contains(text(), '  IT products')]");
    public static final By servicesItem = By.xpath("//a[contains(text(), '  Services')]");
    public static final By trainingItem = By.xpath("//a[contains(text(), '  Training')]");
    public static final By purchasesItem = By.xpath("//a[contains(text(), '  Purchases')]");
}