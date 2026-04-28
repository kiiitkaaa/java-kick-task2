package parser;

import entity.ComponentType;
import entity.CustomTextComponent;
import entity.TextComposite;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParagraphParserTest {
    @Test
    void shouldSplitTextIntoParagraphs() {
        String text = "First paragraph.\n\tSecond paragraph.\n\tThird paragraph.";

        CustomTextComponent root = new TextComposite(ComponentType.TEXT);
        ParagraphParser.getInstance().parse(root, text);

        assertEquals(3, root.getChildren().size());
        assertEquals(ComponentType.PARAGRAPH, root.getChildren().get(0).getType());
    }
}
