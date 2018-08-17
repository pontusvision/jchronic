package com.pontusvision.jchronic.handlers;

import java.util.Calendar;
import java.util.List;

import com.pontusvision.jchronic.Options;
import com.pontusvision.jchronic.tags.ScalarDay;
import com.pontusvision.jchronic.tags.ScalarMonth;
import com.pontusvision.jchronic.utils.Time;
import com.pontusvision.jchronic.utils.Span;
import com.pontusvision.jchronic.utils.Token;

public class SmSdHandler implements IHandler {
  public Span handle(List<Token> tokens, Options options) {
    int day = tokens.get(0).getTag(ScalarDay.class).getType().intValue();
    int month = tokens.get(1).getTag(ScalarMonth.class).getType().intValue();
    Calendar start = Time.construct(options.getNow().get(Calendar.YEAR), month, day);
    Calendar end = Time.cloneAndAdd(start, Calendar.DAY_OF_MONTH, 1);
    return new Span(start, end);
  }

}
