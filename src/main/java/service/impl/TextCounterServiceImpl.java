package service.impl;

import service.TextCounterService;
import entity.CustomTextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextCounterServiceImpl implements TextCounterService {
    private static final Logger logger = LogManager.getLogger(TextCounterServiceImpl.class);

    @Override
    public int[] countLettersAndSymbols(CustomTextComponent customTextComponent) {
        int letters = 0;
        int totalSymbols = 0;

        String text = customTextComponent.reconstruct();

        for (char c : text.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                totalSymbols++;
                if (Character.isLetter(c)) {
                    letters++;
                }
            }
        }

        logger.info("Letters: {}, Total characters: {}", letters, totalSymbols);
        return new int[]{letters, totalSymbols};
    }
}
