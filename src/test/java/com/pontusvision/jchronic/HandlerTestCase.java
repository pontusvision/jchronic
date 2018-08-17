package com.pontusvision.jchronic;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.pontusvision.jchronic.handlers.DummyHandler;
import com.pontusvision.jchronic.handlers.Handler;
import com.pontusvision.jchronic.handlers.HandlerTypePattern;
import com.pontusvision.jchronic.handlers.TagPattern;
import com.pontusvision.jchronic.repeaters.EnumRepeaterDayPortion;
import com.pontusvision.jchronic.repeaters.Repeater;
import com.pontusvision.jchronic.repeaters.RepeaterDayName;
import com.pontusvision.jchronic.repeaters.RepeaterDayPortion;
import com.pontusvision.jchronic.repeaters.RepeaterMonthName;
import com.pontusvision.jchronic.repeaters.RepeaterTime;
import com.pontusvision.jchronic.repeaters.RepeaterYear;
import com.pontusvision.jchronic.tags.Pointer;
import com.pontusvision.jchronic.tags.Scalar;
import com.pontusvision.jchronic.tags.ScalarDay;
import com.pontusvision.jchronic.utils.Time;
import com.pontusvision.jchronic.utils.Token;

@RunWith(JUnit4.class)
public class HandlerTestCase {
  private Calendar _now;
  
  @Before
  public void setUp() throws Exception {
    _now = Time.construct(2006, 8, 16, 14, 0, 0, 0);
  }

  @Test
  public void testHandlerClass1() {
    Handler handler = new Handler(new DummyHandler(), new TagPattern(Repeater.class));
    List<Token> tokens = new LinkedList<Token>();
    tokens.add(new Token("friday"));
    tokens.get(0).tag(new RepeaterDayName(RepeaterDayName.DayName.FRIDAY));
    
    Assert.assertTrue(handler.match(tokens, Handler.definitions()));
    
    tokens.add(new Token("afternoon"));
    tokens.get(1).tag(new EnumRepeaterDayPortion(RepeaterDayPortion.DayPortion.AFTERNOON));
    
    Assert.assertFalse(handler.match(tokens, Handler.definitions()));
  }

  @Test
  public void testHandlerClass2() {
    Handler handler = new Handler(new DummyHandler(), new TagPattern(Repeater.class), new TagPattern(Repeater.class, true));
    List<Token> tokens = new LinkedList<Token>();
    tokens.add(new Token("friday"));
    tokens.get(0).tag(new RepeaterDayName(RepeaterDayName.DayName.FRIDAY));
    
    Assert.assertTrue(handler.match(tokens, Handler.definitions()));
    
    tokens.add(new Token("afternoon"));
    tokens.get(1).tag(new EnumRepeaterDayPortion(RepeaterDayPortion.DayPortion.AFTERNOON));
    
    Assert.assertTrue(handler.match(tokens, Handler.definitions()));
    
    tokens.add(new Token("afternoon"));
    tokens.get(2).tag(new EnumRepeaterDayPortion(RepeaterDayPortion.DayPortion.AFTERNOON));
    
    Assert.assertFalse(handler.match(tokens, Handler.definitions()));
  }

  @Test
  public void testHandlerClass3() {
    Handler handler = new Handler(new DummyHandler(), new TagPattern(Repeater.class), new HandlerTypePattern(Handler.HandlerType.TIME, true));
    List<Token> tokens = new LinkedList<Token>();
    tokens.add(new Token("friday"));
    tokens.get(0).tag(new RepeaterDayName(RepeaterDayName.DayName.FRIDAY));
    
    Assert.assertTrue(handler.match(tokens, Handler.definitions()));
    
    tokens.add(new Token("afternoon"));
    tokens.get(1).tag(new EnumRepeaterDayPortion(RepeaterDayPortion.DayPortion.AFTERNOON));
    
    Assert.assertFalse(handler.match(tokens, Handler.definitions()));
  }

  @Test
  public void testHandlerClass4() {
    Handler handler = new Handler(new DummyHandler(), new TagPattern(RepeaterMonthName.class), new TagPattern(ScalarDay.class), new HandlerTypePattern(Handler.HandlerType.TIME, true));
    List<Token> tokens = new LinkedList<Token>();
    tokens.add(new Token("may"));
    tokens.get(0).tag(new RepeaterMonthName(RepeaterMonthName.MonthName.MAY));
    
    Assert.assertFalse(handler.match(tokens, Handler.definitions()));
    
    tokens.add(new Token("27"));
    tokens.get(1).tag(new ScalarDay(Integer.valueOf(27)));
    
    Assert.assertTrue(handler.match(tokens, Handler.definitions()));
  }

  @Test
  public void testHandlerClass5() {
    Handler handler = new Handler(new DummyHandler(), new TagPattern(Repeater.class), new HandlerTypePattern(Handler.HandlerType.TIME, true));
    List<Token> tokens = new LinkedList<Token>();
    tokens.add(new Token("friday"));
    tokens.get(0).tag(new RepeaterDayName(RepeaterDayName.DayName.FRIDAY));
    
    Assert.assertTrue(handler.match(tokens, Handler.definitions()));
    
    tokens.add(new Token("5:00"));
    tokens.get(1).tag(new RepeaterTime("5:00"));
    
    Assert.assertTrue(handler.match(tokens, Handler.definitions()));
    
    tokens.add(new Token("pm"));
    tokens.get(2).tag(new EnumRepeaterDayPortion(RepeaterDayPortion.DayPortion.PM));
    
    Assert.assertTrue(handler.match(tokens, Handler.definitions()));
  }

  @Test
  public void testHandlerClass6() {
    Handler handler = new Handler(new DummyHandler(), new TagPattern(Scalar.class), new TagPattern(Repeater.class), new TagPattern(Pointer.class));
    List<Token> tokens = new LinkedList<Token>();
    tokens.add(new Token("3"));
    tokens.add(new Token("years"));
    tokens.add(new Token("past"));
    
    tokens.get(0).tag(new Scalar(Integer.valueOf(3)));
    tokens.get(1).tag(new RepeaterYear());
    tokens.get(2).tag(new Pointer(Pointer.PointerType.PAST));
    
    Assert.assertTrue(handler.match(tokens, Handler.definitions()));
  }

//    def test_constantize
//      handler = Chronic::Handler.new([], :handler)
//      assert_equal Chronic::RepeaterTime, handler.constantize(:repeater_time)
//    end
//    
//  end
}
