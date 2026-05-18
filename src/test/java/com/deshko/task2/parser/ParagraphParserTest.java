package com.deshko.task2.parser;

import com.deshko.task2.entity.ComponentType;
import com.deshko.task2.entity.CustomTextComponent;
import com.deshko.task2.entity.TextComposite;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParagraphParserTest {
    @Test
    void shouldSplitTextIntoParagraphs() {
        String text = "First paragraph.\n\tSecond paragraph.\n\tThird paragraph.";

        CustomTextComponent root = new TextComposite(ComponentType.TEXT);
        ParagraphParser.getInstance().parse(root, text);

        assertEquals(3, root.getChildren().size());
        assertEquals(ComponentType.PARAGRAPH, root.getChildren().getFirst().getType());
    }
}
