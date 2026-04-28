package service;

import java.util.List;
import entity.CustomTextComponent;

public interface SentenceSortService {
    List<CustomTextComponent> sortByLetterCount(CustomTextComponent customTextComponent, char targetLetter);
}
