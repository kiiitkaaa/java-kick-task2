package service;

import entity.ComponentType;
import entity.CustomTextComponent;
import entity.TextComposite;
import org.junit.jupiter.api.Test;
import parser.ParagraphParser;
import service.impl.DuplicateWordServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicateWordServiceTest {
    @Test
    void testFindMaxSentencesWithSameWord() {
        DuplicateWordServiceImpl service = new DuplicateWordServiceImpl();
        CustomTextComponent root = new TextComposite(ComponentType.TEXT);

        String text = "Test is a test. Another sentence.";
        ParagraphParser.getInstance().parse(root, text);

        int result = service.findMaxSentencesWithSameWord(root);

        assertEquals(1, result);
    }
}
