package com.deshko.task2.service;

import com.deshko.task2.entity.ComponentType;
import com.deshko.task2.entity.CustomTextComponent;
import com.deshko.task2.entity.TextComposite;
import org.junit.jupiter.api.Test;
import com.deshko.task2.parser.ParagraphParser;
import com.deshko.task2.service.impl.LexemeSwapServiceImpl;
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
