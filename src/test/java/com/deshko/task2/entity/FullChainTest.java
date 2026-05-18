package com.deshko.task2.entity;

import org.junit.jupiter.api.Test;
import com.deshko.task2.parser.ParagraphParser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FullChainTest {
    @Test
    void testFullParsingChain() {
        String input = "Hello world. This is Java.";
        CustomTextComponent root = new TextComposite(ComponentType.TEXT);

        ParagraphParser.getInstance().parse(root, input);

        assertNotNull(root.getChildren());
        assertEquals(ComponentType.TEXT, root.getType());
        assertEquals(input, root.reconstruct().trim().replaceAll("\\s+", " "));
    }
}
