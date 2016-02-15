/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation;

import org.junit.Before;
import org.mule.modules.spark.SparkConnector;
import org.mule.tools.devkit.ctf.mockup.ConnectorDispatcher;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

public abstract class AbstractTestCase {

  private SparkConnector connector;
  private ConnectorDispatcher<SparkConnector> dispatcher;



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
