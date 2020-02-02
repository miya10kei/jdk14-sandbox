package com.miya10kei;

import org.junit.jupiter.api.Test;

/**
 * JEP 358: Helpful NullPointerExceptions
 *
 * <p><a href="https://openjdk.java.net/jeps/358">Helpful NullPointerExceptions</a>
 */
class HelpfulNullPointerExceptionTest {
  @Test
  void test() {
    try {
      var car = new Car();
      System.out.println(car.engine.maker.name);
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
    System.out.println();
    try {
      String[][] a = new String[][] {new String[] {null}};
      a[0][0].toString();
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
  }

  static class Car {
    private Engine engine = null;

    static class Engine {
      private Maker maker = new Maker();

      static class Maker {
        private String name = "YAMAHA";
      }
    }
  }
}
