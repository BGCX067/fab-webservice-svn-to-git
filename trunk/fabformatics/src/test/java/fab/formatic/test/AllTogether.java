package fab.formatic.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author gilang
 *
 */
@RunWith(Suite.class)
@SuiteClasses({PersistenceUnitTest.class, ServiceUnitTest.class})
public class AllTogether {

}
