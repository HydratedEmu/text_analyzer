import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CountJUnitTester.class, WordJUnitTester.class })
public class CountAndWordTestSuite {

}
