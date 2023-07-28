package hooks;

import io.cucumber.messages.types.Hook;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestStatusListener extends Hook implements ITestListener {

//    public void onTestFailure (ITestResult result){
//        System.out.println("Test failed");
//        try{
//            Hooks.FailedScreenshot(result.getName());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        Hooks.FailedScreenshot(testName);
    }
}
