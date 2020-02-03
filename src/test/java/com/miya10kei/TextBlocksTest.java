package com.miya10kei;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * JEP 368: Text Blocks (Second Preview)
 * <p>
 * <a href="https://openjdk.java.net/jeps/368">Text Blocks (Second Preview)</a>
 */
public class TextBlocksTest {
    @Test
    void test() {
        var text = """
                SELECT * FROM TABLE A
                WHERE A.id = '1'
                """;
        assertThat(text).isEqualTo("SELECT * FROM TABLE A\nWHERE A.id = '1'\n");
    }
}
