package testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testcases.SearchTest;
import testcases.ZixuanTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SearchTest.class,
        ZixuanTest.class
})
public class testsuite {
}
