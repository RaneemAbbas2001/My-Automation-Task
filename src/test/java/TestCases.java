import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class TestCases {

    WebDriver driver ;

    private void verifyHomePageDisplayed() {
        WebElement homeImage = driver.findElement(By.xpath("//*[@id=\"slider-carousel\"]/div"));
        Assert.assertTrue(homeImage.isDisplayed(), "Home page is not displayed");
    }
    private void fillDataForNewUserSignUp() throws InterruptedException {
        WebElement titleCheckBox= driver.findElement(By.id("id_gender2"));
        titleCheckBox.click();
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("brand");

        WebElement dayDropdown = driver.findElement(By.id("days"));
        Select daySelect = new Select(dayDropdown);
        daySelect.selectByValue("19");

        WebElement monthDropdown = driver.findElement(By.id("months"));
        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByVisibleText("May");

        WebElement yearDropdown = driver.findElement(By.id("years"));
        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByValue("2001");

        WebElement newLetterChBox = driver.findElement(By.id("newsletter"));
        newLetterChBox.click();

        WebElement Receive_specialChBox = driver.findElement(By.id("optin"));
        Receive_specialChBox.click();

        WebElement First_name= driver.findElement(By.id("first_name"));
        First_name.sendKeys("Tester R");

        WebElement Last_name = driver.findElement(By.id("last_name"));
        Last_name.sendKeys("QC ENG");

        WebElement Company = driver.findElement(By.id("company"));
        Company.sendKeys("GBG");

        WebElement Address = driver.findElement(By.id("address1"));
        Address.sendKeys("19 street canada");

        WebElement Address2 = driver.findElement(By.id("address2"));
        Address2.sendKeys("street x");

        WebElement CountryDropdown = driver.findElement(By.id("country"));
        Select CountrySelect = new Select(CountryDropdown);
        CountrySelect.selectByValue("Canada");

        WebElement State = driver.findElement(By.id("state"));
        State.sendKeys("state y");

        WebElement City = driver.findElement(By.id("city"));
        City.sendKeys("canada c");

        WebElement Zipcode = driver.findElement(By.id("zipcode"));
        Zipcode.sendKeys("024400");

        WebElement Mobile_Number = driver.findElement(By.id("mobile_number"));
        Mobile_Number.sendKeys("11023990");

        WebElement create_accBTN = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
        create_accBTN.submit();

        Thread.sleep(3000);
    }
    private void userLogIn() throws InterruptedException {
        WebElement email = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"));
        email.sendKeys("globaaaalllll@groupppp.com");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"));
        password.sendKeys("brand");

        WebElement logInBTN = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
        logInBTN.submit();
        Thread.sleep(3000);
    }
    private void deleteAndVerifyDeleting() throws InterruptedException {
        WebElement Delete_accountBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        Delete_accountBTN.click();
        Thread.sleep(3000);
        WebElement ACCOUNT_DELETED = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        Assert.assertTrue(ACCOUNT_DELETED.isDisplayed(), "Sentence is not displayed");
    }
    private void checkOutData() throws InterruptedException {
        WebElement Address_DetailsDisplayed = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[2]/h2"));
        Assert.assertTrue(Address_DetailsDisplayed.isDisplayed(), "Address Details is not displayed");

        WebElement Review_Your_OrderDisplayed = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[4]/h2"));
        Assert.assertTrue(Review_Your_OrderDisplayed.isDisplayed(), "Review Your Order is not displayed");

        WebElement description = driver.findElement(By.xpath("//*[@id=\"ordermsg\"]/textarea"));
        description.sendKeys("The orders are awesome");

        WebElement Place_OrderBTN = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a"));
        Place_OrderBTN.click();
        Thread.sleep(2000);

        WebElement Name_on_Card = driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[1]/div/input"));
        Name_on_Card.sendKeys("Alex");

        WebElement Card_Number = driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[2]/div/input"));
        Card_Number.sendKeys("55488999");

        WebElement CVC = driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[1]/input"));
        CVC.sendKeys("311");

        WebElement ExpirationMonth = driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[2]/input"));
        ExpirationMonth.sendKeys("02");

        WebElement ExpirationYear = driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[3]/input"));
        ExpirationYear.sendKeys("2023");

        WebElement Pay_Confirm_OrderBTN = driver.findElement(By.id("submit"));
        Pay_Confirm_OrderBTN.submit();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement successMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.alert-success.alert")));
        String successMessage = successMessageElement.getText();
        String expectedMessage = "Your order has been placed successfully!";
        if (successMessage.equals(expectedMessage)) {
            System.out.println("Success message is verified: " + successMessage);
        } else {
            System.out.println("Message does not match. Found: " + successMessage);
        }
    }
    private void addProducts() throws InterruptedException {
        WebElement addProduct1 = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a"));
        addProduct1.click();
        Thread.sleep(3000);
        WebElement modalcontinueBTN = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button"));
        modalcontinueBTN.click();

        WebElement addProduct2 = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[3]/div/div[1]/div[1]/a"));
        addProduct2.click();
        Thread.sleep(3000);
        modalcontinueBTN.click();

        WebElement addProduct3 = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[4]/div/div[1]/div[1]/a"));
        addProduct3.click();
        Thread.sleep(3000);
        modalcontinueBTN.click();
    }



    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC1_RegUser() throws InterruptedException {
        verifyHomePageDisplayed();

        WebElement Signup_LoginBTN= driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        Signup_LoginBTN.click();

        WebElement New_User_Signup = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
        Assert.assertTrue(New_User_Signup.isDisplayed(), "Sentence is not displayed");

        WebElement name= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        name.sendKeys("tstttttttttttt");
        WebElement email= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        email.sendKeys("globaaaalllll@groupppp.com");
        WebElement SignupBTN= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        SignupBTN.submit();
        Thread.sleep(3000);

        WebElement ENTER_ACCOUNT_INFORMATION = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b"));
        Assert.assertTrue(ENTER_ACCOUNT_INFORMATION.isDisplayed(), "Sentence is not displayed");

        fillDataForNewUserSignUp();

        WebElement ACCOUNT_CREATED = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        Assert.assertTrue(ACCOUNT_CREATED.isDisplayed(), "Sentence is not displayed");

        WebElement formcontinueBTN = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        formcontinueBTN.click();
        Thread.sleep(3000);

        WebElement logged_In = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        Assert.assertTrue(logged_In.isDisplayed(), "Sentence is not displayed");

        deleteAndVerifyDeleting();
        WebElement contiueButton= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        contiueButton.click();
    }

    @Test
    public void TC2_Login_User_with_Correct_Email_password() throws InterruptedException {
        verifyHomePageDisplayed();

        WebElement Signup_LoginBTN= driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        Signup_LoginBTN.click();

        WebElement Login_to_your_account = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
        Assert.assertTrue(Login_to_your_account.isDisplayed(), "Sentence is not displayed");

        userLogIn();
        WebElement logged_In = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        Assert.assertTrue(logged_In.isDisplayed(), "Sentence is not displayed");
        deleteAndVerifyDeleting();
    }

    @Test
    public void TC3_Login_User_with_incorrect_email_password() throws InterruptedException {
        verifyHomePageDisplayed();

        WebElement Signup_LoginBTN= driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        Signup_LoginBTN.click();

        WebElement Login_to_your_account = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
        Assert.assertTrue(Login_to_your_account.isDisplayed(), "Image is not displayed");
        userLogIn();

        WebElement Your_email_or_password_is_incorrect = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/p"));
        Assert.assertTrue(Your_email_or_password_is_incorrect.isDisplayed(), "Sentence is not displayed");

    }

    @Test
    public void TC4_Logout_User() throws InterruptedException {
        verifyHomePageDisplayed();

        WebElement Signup_LoginBTN= driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        Signup_LoginBTN.click();
        userLogIn();

        WebElement logged_In = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        Assert.assertTrue(logged_In.isDisplayed(), "Sentence is not displayed");

        WebElement logOutBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        logOutBTN.click();

        WebElement New_User_Signup = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
        Assert.assertTrue(New_User_Signup.isDisplayed(), "Sentence is not displayed");
    }

    @Test
    public void TC5_Register_User_with_existing_email() throws InterruptedException {

        verifyHomePageDisplayed();

        WebElement Signup_LoginBTN= driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        Signup_LoginBTN.click();

        WebElement New_User_Signup = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
        Assert.assertTrue(New_User_Signup.isDisplayed(), "Sentence is not displayed");

        WebElement name= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        name.sendKeys("tstttttttttttt");
        WebElement email= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        email.sendKeys("globaaaalllll@groupppp.com");
        WebElement SignupBTN= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        SignupBTN.submit();

        WebElement Email_Address_already_exist = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p"));
        Assert.assertTrue(Email_Address_already_exist.isDisplayed(), "Sentence is not displayed");

    }

    @Test
    public void TC6_Contact_Us_Form(){
        verifyHomePageDisplayed();

        WebElement Contact_UsBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a"));
        Contact_UsBTN.click();

        WebElement GET_IN_TOUCH = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2"));
        Assert.assertTrue(GET_IN_TOUCH.isDisplayed(), "Sentence is not displayed");

        WebElement name = driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input"));
        name.sendKeys("tester");

        WebElement email = driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input"));
        email.sendKeys("r@gmail.com");

        WebElement subject = driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input"));
        subject.sendKeys("feedback");

        WebElement message = driver.findElement(By.xpath("//*[@id=\"message\"]"));
        message.sendKeys("testing is awesome");

        WebElement file = driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input"));
        String filePath= "C:/Users/ranee/Downloads/testtttttttttttttttttttttttt.docx";
        file.sendKeys(filePath);

        WebElement submitBTN = driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input"));
        submitBTN.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement success_message = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]"));
        Assert.assertTrue(success_message.isDisplayed(), "Sentence is not displayed");

        WebElement homeBTN = driver.findElement(By.xpath("//*[@id=\"form-section\"]/a"));
        homeBTN.click();
        verifyHomePageDisplayed();
    }

    @Test
    public void TC7_Verify_Test_Cases_Page(){
        verifyHomePageDisplayed();

        WebElement testcasesBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        testcasesBTN.click();

        WebElement testCaseDisplayed = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2/b"));
        Assert.assertTrue(testCaseDisplayed.isDisplayed(), "Image is not displayed");
    }

    @Test
    public void TC8_Verify_All_Products_and_product_detail_page(){
        verifyHomePageDisplayed();

        WebElement productsBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
        productsBTN.click();

        WebElement saleImage = driver.findElement(By.cssSelector("img[alt='Website for practice']"));
        Assert.assertTrue(saleImage.isDisplayed(), "Image is not displayed");

        WebElement productList = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div"));
        Assert.assertTrue(productList.isDisplayed(), "list is not displayed");

        WebElement firstProductBTN = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a"));
        firstProductBTN.click();

        WebElement product_name = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2"));
        Assert.assertTrue(product_name.isDisplayed(), "product name is not displayed");

        WebElement category = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]"));
        Assert.assertTrue(category.isDisplayed(), "category is not displayed");

        WebElement price = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span"));
        Assert.assertTrue(price.isDisplayed(), "price is not displayed");

        WebElement availability = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]"));
        Assert.assertTrue(availability.isDisplayed(), "availability is not displayed");

        WebElement condition = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]"));
        Assert.assertTrue(condition.isDisplayed(), "condition is not displayed");

        WebElement brand = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]"));
        Assert.assertTrue(brand.isDisplayed(), "brand is not displayed");
    }

    @Test
    public void TC9_Search_Product(){
        verifyHomePageDisplayed();

        WebElement productsBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
        productsBTN.click();

        WebElement saleImage = driver.findElement(By.cssSelector("img[alt='Website for practice']"));
        Assert.assertTrue(saleImage.isDisplayed(), "Image is not displayed");

        WebElement searchField = driver.findElement(By.id("search_product"));
        searchField.sendKeys("Stylish Dress");

        WebElement searchIcon = driver.findElement(By.id("submit_search"));
        searchIcon.click();

        WebElement searchProductsDisplayed = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/h2"));
        Assert.assertTrue(searchProductsDisplayed.isDisplayed(), "Sentence is not displayed");

        WebElement allProductsDisplayed = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]"));
        Assert.assertTrue(allProductsDisplayed.isDisplayed(), "All Products are not displayed");

    }

    @Test
    public void TC10_Verify_Subscription_in_home_page(){
        verifyHomePageDisplayed();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement SUBSCRIPTIONDisplayed = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2"));
        Assert.assertTrue(SUBSCRIPTIONDisplayed.isDisplayed(), "Sentence is not displayed");

        WebElement subscribeField = driver.findElement(By.id("susbscribe_email"));
        subscribeField.sendKeys("r@gmail.com");

        WebElement arrowBTN = driver.findElement(By.id("subscribe"));
        arrowBTN.click();

        WebElement successMessDisplayed = driver.findElement(By.xpath("//*[@id=\"success-subscribe\"]/div"));
        Assert.assertTrue(successMessDisplayed.isDisplayed(), "Sentence is not displayed");
    }

    @Test
    public void TC11_Verify_Subscription_in_Cart_page(){
        verifyHomePageDisplayed();

        WebElement cartBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a"));
        cartBTN.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement SUBSCRIPTIONDisplayed = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2"));
        Assert.assertTrue(SUBSCRIPTIONDisplayed.isDisplayed(), "Sentence is not displayed");

        WebElement subscribeField = driver.findElement(By.id("susbscribe_email"));
        subscribeField.sendKeys("r@gmail.com");

        WebElement arrowBTN = driver.findElement(By.id("subscribe"));
        arrowBTN.click();

        WebElement successMessDisplayed = driver.findElement(By.xpath("//*[@id=\"success-subscribe\"]/div"));
        Assert.assertTrue(successMessDisplayed.isDisplayed(), "Sentence is not displayed");
    }

    @Test
    public void TC12_Add_Products_in_Cart() throws InterruptedException {
        verifyHomePageDisplayed();

        WebElement productsBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
        productsBTN.click();

        WebElement firstProductHover = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstProductHover).perform();

        WebElement addCartBTN= driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a"));
        addCartBTN.click();

        Thread.sleep(3000);

        WebElement modalcontinueBTN = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button"));
        modalcontinueBTN.click();

        WebElement secondProductHover = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[3]/div"));
        actions.moveToElement(secondProductHover).perform();

        WebElement addCartBTN2= driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a"));
        addCartBTN2.click();

        Thread.sleep(3000);
        WebElement viewCartBTN = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"));
        viewCartBTN.click();

        WebElement product1 = driver.findElement(By.xpath("//*[@id=\"product-1\"]"));
        Assert.assertTrue(product1.isDisplayed(), "First product is not displayed");

        WebElement product2 = driver.findElement(By.xpath("//*[@id=\"product-2\"]"));
        Assert.assertTrue(product2.isDisplayed(), "Second product is not displayed");

        WebElement productPrice1=driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[3]/p"));
        WebElement productQuantity1=driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[4]/button"));
        WebElement productTotalPrice1=driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[5]/p"));

        WebElement productPrice2=driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[3]/p"));
        WebElement productQuantity2=driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[4]/button"));
        WebElement productTotalPrice2=driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[5]/p"));

        Assert.assertTrue(productPrice1.isDisplayed(), "First product price is not displayed");
        Assert.assertTrue(productQuantity1.isDisplayed(), "First product quantity is not displayed");
        Assert.assertTrue(productTotalPrice1.isDisplayed(), "First product total price is not displayed");

        Assert.assertTrue(productPrice2.isDisplayed(), "Second product price is not displayed");
        Assert.assertTrue(productQuantity2.isDisplayed(), "Second product quantity is not displayed");
        Assert.assertTrue(productTotalPrice2.isDisplayed(), "Second product total price is not displayed");
    }

    @Test
    public void TC13_Verify_Product_quantity_in_Cart() throws InterruptedException {
        verifyHomePageDisplayed();

        WebElement viewProductBTN = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[4]/div/div[2]/ul/li/a"));
        viewProductBTN.click();

        WebElement ProductName = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2"));
        Assert.assertTrue(ProductName.isDisplayed(),"Product is not displayed");

        WebElement increasedQuantity = driver.findElement(By.id("quantity"));
        increasedQuantity.clear();
        increasedQuantity.sendKeys("4");

        Thread.sleep(2000);
        WebElement addBTN = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button"));
        addBTN.click();

        Thread.sleep(3000);
        WebElement viewCartBTN = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"));
        viewCartBTN.click();

        WebElement addedProductName = driver.findElement(By.xpath("//*[@id=\"product-3\"]/td[2]/h4/a"));
        Assert.assertTrue(addedProductName.isDisplayed(),"Product is not displayed");

        WebElement addedProductQuantity = driver.findElement(By.xpath("//*[@id=\"product-3\"]/td[4]/button"));
        Assert.assertEquals(addedProductQuantity.getText(),"4","Quantity mismatch");
    }

    @Test
    public void TC14_Place_Order_Register_while_Checkout() throws InterruptedException {
        verifyHomePageDisplayed();
        addProducts();
        Thread.sleep(3000);

        WebElement headercartBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a"));
        headercartBTN.click();

        WebElement cartDisplayed = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]"));
        Assert.assertTrue(cartDisplayed.isDisplayed(), "Sentence is not displayed");

        WebElement Proceed_To_CheckoutBTN = driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a"));
        Proceed_To_CheckoutBTN.click();

        Thread.sleep(3000);
        WebElement RegisterLoginBTN = driver.findElement(By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u"));
        RegisterLoginBTN.click();

        WebElement name = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        name.sendKeys("qcENG");
        WebElement email = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        email.sendKeys("gg@glllbal.com");
        WebElement SignupBTN = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        SignupBTN.submit();

        fillDataForNewUserSignUp();

        WebElement ACCOUNT_CREATED = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        Assert.assertTrue(ACCOUNT_CREATED.isDisplayed(), "Sentence is not displayed");

        WebElement formcontinueBTN = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        formcontinueBTN.click();
        Thread.sleep(3000);

        WebElement logged_In = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        Assert.assertTrue(logged_In.isDisplayed(), "Sentence is not displayed");

        WebElement headercartBTN2 = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a"));
        headercartBTN2.click();

        Thread.sleep(2000);

        WebElement Proceed_To_CheckoutBTN2 = driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a"));
        Proceed_To_CheckoutBTN2.click();
        checkOutData();
        WebElement formcontinueBTN2 = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        formcontinueBTN2.click();

        deleteAndVerifyDeleting();

        WebElement formcontinueBTN3 = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        formcontinueBTN3.click();
    }

    @Test
    public void TC15_Order_Register_before_Checkout() throws InterruptedException {
        verifyHomePageDisplayed();

        WebElement RegisterLoginBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        RegisterLoginBTN.click();

        WebElement name = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        name.sendKeys("qcENG");
        WebElement email = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        email.sendKeys("qcENEG@NG.com");
        WebElement SignupBTN = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        SignupBTN.submit();

        fillDataForNewUserSignUp();

        WebElement ACCOUNT_CREATED = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        Assert.assertTrue(ACCOUNT_CREATED.isDisplayed(), "Sentence is not displayed");

        WebElement formcontinueBTN = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        formcontinueBTN.click();
        Thread.sleep(3000);

        WebElement logged_In = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        Assert.assertTrue(logged_In.isDisplayed(), "Sentence is not displayed");

        addProducts();

        Thread.sleep(3000);

        WebElement headercartBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a"));
        headercartBTN.click();

        WebElement cartDisplayed = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]"));
        Assert.assertTrue(cartDisplayed.isDisplayed(), "Sentence is not displayed");

        Thread.sleep(2000);

        WebElement Proceed_To_CheckoutBTN = driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a"));
        Proceed_To_CheckoutBTN.click();

        checkOutData();
        deleteAndVerifyDeleting();

        WebElement formcontinueBTN2 = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        formcontinueBTN2.click();
    }

    @Test
    public void TC16_Place_Order_Login_before_Checkout() throws InterruptedException {
        verifyHomePageDisplayed();

        WebElement RegisterLoginBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        RegisterLoginBTN.click();

        WebElement Login_to_your_account = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
        Assert.assertTrue(Login_to_your_account.isDisplayed(), "Sentence is not displayed");

        Thread.sleep(2000);
        userLogIn();

        WebElement logged_In = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        Assert.assertTrue(logged_In.isDisplayed(), "Sentence is not displayed");

        addProducts();

        Thread.sleep(3000);

        WebElement headercartBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a"));
        headercartBTN.click();

        WebElement cartDisplayed = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]"));
        Assert.assertTrue(cartDisplayed.isDisplayed(), "Sentence is not displayed");

        Thread.sleep(2000);

        WebElement Proceed_To_CheckoutBTN = driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a"));
        Proceed_To_CheckoutBTN.click();

        checkOutData();
        deleteAndVerifyDeleting();

        WebElement formcontinueBTN = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        formcontinueBTN.click();

    }

    @Test
    public void TC17_Remove_Products_From_Cart() throws InterruptedException {
        verifyHomePageDisplayed();
        addProducts();
        Thread.sleep(3000);

        WebElement headercartBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a"));
        headercartBTN.click();

        WebElement cartDisplayed = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]"));
        Assert.assertTrue(cartDisplayed.isDisplayed(), "Cart is not displayed");

        WebElement removeButton = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[6]/a"));
        removeButton.click();
        Thread.sleep(3000);

        List<WebElement> productElements = driver.findElements(By.xpath("//*[@id=\"product-2\"]/td[2]/h4/a"));
        Assert.assertTrue(productElements.isEmpty(), "Product is still displayed");
    }

    @Test
    public void TC18_View_Category_Products() throws InterruptedException {

        WebElement categoryDisplayed = driver.findElement(By.xpath("//*[@id='accordian']"));
        Assert.assertTrue(categoryDisplayed.isDisplayed(), "Category section is not displayed");

        WebElement categoryElement = driver.findElement(By.xpath("/html/body/section[2]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", categoryElement);
        Thread.sleep(1000);

        WebElement womenBTN = driver.findElement(By.xpath("//*[@id='accordian']/div[1]/div[1]/h4/a"));
        womenBTN.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement topsBTN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Women\"]/div/ul/li[2]/a")));
        topsBTN.click();

        WebElement categoryPageDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ol/li[contains(text(),'Women')]")));
        Assert.assertTrue(categoryPageDisplayed.isDisplayed(), "Category page is not displayed");

        WebElement womenTopsProductsText = driver.findElement(By.xpath("//div[@class='features_items']/h2"));
        Assert.assertEquals(womenTopsProductsText.getText().trim(), "WOMEN - TOPS PRODUCTS", "Incorrect category text displayed");

        WebElement menBTN = driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a"));
        menBTN.click();

        WebElement tShirtsBTN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Men\"]/div/ul/li[1]/a")));
        tShirtsBTN.click();

        WebElement menT_shirtsProductsText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2")));
        Assert.assertEquals(menT_shirtsProductsText.getText().trim(), "MEN - TSHIRTS PRODUCTS", "Incorrect category text displayed");
    }

    @Test
    public void TC19_View_Cart_Brand_Products() throws InterruptedException {
        WebElement ProductsBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
        ProductsBTN.click();
        Thread.sleep(2000);

        WebElement brandElement = driver.findElement(By.xpath("/html/body/section[2]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", brandElement);
        Thread.sleep(1000);


        WebElement brandsDisplayed = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[1]/div[1]/div[3]"));
        Assert.assertTrue(brandsDisplayed.isDisplayed(), "brands is not displayed");
        Thread.sleep(1000);

        WebElement poloBrandBTN = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[1]/div[1]/div[3]/div/ul/li[1]/a"));
        poloBrandBTN.click();
        Thread.sleep(1000);

        WebElement allbrandsDisplayed = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div"));
        Assert.assertTrue(allbrandsDisplayed.isDisplayed(), "all brands are not displayed");

        WebElement h_mBrandBTN = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div[1]/div[2]/div/ul/li[2]/a"));
        h_mBrandBTN.click();

        WebElement newBrandsDisplayed = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div"));
        Assert.assertTrue(newBrandsDisplayed.isDisplayed(), "all brands are not displayed");
    }

    @Test
    public void TC20_Search_Products_and_Verify_Cart_After_Login() throws InterruptedException {
        WebElement ProductsBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
        ProductsBTN.click();

        WebElement allProductsDisplayed = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2"));
        Assert.assertTrue(allProductsDisplayed.isDisplayed(), "all Products is not displayed");

        WebElement searchField = driver.findElement(By.id("search_product"));
        searchField.sendKeys("Summer White Top");

        WebElement searchIcon = driver.findElement(By.id("submit_search"));
        searchIcon.click();

        WebElement searchedProductsDisplayed = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/h2"));
        Assert.assertTrue(searchedProductsDisplayed.isDisplayed(), "searched Products is not displayed");

        WebElement ProductsDisplayed = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div"));
        Assert.assertTrue(ProductsDisplayed.isDisplayed(), "Products is not displayed");

        WebElement addedProductBTN = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/a"));
        addedProductBTN.click();
        Thread.sleep(3000);

        WebElement modalcontinueBTN = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button"));
        modalcontinueBTN.click();

        WebElement headercartBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a"));
        headercartBTN.click();

        WebElement ProdDisplayed = driver.findElement(By.xpath("//*[@id=\"product-6\"]/td[2]/h4/a"));
        Assert.assertTrue(ProdDisplayed.isDisplayed(), "Products are not displayed");

        WebElement RegisterLoginBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        RegisterLoginBTN.click();

        WebElement Login_to_your_account = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
        Assert.assertTrue(Login_to_your_account.isDisplayed(), "Sentence is not displayed");
        userLogIn();
        Thread.sleep(3000);

        WebElement headercartBTN2 = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a"));
        headercartBTN2.click();

        WebElement ProdsDisplayed = driver.findElement(By.xpath("//*[@id=\"product-6\"]/td[2]/h4/a"));
        Assert.assertTrue(ProdsDisplayed.isDisplayed(), "Products are not displayed");
    }

    @Test
    public void TC21_Add_review_on_product(){
        WebElement ProductsBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
        ProductsBTN.click();

        WebElement allProductsDisplayed = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2"));
        Assert.assertTrue(allProductsDisplayed.isDisplayed(), "all Products is not displayed");

        WebElement scroll = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", scroll);

        WebElement viewProductBTN = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[4]/div/div[2]/ul/li/a"));
        viewProductBTN.click();

        WebElement WriteYourReviewDisplayed = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2"));
        Assert.assertTrue(WriteYourReviewDisplayed.isDisplayed(), "Write Your Review is not displayed");

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("customer");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("r@gmail.com");

        WebElement review = driver.findElement(By.id("review"));
        review.sendKeys("r@gmail.com");

        WebElement submitBTN = driver.findElement(By.id("button-review"));
        submitBTN.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"review-section\"]/div/div")));
        WebElement messageSpan = successMessage.findElement(By.tagName("span"));
        String expectedMessage = messageSpan.getText();
        Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed");
        Assert.assertEquals(successMessage.getText(), expectedMessage, "Unexpected success message text");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"review-section\"]/div/div")));
    }

    @Test
    public void TC22_Add_to_cart_from_Recommended_items() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(547.5, document.body.scrollHeight)");

        WebElement RECOMMENDED_ITEMS_Displayed = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[2]"));
        Assert.assertTrue(RECOMMENDED_ITEMS_Displayed.isDisplayed(), "RECOMMENDED ITEMS is not displayed");

        WebElement scroll = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[2]"));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView(true);", scroll);

        WebElement addCartRecommend= driver.findElement(By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[2]/div[2]/div/div/div/a"));
        addCartRecommend.click();
        Thread.sleep(3000);

        WebElement viewCartBTN = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"));
        viewCartBTN.click();

        WebElement itemDisplayed = driver.findElement(By.xpath("//*[@id=\"product-5\"]/td[2]/h4/a"));
        Assert.assertTrue(itemDisplayed.isDisplayed(), "item is not displayed");
    }

    @Test
    public void TC23_Verify_address_details_in_checkout_page() throws InterruptedException {
        verifyHomePageDisplayed();

        WebElement RegisterLoginBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        RegisterLoginBTN.click();

        WebElement name = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        name.sendKeys("qcENG");
        WebElement email = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        email.sendKeys("rgpp@lbl.com");
        WebElement SignupBTN = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        SignupBTN.submit();

        fillDataForNewUserSignUp();

        WebElement ACCOUNT_CREATED = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        Assert.assertTrue(ACCOUNT_CREATED.isDisplayed(), "Sentence is not displayed");

        WebElement formcontinueBTN = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        formcontinueBTN.click();
        Thread.sleep(3000);

        WebElement logged_In = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        Assert.assertTrue(logged_In.isDisplayed(), "Sentence is not displayed");

        WebElement add1itemBTN = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a"));
        add1itemBTN.click();
        Thread.sleep(3000);

        WebElement modalcontinueBTN = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button"));
        modalcontinueBTN.click();

        WebElement add2itemBTN = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[3]/div/div[1]/div[1]/a"));
        add2itemBTN.click();
        Thread.sleep(3000);

        WebElement modalcontinueBTN2 = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button"));
        modalcontinueBTN2.click();

        WebElement headercartBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a"));
        headercartBTN.click();

        WebElement cartDisplayed = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]"));
        Assert.assertTrue(cartDisplayed.isDisplayed(), "cart is not displayed");

        WebElement Proceed_To_CheckoutBTN = driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a"));
        Proceed_To_CheckoutBTN.click();

        WebElement displayedAddress1Atdelivery = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[4]"));
        String deliveryAddress1Text = displayedAddress1Atdelivery.getText();

        WebElement displayedAddress2Atdelivery = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[5]"));
        String deliveryAddress2Text = displayedAddress2Atdelivery.getText();

        boolean addressMatch = deliveryAddress1Text.equals("19 street canada") && deliveryAddress2Text.equals("street x");
        Assert.assertTrue(addressMatch, "Delivery address does not match registration address!");


        WebElement displayedAddress1Atbilling = driver.findElement(By.xpath("//*[@id=\"address_invoice\"]/li[4]"));
        String billingAddress1Text = displayedAddress1Atbilling.getText();

        WebElement displayedAddress2Atbilling = driver.findElement(By.xpath("//*[@id=\"address_invoice\"]/li[5]"));
        String billingAddress2Text = displayedAddress2Atbilling.getText();

        boolean addressMatch2 = billingAddress1Text.equals("19 street canada") && billingAddress2Text.equals("street x");
        Assert.assertTrue(addressMatch2, "billing address does not match registration address!");
        deleteAndVerifyDeleting();

        WebElement formcontinueBTN2 = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        formcontinueBTN2.click();

    }

    @Test
    public void TC24_Download_Invoice_after_purchase_order() throws InterruptedException {
        verifyHomePageDisplayed();
        addProducts();
        Thread.sleep(3000);

        WebElement headercartBTN = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a"));
        headercartBTN.click();

        WebElement cartDisplayed = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]"));
        Assert.assertTrue(cartDisplayed.isDisplayed(), "Sentence is not displayed");

        WebElement Proceed_To_CheckoutBTN = driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a"));
        Proceed_To_CheckoutBTN.click();

        Thread.sleep(3000);
        WebElement RegisterLoginBTN = driver.findElement(By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u"));
        RegisterLoginBTN.click();

        WebElement name = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        name.sendKeys("qcENG");
        WebElement email = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        email.sendKeys("rglobal@ggggoobl.com");
        WebElement SignupBTN = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        SignupBTN.submit();

        fillDataForNewUserSignUp();

        WebElement ACCOUNT_CREATED = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        Assert.assertTrue(ACCOUNT_CREATED.isDisplayed(), "Sentence is not displayed");

        WebElement formcontinueBTN = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        formcontinueBTN.click();

        WebElement logged_In = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        Assert.assertTrue(logged_In.isDisplayed(), "Sentence is not displayed");

        Thread.sleep(3000);

        WebElement headercartBTN2 = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a"));
        headercartBTN2.click();

        WebElement cartDisplayed2 = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]"));
        Assert.assertTrue(cartDisplayed2.isDisplayed(), "Sentence is not displayed");

        WebElement Proceed_To_CheckoutBTN2 = driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a"));
        Proceed_To_CheckoutBTN2.click();

        checkOutData();

        WebElement DownloadInvoicBTN = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/a"));
        DownloadInvoicBTN.click();

        WebElement formcontinueBTN2 = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        formcontinueBTN2.click();

        deleteAndVerifyDeleting();

        WebElement formcontinueBTN3 = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        formcontinueBTN3.click();
    }

    @Test
    public void TC25_Verify_Scroll_Up_using_Arrow_button_and_Scroll_Down_functionality() throws InterruptedException {
        verifyHomePageDisplayed();
        Thread.sleep(500);

        WebElement footerElement = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", footerElement);

        WebElement SUBSCRIPTIONDisplayed = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2"));
        Assert.assertTrue(SUBSCRIPTIONDisplayed.isDisplayed(), "Sentence is not displayed");
        Thread.sleep(1000);

        WebElement arrowUpBTN = driver.findElement(By.id("scrollUp"));
        arrowUpBTN.click();
        Thread.sleep(1000);

        WebElement FullFledgedpracticeDisplayed = driver.findElement(By.xpath("//*[@id=\"slider-carousel\"]/div/div[1]/div[1]/h2"));
        Assert.assertTrue(FullFledgedpracticeDisplayed.isDisplayed(), "Sentence is not displayed");
    }

    @Test
    public void TC26_Verify_Scroll_Up_without_Arrow_button_and_Scroll_Down_functionality() throws InterruptedException {
        verifyHomePageDisplayed();
        Thread.sleep(500);

        WebElement footerElement = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", footerElement);

        WebElement SUBSCRIPTIONDisplayed = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2"));
        Assert.assertTrue(SUBSCRIPTIONDisplayed.isDisplayed(), "Sentence is not displayed");
        Thread.sleep(2000);

        WebElement headerElement = driver.findElement(By.xpath("//*[@id=\"header\"]/div"));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView(true);", headerElement);
        Thread.sleep(1000);

        WebElement FullFledgedpracticeDisplayed = driver.findElement(By.xpath("//*[@id=\"slider-carousel\"]/div/div[1]/div[1]/h2"));
        Assert.assertTrue(FullFledgedpracticeDisplayed.isDisplayed(), "Sentence is not displayed");
    }

}

