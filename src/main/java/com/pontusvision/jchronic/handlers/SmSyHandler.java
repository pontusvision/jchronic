package com.pontusvision.jchronic.handlers;

import java.util.Calendar;
import java.util.List;

import com.pontusvision.jchronic.Options;
import com.pontusvision.jchronic.tags.ScalarMonth;
import com.pontusvision.jchronic.tags.ScalarYear;
import com.pontusvision.jchronic.utils.Span;
import com.pontusvision.jchronic.utils.Time;
import com.pontusvision.jchronic.utils.Token;

public class SmSyHandler implements IHandler {
  public Span handle(List<Token> tokens, Options options) {
    int month = tokens.get(0).getTag(ScalarMonth.class).getType().intValue();
    int year = tokens.get(1).getTag(ScalarYear.class).getType().intValue();
    Span span;
    try {
      Calendar start = Time.construct(year, month);
      Calendar end = Time.cloneAndAdd(start, Calendar.MONTH, 1);
      span = new Span(start, end);
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
