package com.learn.spring.test;

import com.learn.spring.test.v1.V1AllTests;
import com.learn.spring.test.v2.V2AllTests;
import com.learn.spring.test.v3.V3AllTests;
import com.learn.spring.test.v4.V4AllTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.learn.spring.test.v5.V5AllTests;
import com.learn.spring.test.v6.V6AllTests;

@RunWith(Suite.class)
@SuiteClasses({V1AllTests.class, V2AllTests.class, V3AllTests.class, V4AllTests.class,V5AllTests.class,V6AllTests.class})
public class AllTests {

}
