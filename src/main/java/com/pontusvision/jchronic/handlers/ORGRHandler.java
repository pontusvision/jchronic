package com.pontusvision.jchronic.handlers;

import java.util.List;

import com.pontusvision.jchronic.Options;
import com.pontusvision.jchronic.utils.Span;
import com.pontusvision.jchronic.utils.Token;

public class ORGRHandler extends ORRHandler {

  public Span handle(List<Token> tokens, Options options) {
    Span outerSpan = Handler.getAnchor(tokens.subList(2, 4), options);
    return handle(tokens.subList(0, 2), outerSpan, options);
  }

}
