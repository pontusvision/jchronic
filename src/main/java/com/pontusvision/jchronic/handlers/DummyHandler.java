package com.pontusvision.jchronic.handlers;

import java.util.List;

import com.pontusvision.jchronic.Options;
import com.pontusvision.jchronic.utils.Span;
import com.pontusvision.jchronic.utils.Token;

public class DummyHandler implements IHandler {
  public Span handle(List<Token> tokens, Options options) {
    return null;
  }
}
