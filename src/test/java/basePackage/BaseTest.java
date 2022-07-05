package test.basePackage;

import io.cucumber.java.Scenario;
import main.baseRequestPackage.APIRequest;

public class BaseTest {

    public static APIRequest apiRequest;
    public static Scenario scenario;
    public static void setApiRequest(Scenario sc){
        BaseTest.scenario=sc;
apiRequest=new APIRequest(true) ;

   }

   public static void TearDown(){
        APIRequest.requestSpecification=null;
   }
}
