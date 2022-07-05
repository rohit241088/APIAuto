package test.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import test.basePackage.BaseTest;

public class hooks {
@Before
    public void setup(Scenario sc){
    BaseTest.setApiRequest(sc);
}

@After
    public void tearDown(){
    BaseTest.TearDown();
}
}
