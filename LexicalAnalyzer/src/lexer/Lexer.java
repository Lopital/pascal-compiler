package lexer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lexer {
  private File file;
  private FileReader input;

  public Lexer(String filename) throws Exception {
    this.file = new File(filename);
    this.input = new FileReader(this.file);
  }


  private char nextChar() throws IOException {
    return (char) this.input.read();
  }

  public Tokens nextToken() throws IOException, Exception {
    States previousState = States.START_STATE;
    char c = nextChar();

    while (c != -1) {
      States currentState = previousState.move(c);

      switch (currentState) {
      case COMMENT:
        previousState = currentState;
        // intentionally left blank, we simply ignore comments;
        break;

      case END_STATE:
        switch (previousState) {
        case COMMENT:
          return Tokens.COMMENT;
        default:
          return null;
        }

      case INCONSISTENT:
        throw new Exception("synthax error");

      default:
        break;
      }

      c = nextChar();
    }
    return null;
  }
}
