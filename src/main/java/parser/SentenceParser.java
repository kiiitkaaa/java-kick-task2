package parser;

import entity.CustomTextComponent;
import entity.TextComposite;
import entity.ComponentType;

public class SentenceParser extends AbstractTextParser{
    private static final String SENTENCE_REGEX = "(?<=[.!?])\\s+";
    private static final SentenceParser INSTANCE = new SentenceParser(LexemeParser.getInstance());

    private SentenceParser(TextParser nextParser) {
        super(nextParser);
    }

    public static SentenceParser getInstance() {
        return INSTANCE;
    }

    @Override
    public void parse(CustomTextComponent component, String text) {
        String[] sentences = text.split(SENTENCE_REGEX);

        for (String sentence : sentences) {
            CustomTextComponent sentenceComponent = new TextComposite(ComponentType.SENTENCE);
            component.add(sentenceComponent);

            if (nextParser != null) {
                nextParser.parse(sentenceComponent, sentence);
            }
        }
    }
}
