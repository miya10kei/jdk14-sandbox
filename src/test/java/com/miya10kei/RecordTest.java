package com.miya10kei;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *  JEP 359: Records (Preview)
 *
 * <p>
 * <a href="https://openjdk.java.net/jeps/359">Records (Preview)</a>
 */
class RecordTest {
    @Test
    void test() {
        // when
        int sum = new Point(10, 20).sum();

        // then
        assertThat(sum).isEqualTo(30);
    }

    record Point (int x, int y) implements Calculator {
        @Override
        public int sum() {
            return x + y;
        }
    }

    interface Calculator {
        int sum();
    }

}
