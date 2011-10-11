package lexer;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class LexerTest {

  @Rule
  public TestName name = new TestName();
  private Lexer lexer;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    File tempFile = new File(".");
    String path = tempFile.getAbsolutePath() + "/subjects/lexer/" + name.getMethodName();
    lexer = new Lexer(path);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void commentTest() {
    compare(Tokens.COMMENT);
  }

  private void compare(Tokens expected) {
    try {
      Tokens temp = lexer.nextToken();
      assertEquals(expected, temp);
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

}
