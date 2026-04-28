package service;

import entity.CustomTextComponent;

public interface DuplicateWordService {
    int findMaxSentencesWithSameWord(CustomTextComponent customTextComponent);
}
