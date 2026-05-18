package com.deshko.task2.parser;

import com.deshko.task2.entity.CustomTextComponent;
import com.deshko.task2.entity.TextComposite;
import com.deshko.task2.entity.ComponentType;
import com.deshko.task2.entity.SymbolLeaf;

public class WordParser extends AbstractTextParser {
    private static final String WORD_PUNCTUATION_REGEX = "(?<=\\b)(?=\\p{Punct})|(?<=\\p{Punct})(?=\\b)";
    private static final WordParser INSTANCE = new WordParser(null);

    private WordParser(TextParser nextParser) {
        super(nextParser);
    }

    public static WordParser getInstance() {
        return INSTANCE;
    }

    @Override
    public void parse(CustomTextComponent component, String text) {
        String[] parts = text.split(WORD_PUNCTUATION_REGEX);

        for (String part : parts) {
            ComponentType type = part.matches("\\p{Punct}+") ? ComponentType.PUNCTUATION : ComponentType.WORD;
            CustomTextComponent partComponent = new TextComposite(type);
            component.add(partComponent);

            for (char ch : part.toCharArray()) {
                partComponent.add(new SymbolLeaf(ch, ComponentType.SYMBOL));
            }
        }
    }
}
