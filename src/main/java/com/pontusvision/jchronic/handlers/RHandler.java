package com.pontusvision.jchronic.handlers;

import java.util.List;

import com.pontusvision.jchronic.Options;
import com.pontusvision.jchronic.utils.Span;
import com.pontusvision.jchronic.utils.Token;

public class RHandler implements IHandler {

  public Span handle(List<Token> tokens, Options options) {
    List<Token> ddTokens = Handler.dealiasAndDisambiguateTimes(tokens, options);
    return Handler.getAnchor(ddTokens, options);
  }

}
