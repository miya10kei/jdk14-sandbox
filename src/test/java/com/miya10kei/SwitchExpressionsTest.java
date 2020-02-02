package com.miya10kei;

import java.time.DayOfWeek;
import org.junit.jupiter.api.Test;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import static org.assertj.core.api.Assertions.assertThat;

public class SwitchExpressionsTest {
  @Test
  void test1() {
    // Before Java 14
    DayOfWeek dayOfTheWeek = MONDAY;
    switch (dayOfTheWeek) {
      case SUNDAY:
        System.out.println(SUNDAY);
        break;
      case MONDAY:
        System.out.println(MONDAY);
        break;
      case TUESDAY:
        System.out.println(TUESDAY);
        break;
      case WEDNESDAY:
        System.out.println(WEDNESDAY);
        break;
      case THURSDAY:
        System.out.println(THURSDAY);
        break;
      case FRIDAY:
        System.out.println(FRIDAY);
        break;
      case SATURDAY:
        System.out.println(SATURDAY);
        break;
    }

    // After Java 14
    switch (dayOfTheWeek) {
      case SUNDAY -> System.out.println(SUNDAY);
      case MONDAY -> System.out.println(MONDAY);
      case TUESDAY -> System.out.println(TUESDAY);
      case WEDNESDAY -> System.out.println(WEDNESDAY);
      case THURSDAY -> System.out.println(THURSDAY);
      case FRIDAY -> System.out.println(FRIDAY);
      case SATURDAY -> System.out.println(SATURDAY);
    }
  }

  @Test
  void test2() {
    // Before Java 14
    DayOfWeek dayOfTheWeek = MONDAY;
    int dayOfWeekNumber1 = -1;
    switch (dayOfTheWeek) {
      case SUNDAY:
        dayOfWeekNumber1 = 0;
        break;
      case MONDAY:
        dayOfWeekNumber1 = 1;
        break;
      case TUESDAY:
        dayOfWeekNumber1 = 2;
        break;
      case WEDNESDAY:
        dayOfWeekNumber1 = 3;
        break;
      case THURSDAY:
        dayOfWeekNumber1 = 4;
        break;
      case FRIDAY:
        dayOfWeekNumber1 = 5;
        break;
      case SATURDAY:
        dayOfWeekNumber1 = 6;
        break;
    }
    assertThat(dayOfWeekNumber1).isEqualTo(1);

    // After Java 14
    int dayOfWeekNumber2 = switch (dayOfTheWeek) {
      case SUNDAY    -> 0;
      case MONDAY    -> 1;
      case TUESDAY   -> 2;
      case WEDNESDAY -> 3;
      case THURSDAY  -> 4;
      case FRIDAY    -> 5;
      case SATURDAY  -> 6;
    };
    assertThat(dayOfWeekNumber2).isEqualTo(1);

    int dayOfWeekNumber3 = switch (dayOfTheWeek) {
      case SUNDAY :
        yield 0;
      case MONDAY :
        yield 1;
      case TUESDAY :
        yield 2;
      case WEDNESDAY :
        yield 3;
      case THURSDAY :
        yield 4;
      case FRIDAY :
        yield 5;
      case SATURDAY :
        yield 6;
    };
    assertThat(dayOfWeekNumber3).isEqualTo(1);
  }
}
