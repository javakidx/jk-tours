package idv.jk.converter;

import idv.jk.model.Difficulty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link StringToDifficultyConverter}.
 */
class StringToDifficultyConverterTest {
    @Test
    public void convertEasy() {
        final var converter = new StringToDifficultyConverter();
        final var result = converter.convert("easy");
        Assertions.assertSame(Difficulty.EASY, result);
    }
    @Test
    public void convertMedium() {
        final var converter = new StringToDifficultyConverter();
        final var result = converter.convert("medium");
        Assertions.assertSame(Difficulty.MEDIUM, result);
    }
    @Test
    public void convertDifficult() {
        final var converter = new StringToDifficultyConverter();
        final var result = converter.convert("difficult");
        Assertions.assertSame(Difficulty.DIFFICULT, result);
    }
}