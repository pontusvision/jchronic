package com.pontusvision.jchronic.handlers;

import java.util.List;

import com.pontusvision.jchronic.Options;
import com.pontusvision.jchronic.utils.Span;
import com.pontusvision.jchronic.utils.Token;

public class SRPAHandler extends SRPHandler {

  @Override
  public Span handle(List<Token> tokens, Options options) {
    Span anchorSpan = Handler.getAnchor(tokens.subList(3, tokens.size()), options);
    return super.handle(tokens, anchorSpan, options);
  }

}
