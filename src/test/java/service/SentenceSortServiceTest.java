package service;

import entity.ComponentType;
import entity.CustomTextComponent;
import entity.TextComposite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import parser.ParagraphParser;
import service.impl.SentenceSortServiceImpl;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SentenceSortServiceTest {
    @Test
    @DisplayName("Sentences should be sorted by 'a' count")
    void testSortByLetterCount() {
        SentenceSortServiceImpl service = new SentenceSortServiceImpl();
        CustomTextComponent root = new TextComposite(ComponentType.TEXT);

        String text = "Apple. Banana.";
        ParagraphParser.getInstance().parse(root, text);

        List<CustomTextComponent> sorted = service.sortByLetterCount(root, 'a');

        int count1 = sorted.get(0).reconstruct().length() - sorted.get(0).reconstruct().replace("a", "").length();
        int count2 = sorted.get(1).reconstruct().length() - sorted.get(1).reconstruct().replace("a", "").length();

        boolean condition = count1 <= count2;

        assertTrue(condition);
    }
}
