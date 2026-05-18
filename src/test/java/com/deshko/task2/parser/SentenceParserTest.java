package com.deshko.task2.parser;

import com.deshko.task2.entity.ComponentType;
import com.deshko.task2.entity.CustomTextComponent;
import com.deshko.task2.entity.TextComposite;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SentenceParserTest {
    @Test
    void shouldSplitParagraphIntoSentences() {
        String text = "Hello world. How are you? I'm fine!";

        CustomTextComponent paragraph = new TextComposite(ComponentType.PARAGRAPH);
        SentenceParser.getInstance().parse(paragraph, text);

        assertEquals(3, paragraph.getChildren().size());
    }
}
