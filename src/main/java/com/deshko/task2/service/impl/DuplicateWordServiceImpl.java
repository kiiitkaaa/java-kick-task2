package com.deshko.task2.service.impl;

import com.deshko.task2.service.DuplicateWordService;
import com.deshko.task2.entity.CustomTextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import com.deshko.task2.util.ComponentUtil;
import com.deshko.task2.entity.ComponentType;

public class DuplicateWordServiceImpl implements DuplicateWordService {
    private static final Logger logger = LogManager.getLogger(DuplicateWordServiceImpl.class);

    @Override
    public int findMaxSentencesWithSameWord(CustomTextComponent customTextComponent) {
        Map<String, Set<CustomTextComponent>> wordToSentencesMap = new HashMap<>();
        List<CustomTextComponent> sentences = ComponentUtil.getComponentsByType(customTextComponent, ComponentType.SENTENCE);

        for (CustomTextComponent sentence : sentences) {
            List<CustomTextComponent> words = ComponentUtil.getComponentsByType(sentence, ComponentType.WORD);
            for (CustomTextComponent word : words) {
                String wordStr = word.reconstruct().toLowerCase();
                wordToSentencesMap.computeIfAbsent(wordStr, _ -> new HashSet<>()).add(sentence);
            }
        }

        int max = 0;
        for (Set<CustomTextComponent> set : wordToSentencesMap.values()) {
            if (set.size() > max) {
                max = set.size();
            }
        }
        logger.info("The maximum number of sentences containing the same word: {}", max);
        return max;
    }
}
