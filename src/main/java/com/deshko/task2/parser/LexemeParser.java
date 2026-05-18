package com.deshko.task2.parser;

import com.deshko.task2.entity.CustomTextComponent;
import com.deshko.task2.entity.TextComposite;
import com.deshko.task2.entity.ComponentType;

public class LexemeParser extends AbstractTextParser{
    private static final String LEXEME_REGEX = "\\s+";
    private static final LexemeParser INSTANCE = new LexemeParser(WordParser.getInstance());

    private LexemeParser(TextParser nextParser) {
        super(nextParser);
    }

    public static LexemeParser getInstance() {
        return INSTANCE;
    }

    @Override
    public void parse(CustomTextComponent component, String text) {
        String[] lexemes = text.split(LEXEME_REGEX);

        for (String lexeme : lexemes) {
            CustomTextComponent lexemeComponent = new TextComposite(ComponentType.LEXEME);
            component.add(lexemeComponent);

            if (nextParser != null) {
                nextParser.parse(lexemeComponent, lexeme);
            }
        }
    }
}
