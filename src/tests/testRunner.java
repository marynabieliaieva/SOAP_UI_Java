package tests;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class testRunner {

	@Test
	public void SoapTest() throws XmlException, IOException, SoapUIException {
		
	
		// Grab the project
		WsdlProject project=new WsdlProject("C:\\Users\\Mari\\Documents\\Automation.xml");
		
		// Grab the test suite in the project
		WsdlTestSuite testSuite = project.getTestSuiteByName("EmployeeTestSuite");
		
		//Grab the test cases from the test suite
		for (int i=0; i<testSuite.getTestCaseCount();i++) {
			WsdlTestCase testCase = testSuite.getTestCaseAt(i);
			
			//Run the test cases
			TestRunner runner = testCase.run(new PropertiesMap(), false);
			Assert.assertEquals(String.valueOf(Status.FINISHED), String.valueOf(runner.getStatus()));
		}
	}

}
