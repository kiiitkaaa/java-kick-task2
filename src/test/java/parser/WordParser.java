package parser;

import entity.ComponentType;
import entity.CustomTextComponent;
import entity.TextComposite;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WordParserTest {
    @Test
    void shouldSplitLexemeIntoWordAndPunctuation() {
        String text = "hello,";

        CustomTextComponent lexeme = new TextComposite(ComponentType.LEXEME);
        WordParser.getInstance().parse(lexeme, text);

        assertEquals(2, lexeme.getChildren().size());

        assertEquals(ComponentType.WORD, lexeme.getChildren().get(0).getType());
        assertEquals(ComponentType.PUNCTUATION, lexeme.getChildren().get(1).getType());
    }
}
