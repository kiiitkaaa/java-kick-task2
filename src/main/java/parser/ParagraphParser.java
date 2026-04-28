package parser;

import entity.CustomTextComponent;
import entity.TextComposite;
import entity.ComponentType;

public class ParagraphParser extends AbstractTextParser {
    private static final String PARAGRAPH_REGEX = "(?m)(?=^(\\t| {4}))";
    private static final ParagraphParser INSTANCE = new ParagraphParser(SentenceParser.getInstance());

    private ParagraphParser(TextParser nextParser) {
        super(nextParser);
    }

    public static ParagraphParser getInstance() {
        return INSTANCE;
    }

    @Override
    public void parse(CustomTextComponent component, String text) {
        String[] paragraphs = text.split(PARAGRAPH_REGEX);

        for (String paragraph : paragraphs) {
            if (!paragraph.isBlank()) {
                CustomTextComponent paragraphComponent = new TextComposite(ComponentType.PARAGRAPH);
                component.add(paragraphComponent);

                if (nextParser != null) {
                    nextParser.parse(paragraphComponent, paragraph.strip());
                }
            }
        }
    }
}
