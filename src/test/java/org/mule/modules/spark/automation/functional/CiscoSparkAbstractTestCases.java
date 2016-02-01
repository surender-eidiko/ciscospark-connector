/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.functional;

import org.junit.Before;
import org.mule.modules.spark.SparkConnector;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;
import org.mule.tools.devkit.ctf.mockup.ConnectorDispatcher;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

public abstract class CiscoSparkAbstractTestCases extends AbstractTestCase<SparkConnector>{

	private SparkConnector connector;
	  private ConnectorDispatcher<SparkConnector> dispatcher;
	  
	  
	  
	  public CiscoSparkAbstractTestCases(Class<SparkConnector> connector){
		    super(connector);
		  }

	
	protected SparkConnector getConnector() {
		return connector;
	}


	protected ConnectorDispatcher<SparkConnector> getDispatcher() {
		return dispatcher;
	}
	
	@SuppressWarnings("deprecation")
	@Before
	  public void init() throws Exception {

	    // Initialization for single-test run
	    ConnectorTestContext.initialize(SparkConnector.class, false);

	    // Context instance
		ConnectorTestContext<SparkConnector> context = ConnectorTestContext
	      .getInstance(SparkConnector.class);

	    // Connector dispatcher
	    dispatcher = context.getConnectorDispatcher();

	    connector = dispatcher.createMockup();

	  }			
}
