package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class DemoQaSteps  {
    WebDriver driver = new ChromeDriver();
    DemoPage demoPage = new DemoPage(driver);
    TextBoxPage textBoxPage = new TextBoxPage(driver);
    DemoElementsPage demoElementsPage = new DemoElementsPage(driver);
    CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
    WebTablesPage webTablesPage = new WebTablesPage(driver);
    PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
    FormsPage formsPage = new FormsPage(driver);
    ButtonsPage buttonsPage = new ButtonsPage(driver);
    WidgetsPage widgetsPage = new WidgetsPage(driver);
    SliderPage sliderPage = new SliderPage(driver);
    AutoCompletePage autoCompletePage = new AutoCompletePage(driver);
    MenuPage menuPage = new MenuPage(driver);
    SelectMenuButtonPage selectMenuButtonPage = new SelectMenuButtonPage(driver);
    InteractionsPage interactionsPage = new InteractionsPage(driver);
    DroppablePage droppablePage = new DroppablePage(driver);

    @Before("not @apiTests")
    public void maxPage() {
        driver.manage().window().maximize();
    }
    @After("not @apiTests")
    public void closePage() {
        driver.quit();
    }

    @Given("You are on the demoQa page")
    public void youAreOnTheDemoQaPage() {
        driver.get("https://demoqa.com/");

    }

    @Given("User Clicks on Text box")
    public void clickOnTheTextBoxLink() {
        demoPage.clickOnElelments();
        demoElementsPage.clickTextBoxLink();
    }

    @And("Complete the full name field with {string} and the email field with {string}")
    public void completeTheFullNameFieldWithAndTheEmailFieldWith(String fullName, String email) {
        textBoxPage.setFullNameField(fullName);
        textBoxPage.setEmailField(email);
    }


    @And("Complete the current address with {string} and  the permanent address with {string}")
    public void completeTheCurrentAddressWithAndThePermanentAddressWith(String currentAddress, String permanentAddress) {
        textBoxPage.setCurrentAddressField(currentAddress);
        textBoxPage.setPermanentAddressField(permanentAddress);
    }


    @When("Click the Submit button")
    public void clickTheSubmitButton() {
        textBoxPage.clickSubmitButton();
    }


    @Then("The information field will be displayed")
    public void theInformationFieldWillBeDisplayed() {
        textBoxPage.checkInfoBox();
    }
//Test 2

    @Given("Click on Check box")
    public void clickOnCheckBox() {
        demoPage.clickOnElelments();
        demoElementsPage.clickCheckBox();
    }

    @And("Click on expand all button")
    public void clickOnExpandAllButton() {
        checkBoxPage.clickExpandButton();
    }

    @When("Select React, Angular,Veu")
    public void selectReactAngularVeu() throws InterruptedException {
        checkBoxPage.clickTheCheckBoxes();
    }

    @Then("The specific select message should be displayed")
    public void theSpecificSelectMessageShouldBeDisplayed() {
        checkBoxPage.checkResultForm("You have selected :\n" + "workspace\n" + "react\n" + "angular\n" + "veu");
    }

    //test 3
    @Given("Click web tables")
    public void clickWebTables() {
        demoPage.clickOnElelments();
        demoElementsPage.clickWebTables();
    }

    @And("Click Add button")
    public void clickAddButton() {
        webTablesPage.clickAddButton();
    }

    @And("Fill the Registration form")
    public void fillTheRegistrationForm() {
        webTablesPage.setFirstNameField("Jonny");
        webTablesPage.setLastNameField("Mellow");
        webTablesPage.setEmailField("jonny@gmail.com");
        webTablesPage.setAgeField("50");
        webTablesPage.setSalaryField("5000");
        webTablesPage.setDepartmentField("first department");
    }

    @And("Click the Submit")
    public void clickTheSubmit() throws InterruptedException {
        webTablesPage.clickSubmitButton();
    }

    @When("Search for  the new person in the table")
    public void searchForTheNewPersonInTheTable() {
        webTablesPage.searchFieldFindJonny("Jonny");
    }

    @Then("Check if the registration was a success")
    public void checkIfTheRegistrationWasASuccess() {
        webTablesPage.checkToFindJonny();
    }


    //test 4
    @Given("Click on practice form")
    public void clickOnPracticeForm() {
        demoPage.clickFormLink();
        formsPage.clickPracticeForm();

    }


    @And("Fill out the register form")
    public void fillOutTheRegisterForm() throws InterruptedException {
        practiceFormPage.setFirstNameField("Jonny");
        practiceFormPage.setLastNameField("Boy");
        practiceFormPage.setEmailField("jonnyboy@gmds.com");
        practiceFormPage.selectMaleCheckBox();
        practiceFormPage.setPhoneNumberField("1234567890");
        practiceFormPage.checkDate();
        practiceFormPage.setSubjectField("English");
        practiceFormPage.chooseHobbies();
        practiceFormPage.chooseProfilePic();
        practiceFormPage.setCurrentAddressField("ceva adressa acolo mnoo");
        practiceFormPage.selectStateAndCity();
    }

    @When("Click submit button")
    public void clickSubmitButton() {
        practiceFormPage.clickSubmitButton();
    }

    @Then("Check the Thanks message")
    public void checkTheThanksMessage() {
        practiceFormPage.checkThanksText();
    }

    // test 5
    @Given("Click on the Buttons btn")
    public void clickOnTheButtonsBtn() {
        demoPage.clickOnElelments();
        demoElementsPage.clickButtonsButton();
    }

    @When("Double click the Double Click Me button")
    public void doubleClickTheDoubleClickMeButton() throws InterruptedException {
        Thread.sleep(2000);
        buttonsPage.doubleClick();
    }

    @Then("Check for the double click message")
    public void checkForTheDoubleClickMessage() {
        buttonsPage.checkDoubleClickMessage("You have done a double click");
    }

    //test6
    @Given("Click on Widgets link")
    public void clickOnWidgetsLink() {
        demoPage.clickWidgetsLink();
        widgetsPage.clickSliderButton();
    }


    @When("Move the slider at 50")
    public void moveTheSliderAt()  {
        sliderPage.sliderMove();
    }

    @Then("Check  for the number 50")
    public void checkForTheNumber() {
        sliderPage.checkResult();
    }

    //test 7
    @Given("Click on Auto complete in widgets")
    public void clickOnAutoCompleteInWidgets() {
        demoPage.clickWidgetsLink();
        widgetsPage.clickAutoCompleteButton();
    }

    @When("Fill the Type multiple color field with {string} and {string}")
    public void fillTheTypeMultipleColorFieldWithAnd(String colorRed, String colorYellow) {
        autoCompletePage.setMultipleColorsField(colorRed, colorYellow);

    }

    @And("Fill theType single color field with {string}")
    public void fillTheTypeSingleColorFieldWith(String colorBlue) {
        autoCompletePage.setSingleColorsField(colorBlue);
    }

    @Then("Check the field for the colors")
    public void checkTheFieldForTheColors() {
        autoCompletePage.checkFields();
    }

    //test 8
    @Given("Click on Menu button")
    public void clickOnMenuButton() {
        demoPage.clickWidgetsLink();
        widgetsPage.clickMenuButton();
    }

    @When("Hover over main item 2")
    public void hoverOverMainItem() {
        menuPage.hoverOverMainItem2();
    }

    @And("Hover over SUB SUB LIST")
    public void hoverOverSUBSUBLIST() {
        menuPage.hoverToSubSubList();
    }

    @Then("Make sure Sub Sub item 2 is displayed")
    public void makeSureSubSubItemIsDisplayed() {
        menuPage.checkIfSubSubItemIsDisplayed();
    }

    //test 9
    @Given("Click on Select menu button")
    public void clickOnSelectMenuButton() {
        demoPage.clickWidgetsLink();
        widgetsPage.clickSelectMenuButton();
    }

    @When("Complete all the fields")
    public void completeAllTheFields() throws InterruptedException {
        selectMenuButtonPage.selectValue("Group 2, option 2");
        selectMenuButtonPage.selectOneGender();
        selectMenuButtonPage.pickSingleColor("Yellow");
        selectMenuButtonPage.selectTheColors("Red", "Blue");
        selectMenuButtonPage.pickSingleCar("Volvo");
    }

    @Then("Check select field for to have {string} and old style menu to have the color {string}")
    public void checkSelectFieldForToHaveAndOldStyleMenuToHaveTheColor(String selectValue, String colorMenu) {
        selectMenuButtonPage.checkValue(selectValue);
        selectMenuButtonPage.checkColorMenu(colorMenu);
    }

    @Given("Click on droppable button")
    public void clickOnDroppableButton() {
        demoPage.clickInteractionsLink();
        interactionsPage.clickDroppableButton();
    }

    @When("Drag the drag me box in the Drop here box")
    public void dragTheDragMeBoxInTheDropHereBox() {
        droppablePage.dragElementToDropPoint();
    }

    @Then("Check for the draggable to hover over the box")
    public void checkForTheDraggableToHoverOverTheBox() {
        droppablePage.checkIfDropped();
    }

}