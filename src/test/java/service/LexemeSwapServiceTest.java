package service;

import entity.ComponentType;
import entity.CustomTextComponent;
import entity.TextComposite;
import org.junit.jupiter.api.Test;
import parser.ParagraphParser;
import service.impl.LexemeSwapServiceImpl;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LexemeSwapServiceTest {
    @Test
    void testSwapFirstAndLastLexemes() {
        LexemeSwapServiceImpl service = new LexemeSwapServiceImpl();
        CustomTextComponent root = new TextComposite(ComponentType.TEXT);

        String text = "First second last.";
        ParagraphParser.getInstance().parse(root, text);

        service.swapFirstAndLastLexemes(root);

        String result = root.reconstruct().trim();

        boolean condition = result.startsWith("last") && result.contains("First");

        assertTrue(condition);
    }
}
