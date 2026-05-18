package com.deshko.task2.service.impl;

import com.deshko.task2.service.SentenceSortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.deshko.task2.entity.CustomTextComponent;
import com.deshko.task2.entity.ComponentType;
import com.deshko.task2.util.ComponentUtil;

import java.util.List;

public class SentenceSortServiceImpl implements SentenceSortService {
    private static final Logger logger = LogManager.getLogger(SentenceSortServiceImpl.class);


    @Override
    public List<CustomTextComponent> sortByLetterCount(CustomTextComponent customTextComponent, char targetLetter) {
        List<CustomTextComponent> sentences = ComponentUtil.getComponentsByType(customTextComponent, ComponentType.SENTENCE);
        final char lowerTarget = Character.toLowerCase(targetLetter);

        sentences.sort((s1, s2) -> {
            int count1 = countLetterInComponent(s1, lowerTarget);
            int count2 = countLetterInComponent(s2, lowerTarget);
            return Integer.compare(count1, count2);
        });

        logger.info("The suggestions are sorted by letter: '{}'", targetLetter);
        return sentences;
    }

    private int countLetterInComponent(CustomTextComponent component, char targetLetter) {
        int count = 0;
        String text = component.reconstruct().toLowerCase();
        for (char c : text.toCharArray()) {
            if (c == targetLetter) {
                count++;
            }
        }
        return count;
    }
}
