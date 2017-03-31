/*
 *
 */
package au.com.mazda.MDP.Utility;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

// TODO: Auto-generated Javadoc
/**
 * The Class Listener.
 *
 * @author cheaus
 */
public class Listener
        implements ITestListener, ISuiteListener, IInvokedMethodListener {

    // This method will be executed in case of test pass or fail or skip. This
    /**
     * Prints the test results.
     *
     * @param result
     *            the result
     */
    // will provide the information of the test
    private static void printTestResults(final ITestResult result) {
        Reporter.log(
                "Test Method resides in " + result.getTestClass().getName(),
                true);
        if (result.getParameters().length != 0) {
            String params = null;
            for (final Object parameter : result.getParameters()) {
                params += parameter.toString() + ",";
            }

            Reporter.log("Test Method had the following parameters : " + params,
                    true);
        }

        String status = null;
        switch (result.getStatus()) {
        case ITestResult.SUCCESS:
            status = "PASSED";
            break;

        case ITestResult.FAILURE:
            status = "FAILED";
            break;

        case ITestResult.SKIP:
            status = "SKIPPED";
            break;
        default:
            break;
        }

        Reporter.log("Test Status: " + status, true);
    }

    /**
     * Return method name.
     *
     * @param method
     *            the method
     * @return the string
     */
    private static String returnMethodName(final ITestNGMethod method) {

        return method.getRealClass().getSimpleName() + "."
                + method.getMethodName();
    }

    /**
     * After invocation.
     *
     * @param method
     *            the method
     * @param testResult
     *            the test result
     */
    public void afterInvocation(final IInvokedMethod method,
            final ITestResult testResult) {
        final String textMsg = "Completed executing following method : "
                + returnMethodName(method.getTestMethod());
        Reporter.log(textMsg, true);

    }

    // This will execute before every method including

    /**
     * Before invocation.
     *
     * @param method
     *            the method
     * @param testResult
     *            the test result
     */
    public void beforeInvocation(final IInvokedMethod method,
            final ITestResult testResult) {
        final String textMsg = "About to begin executing following method : "
                + returnMethodName(method.getTestMethod());
        Reporter.log(textMsg, true);

    }

    /*
     * (non-Javadoc)
     * @see org.testng.ISuiteListener#onFinish(org.testng.ISuite)
     */
    public void onFinish(final ISuite suite) {
        Reporter.log(" About to end executing Suite " + suite.getName(), true);

    }

    /*
     * (non-Javadoc)
     * @see org.testng.ITestListener#onFinish(org.testng.ITestContext)
     */
    public void onFinish(final ITestContext context) {
        Reporter.log("Completed executing test " + context.getName(), true);

    }

    /*
     * (non-Javadoc)
     * @see org.testng.ISuiteListener#onStart(org.testng.ISuite)
     */
    public void onStart(final ISuite suite) {
        Reporter.log(" About to begin executing suite " + suite.getName(),
                true);

    }

    /*
     * (non-Javadoc)
     * @see org.testng.ITestListener#onStart(org.testng.ITestContext)
     */
    public void onStart(final ITestContext context) {
        Reporter.log(" About to begin executing Test " + context.getName(),
                true);

    }

    /*
     * (non-Javadoc)
     * @see org.testng.ITestListener#onTestFailedButWithinSuccessPercentage(org.
     * testng.ITestResult)
     */
    public void onTestFailedButWithinSuccessPercentage(
            final ITestResult result) {
        printTestResults(result);
    }

    /*
     * (non-Javadoc)
     * @see org.testng.ITestListener#onTestFailure(org.testng.ITestResult)
     */
    public void onTestFailure(final ITestResult result) {
        printTestResults(result);

    }

    /*
     * (non-Javadoc)
     * @see org.testng.ITestListener#onTestSkipped(org.testng.ITestResult)
     */
    public void onTestSkipped(final ITestResult result) {
        printTestResults(result);

    }

    /**
     * On test start.
     *
     * @param result
     *            the result
     */
    public void onTestStart(final ITestResult result) {
        Reporter.log("The execution of the main test starts now");

    }

    /*
     * (non-Javadoc)
     * @see org.testng.ITestListener#onTestSuccess(org.testng.ITestResult)
     */
    public void onTestSuccess(final ITestResult result) {
        printTestResults(result);

    }

}
