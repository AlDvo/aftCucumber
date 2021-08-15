package taskWork.taskwork4.steps;

import taskWork.taskwork4.manager.InitManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void before() {
        InitManager.initFramework();
    }


    @After
    public void after() {
        InitManager.quitFramework();
    }
}
