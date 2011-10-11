package lexer;

public enum States {
  START_STATE {
    @Override
    public States move(char ch) {
      if (ch == '{')
        return COMMENT;
      else
        return INCONSISTENT;
    }
  },

  END_STATE {
    @Override
    public States move(char ch) {
      return START_STATE;
    }
  },
  INCONSISTENT, COMMENT {
    @Override
    public States move(char ch) {
      if (ch == '}')
        return END_STATE;
      else
        return COMMENT;
    }
  };

  public States move(char ch) {
    // this method HAS to be overridden in each new enum entry.
    return INCONSISTENT;
  }
}
