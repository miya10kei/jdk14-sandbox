package com.miya10kei;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

/**
 * JEP 305: Pattern Matching for instanceof (Preview)
 *
 * <p>
 * <a href="https://openjdk.java.net/jeps/305">Pattern Matching for instanceof</a>
 */
class PatternMatchingTest {

  private static final String s = "Class variable";

  @Test
  void test() {
    // Before Java 14
    Object obj = "Pattern Matching";
    if (obj instanceof String) {
      var str = (String) obj;
      assertThat(str.contains("Pattern Matching")).isTrue();
    } else {
      fail(null);
    }

    // Java 14
    if (obj instanceof String str) {
      assertThat(str.contains("Pattern Matching")).isTrue();
    } else {
      fail(null);
    }

    if (!(obj instanceof String s)) {
      // The s refers to instance variable.
      assertThat(s.contains("Class variable")).isTrue();
    } else {
      // The s refers to the binding variable.
      assertThat(s.contains("Pattern Matching")).isTrue();
    }

    // The s on the right hand side refers to the binding variable.
    var bool1 = obj instanceof String s && s.contains("Pattern Matching");
    assertThat(bool1).isTrue();

    // The s on the right hand side refers to the class variable.
    var bool2 = obj instanceof Integer s || s.contains("Class variable");
    assertThat(bool2).isTrue();
  }
}

