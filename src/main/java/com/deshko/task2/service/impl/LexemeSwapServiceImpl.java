package com.deshko.task2.service.impl;

import com.deshko.task2.entity.ComponentType;
import com.deshko.task2.entity.CustomTextComponent;
import com.deshko.task2.service.LexemeSwapService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.deshko.task2.util.ComponentUtil;
import java.util.ArrayList;
import java.util.List;

public class LexemeSwapServiceImpl implements LexemeSwapService {
    private static final Logger logger = LogManager.getLogger(LexemeSwapServiceImpl.class);

    @Override
    public void swapFirstAndLastLexemes(CustomTextComponent customTextComponent) {
        List<CustomTextComponent> sentences = ComponentUtil.getComponentsByType(customTextComponent, ComponentType.SENTENCE);

        for (CustomTextComponent sentence : sentences) {
            List<CustomTextComponent> lexemes = new ArrayList<>();
            for (CustomTextComponent child : sentence.getChildren()) {
                if (child.getType() == ComponentType.LEXEME) {
                    lexemes.add(child);
                }
            }

            if (lexemes.size() >= 2) {
                CustomTextComponent firstLexeme = lexemes.getFirst();
                CustomTextComponent lastLexeme = lexemes.getLast();

                List<CustomTextComponent> originalChildren = sentence.getChildren();
                for (CustomTextComponent child : originalChildren) {
                    sentence.remove(child);
                }

                for (CustomTextComponent child : originalChildren) {
                    if (child.equals(firstLexeme)) {
                        sentence.add(lastLexeme);
                    } else if (child.equals(lastLexeme)) {
                        sentence.add(firstLexeme);
                    } else {
                        sentence.add(child);
                    }
                }
            }
        }

        logger.info("The first and last lexemes have been successfully swapped in all sentences");
    }
}
