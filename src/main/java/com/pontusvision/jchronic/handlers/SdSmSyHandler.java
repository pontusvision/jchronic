package com.pontusvision.jchronic.handlers;

import java.util.LinkedList;
import java.util.List;

import com.pontusvision.jchronic.Options;
import com.pontusvision.jchronic.utils.Span;
import com.pontusvision.jchronic.utils.Token;

public class SdSmSyHandler extends SmSdSyHandler {

  @Override
  public Span handle(List<Token> tokens, Options options) {
    List<Token> newTokens = new LinkedList<Token>();
    newTokens.add(tokens.get(1));
    newTokens.add(tokens.get(0));
    newTokens.add(tokens.get(2));
    newTokens.addAll(tokens.subList(3, tokens.size()));
    return super.handle(newTokens, options);
  }
}
