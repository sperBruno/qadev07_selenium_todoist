package comp.fundacionjala.todoistTest.Project;

import comp.fundacionjala.todoistTest.DeleteAlert;
import comp.fundacionjala.todoistTest.HomePage;
import comp.fundacionjala.todoistTest.LoginFrame;
import comp.fundacionjala.todoistTest.ProjectContainer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreateProjectTest {

    private static final String PROJECT_NAME = "project test";

    private HomePage homePage;

    @Before
    public void setUp() {
        homePage = LoginFrame.loginAsPrimaryUser();
    }

    @Test
    public void testCreateProject() {
        ProjectContainer projectContainer = homePage.getSideBar()
                .clickOnLnkAddProject()
                .setTxtProjectName(PROJECT_NAME)
                .clickOnBtnAddProject();
        assertTrue("", projectContainer.isProjectNameDisplayed());
    }

    @After
    public void tearDown() {
        DeleteAlert deleteAlert = homePage.getSideBar()
                .locateProjectByName(PROJECT_NAME)
                .openProjectContextMenu()
                .clickOnBtnDeleteProjectContextOptionMenu();
        deleteAlert.clickOnBtnConfirmDelete();
    }
}
