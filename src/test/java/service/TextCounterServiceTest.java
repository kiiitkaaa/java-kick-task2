package service;

import entity.ComponentType;
import entity.CustomTextComponent;
import entity.TextComposite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import parser.ParagraphParser;
import service.impl.TextCounterServiceImpl;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TextCounterServiceTest {
    private TextCounterServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new TextCounterServiceImpl();
    }

    @Test
    @DisplayName("Letters and symbols count should match")
    void testCountLettersAndSymbols() {
        CustomTextComponent root = new TextComposite(ComponentType.TEXT);
        ParagraphParser.getInstance().parse(root, "Hi!");

        int[] expected = {2, 3};
        int[] actual = service.countLettersAndSymbols(root);

        assertArrayEquals(expected, actual);
    }
}
