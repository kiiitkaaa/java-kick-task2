package com.deshko.task2.service;

import com.deshko.task2.entity.CustomTextComponent;

public interface DuplicateWordService {
    int findMaxSentencesWithSameWord(CustomTextComponent customTextComponent);
}
