import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * 
 * @author Sammy Garcia
 * @version 1.0
 * @since 04/09/2023
 * 
 */
@Suite
@SelectClasses({ CountJUnitTester.class, WordJUnitTester.class })
public class CountAndWordTestSuite {

}
