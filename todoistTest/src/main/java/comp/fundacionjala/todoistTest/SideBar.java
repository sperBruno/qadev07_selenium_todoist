package comp.fundacionjala.todoistTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBar  extends  BasePage{


    @FindBy(id = "filter_inbox")
    private WebElement btnInboxFilter;

    @FindBy(xpath = "//*[@id=\"project_list_man\"]/div[1]/a")
    private WebElement lnkAddProject;

    @FindBy(className = "submit_btn")
    private WebElement btnAddProject;

    @FindBy(className = "sel_richtext_editor")
    private WebElement txtProjectName;




    @FindBy(id = "menu_delete_text")
    private WebElement btnDeleteProjectContextOptionMenu;

    @FindBy(xpath = "//div[@id=\"GB_window\"]/descendant::span[text()=\"Ok\"]")
    private WebElement btnConfirmDelete;

    @FindBy(xpath = "/html/body/div[5]/table/tbody/tr[4]/td/div/span")
    private WebElement btnUpdateProjectContextOptionMenu;

    private WebElement lblMenuProjectName;

    public WebElement getBtnInboxFilter() {
        return btnInboxFilter;
    }

    public SideBar clickOnLnkAddProject() {
        if (lnkAddProject.isDisplayed() && lnkAddProject.isEnabled()) {
            lnkAddProject.click();
        }
        return this;
    }

    public SideBar clickOnBtnAddProject() {
        if (btnAddProject.isDisplayed() && btnAddProject.isEnabled()) {
            btnAddProject.click();
        }
        return this;
    }

    public SideBar setTxtProjectName(String projectName) {
        txtProjectName.clear();
        txtProjectName.sendKeys(projectName);
        return this;
    }





    public SideBar locateProjectByName(String projectName) {
        String xpath = new StringBuilder().append("//ul[@id='project_list']/descendant::span[text()='")
                .append(projectName)
                .append("']").toString();
        lblMenuProjectName = driver.findElement(By.xpath(xpath));
        return this;
    }

    public WebElement getLblMenuProjectName() {
        return lblMenuProjectName;
    }

    public SideBar openProjectContextMenu() {
        try {
            action.contextClick(lblMenuProjectName);
            action.build().perform();
        } catch (StaleElementReferenceException e) {

        } catch (NoSuchElementException e) {

        }
        return this;
    }

    public SideBar clickOnBtnDeleteProjectContextOptionMenu() {
        btnDeleteProjectContextOptionMenu.click();
        return this;
    }

    public SideBar clickOnBtnUpdateProjectContextOptionMenu() {
        btnUpdateProjectContextOptionMenu.click();
        return this;
    }

    public SideBar clickOnBtnConfirmDelete() {
        btnConfirmDelete.click();
        return this;
    }




}
