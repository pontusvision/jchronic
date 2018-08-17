package com.pontusvision.jchronic.handlers;

import java.util.List;

import com.pontusvision.jchronic.Chronic;
import com.pontusvision.jchronic.Options;
import com.pontusvision.jchronic.repeaters.Repeater;
import com.pontusvision.jchronic.tags.Pointer;
import com.pontusvision.jchronic.tags.Scalar;
import com.pontusvision.jchronic.utils.Span;
import com.pontusvision.jchronic.utils.Token;

public class SRPHandler implements IHandler {

  public Span handle(List<Token> tokens, Span span, Options options) {
    int distance = tokens.get(0).getTag(Scalar.class).getType().intValue();
    Repeater<?> repeater = tokens.get(1).getTag(Repeater.class);
    Pointer.PointerType pointer = tokens.get(2).getTag(Pointer.class).getType();
    return repeater.getOffset(span, distance, pointer);
  }

  public Span handle(List<Token> tokens, Options options) {
    Repeater<?> repeater = tokens.get(1).getTag(Repeater.class);
    // DIFF: Missing fortnight
    /*
    Span span;
    if (repeater instanceof RepeaterYear || repeater instanceof RepeaterSeason || repeater instanceof RepeaterSeasonName || repeater instanceof RepeaterMonth || repeater instanceof RepeaterMonthName || repeater instanceof RepeaterWeek) {
      span = chronic.parse("this hour", new Options(chronic.getNow(), false));
    }
    else if (repeater instanceof RepeaterWeekend || repeater instanceof RepeaterDay || repeater instanceof RepeaterDayName || repeater instanceof RepeaterDayPortion || repeater instanceof RepeaterHour) {
      span = chronic.parse("this minute", new Options(chronic.getNow(), false));
    }
    else if (repeater instanceof RepeaterMinute || repeater instanceof RepeaterSecond) {
      span = chronic.parse("this second", new Options(chronic.getNow(), false));
    }
    else {
      throw new IllegalArgumentException("Invalid repeater: " + repeater);
    }
    */
    Span span = Chronic.parse("this second", new Options(options.getNow(), false));
    return handle(tokens, span, options);
  }
}
