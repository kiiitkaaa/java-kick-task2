package parser;

import entity.ComponentType;
import entity.CustomTextComponent;
import entity.TextComposite;
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
