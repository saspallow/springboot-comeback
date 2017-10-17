package com.saspallow.demo;

/**
 * Created by dt213142 on 10/17/2017.
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    DemoApplicationTests.class,
        HomeControllerTest.class,
        UserControllerTest.class
})
public class SuiteTest {
}
