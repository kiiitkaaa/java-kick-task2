package com.deshko.task2.service;

import java.util.List;
import com.deshko.task2.entity.CustomTextComponent;

public interface SentenceSortService {
    List<CustomTextComponent> sortByLetterCount(CustomTextComponent customTextComponent, char targetLetter);
}
