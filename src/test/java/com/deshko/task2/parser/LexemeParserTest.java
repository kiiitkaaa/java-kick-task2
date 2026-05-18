package com.deshko.task2.parser;

import com.deshko.task2.entity.ComponentType;
import com.deshko.task2.entity.CustomTextComponent;
import com.deshko.task2.entity.TextComposite;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LexemeParserTest {
    @Test
    void shouldSplitSentenceIntoLexemes() {
        String text = "Hello world test";

        CustomTextComponent sentence = new TextComposite(ComponentType.SENTENCE);
        LexemeParser.getInstance().parse(sentence, text);

        assertEquals(3, sentence.getChildren().size());
        assertEquals(ComponentType.LEXEME, sentence.getChildren().getFirst().getType());
    }
}
