package com.pontusvision.jchronic.handlers;

import java.util.List;

import com.pontusvision.jchronic.Options;
import com.pontusvision.jchronic.repeaters.RepeaterMonthName;
import com.pontusvision.jchronic.tags.ScalarDay;
import com.pontusvision.jchronic.utils.Span;
import com.pontusvision.jchronic.utils.Token;

public class RmnSdHandler extends MDHandler {
  public Span handle(List<Token> tokens, Options options) {
    return handle(tokens.get(0).getTag(RepeaterMonthName.class), tokens.get(1).getTag(ScalarDay.class), tokens.subList(2, tokens.size()), options);
  }
}
