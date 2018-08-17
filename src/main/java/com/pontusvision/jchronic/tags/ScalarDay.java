package com.pontusvision.jchronic.tags;

import java.util.regex.Pattern;

import com.pontusvision.jchronic.Options;
import com.pontusvision.jchronic.utils.Token;

public class ScalarDay extends Scalar {
  private static final Pattern DAY_PATTERN = Pattern.compile("^\\d\\d?$");

  public ScalarDay(Integer type) {
    super(type);
  }

  @Override
  public String toString() {
    return super.toString() + "-day-" + getType();
  }

  public static ScalarDay scan(Token token, Token postToken, Options options) {
    if (ScalarDay.DAY_PATTERN.matcher(token.getWord()).matches()) {
      int scalarValue = Integer.parseInt(token.getWord());
      if (!(scalarValue > 31 || (postToken != null && Scalar.TIMES.contains(postToken.getWord())))) {
        return new ScalarDay(Integer.valueOf(scalarValue));
      }
    }
    return null;
  }
}
