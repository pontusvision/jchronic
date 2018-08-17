package com.pontusvision.jchronic.handlers;

import java.util.Calendar;
import java.util.List;

import com.pontusvision.jchronic.Options;
import com.pontusvision.jchronic.repeaters.RepeaterMonthName;
import com.pontusvision.jchronic.tags.ScalarDay;
import com.pontusvision.jchronic.tags.ScalarYear;
import com.pontusvision.jchronic.utils.Span;
import com.pontusvision.jchronic.utils.Time;
import com.pontusvision.jchronic.utils.Token;

public class RmnSdSyHandler implements IHandler {

  public Span handle(List<Token> tokens, Options options) {
    int day = tokens.get(0).getTag(ScalarDay.class).getType().intValue();
    int month = tokens.get(1).getTag(RepeaterMonthName.class).getType().ordinal();
    int year = tokens.get(2).getTag(ScalarYear.class).getType().intValue();

    Span span;
    try {
      List<Token> timeTokens = tokens.subList(3, tokens.size());
      Calendar dayStart = Time.construct(year, month, day);
      span = Handler.dayOrTime(dayStart, timeTokens, options);
    }
    catch (IllegalArgumentException e) {
      if (options.isDebug()) {
        e.printStackTrace(System.out);
      }
      span = null;
    }
    return span;
  }

}
