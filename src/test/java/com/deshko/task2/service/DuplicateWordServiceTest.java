package com.deshko.task2.service;

import com.deshko.task2.entity.ComponentType;
import com.deshko.task2.entity.CustomTextComponent;
import com.deshko.task2.entity.TextComposite;
import org.junit.jupiter.api.Test;
import com.deshko.task2.parser.ParagraphParser;
import com.deshko.task2.service.impl.DuplicateWordServiceImpl;
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
