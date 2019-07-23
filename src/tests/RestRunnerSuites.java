package tests;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.junit.Assert;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class RestRunnerSuites {
	public void restRunnerSuites() throws XmlException, IOException, SoapUIException {
		// Grab the project
		WsdlProject project=new WsdlProject("C:\\Users\\Mari\\Documents\\REST-Project-1-soapui-project.xml");	
		
		// Grab the test suite in the project
		for (int j=0; j<project.getTestSuiteCount();j++) {
			project.getTestSuiteAt(j);
		}
		
		WsdlTestSuite testSuite = project.getTestSuiteByName("E2E");
		//Grab the test cases present in test suite
		for (int i=0; i<testSuite.getTestCaseCount();i++) {
			WsdlTestCase testCase = testSuite.getTestCaseAt(i);
		
		TestRunner runner = testCase.run(new PropertiesMap(), false);
		Assert.assertEquals(String.valueOf(Status.FINISHED), String.valueOf(runner.getStatus()));
	}

}

}
