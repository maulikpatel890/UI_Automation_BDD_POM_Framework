package pages;

import base.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import util.TestUtils;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class PointTablePage extends BaseClass {

    public PointTablePage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,
                BaseClass.defaultTimeout), this);
    }

    public static final String pointTable_tagName = "table";
    public static final String pointTableBody_tagName = "tbody";
    public static final String pointTableRow_tagName = "tr";
    public static final String pointTableColumn_tagName = "td";

    public List<WebElement> totalRowsList;
    public WebElement getTableBody;
    public List<WebElement> totalColumnsList;
    public WebElement teamName;


    @WithTimeout(time = BaseClass.defaultTimeout, chronoUnit = ChronoUnit.SECONDS)
    @FindBy(tagName=pointTable_tagName)
    public WebElement pointTable;




}
