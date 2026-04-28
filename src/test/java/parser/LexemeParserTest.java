package parser;

import entity.ComponentType;
import entity.CustomTextComponent;
import entity.TextComposite;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LexemeParserTest {
    @Test
    void shouldSplitSentenceIntoLexemes() {
        String text = "Hello world test";

        CustomTextComponent sentence = new TextComposite(ComponentType.SENTENCE);
        LexemeParser.getInstance().parse(sentence, text);

        assertEquals(3, sentence.getChildren().size());
        assertEquals(ComponentType.LEXEME, sentence.getChildren().get(0).getType());
    }
}
