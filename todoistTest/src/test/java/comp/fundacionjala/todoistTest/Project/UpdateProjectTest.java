package comp.fundacionjala.todoistTest.Project;

import comp.fundacionjala.todoistTest.HomePage;
import comp.fundacionjala.todoistTest.LoginFrame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UpdateProjectTest {

    private HomePage homePage;
    private  String projectName="To Test";
    private  String expectedProjectNameUpdated="To Test Updated";

    @Before
    public void setUp() {

        homePage = LoginFrame.login("es.henrry@gmail.com", "TodoIst1234");
        homePage.clickOnLnkAddProject()
                .setTxtProjectName(projectName)
                .clickOnBtnAddProject();

    }

    @Test
    public void testUpdateProject() {
        homePage.locateProjectByName(projectName)
                .openProjectContextMenu()
                .clickOnBtnUpdateProjectContextOptionMenu()
                .setTxtProjectName(expectedProjectNameUpdated)
                .clickOnBtnAddProject()
                .locateProjectByName(expectedProjectNameUpdated);

        assertEquals(expectedProjectNameUpdated,homePage.getLblMenuProjectName().getText());

    }
    @After
    public void tearDown(){
        homePage.locateProjectByName(expectedProjectNameUpdated)
                .openProjectContextMenu()
                .clickOnBtnDeleteProjectContextOptionMenu()
                .clickOnBtnConfirmDelete();
    }
}
