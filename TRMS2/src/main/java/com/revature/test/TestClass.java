package com.revature.test;

import org.apache.log4j.Logger;

public class TestClass
{
    private static Logger log = Logger.getLogger(TestClass.class);
    
    public TestClass()
    {
        log.trace("This is just to have a class for SonarCube to look at");
    }
    
}
