package com.deshko.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.deshko.task2.parser.ParagraphParser;
import com.deshko.task2.reader.impl.CustomTextReaderImpl;
import com.deshko.task2.entity.CustomTextComponent;
import com.deshko.task2.entity.TextComposite;
import com.deshko.task2.entity.ComponentType;
import com.deshko.task2.service.impl.DuplicateWordServiceImpl;
import com.deshko.task2.service.impl.LexemeSwapServiceImpl;
import com.deshko.task2.service.impl.SentenceSortServiceImpl;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Application started.");

        CustomTextReaderImpl reader = new CustomTextReaderImpl();
        String filePath = "data/text.txt";

        try {
            logger.info("Reading file from path: {}", filePath);
            String rawText = reader.readText(filePath);

            logger.info("Starting text parsing process");
            CustomTextComponent root = new TextComposite(ComponentType.TEXT);
            ParagraphParser.getInstance().parse(root, rawText);
            logger.info("Parsing completed successfully.");

            logger.info("Start text before modifications:");
            logger.info("\n{}", root.reconstruct());

            int letters = root.countLetters();
            int totalSymbols = root.countSymbols();
            logger.info("Text Statistics -> Letters: {}, Total Symbols: {}", letters, totalSymbols);

            DuplicateWordServiceImpl duplicateService = new DuplicateWordServiceImpl();
            int maxSentences = duplicateService.findMaxSentencesWithSameWord(root);
            logger.info("Task 1: Max sentences with duplicate words found: {}", maxSentences);

            SentenceSortServiceImpl sortService = new SentenceSortServiceImpl();
            char targetChar = 'a';
            List<CustomTextComponent> sortedSentences = sortService.sortByLetterCount(root, targetChar);
            logger.info("Task 2: Sentences sorted by occurrence of '{}':", targetChar);
            for (CustomTextComponent sentence : sortedSentences) {
                logger.info("-> {}", sentence.reconstruct());
            }

            LexemeSwapServiceImpl swapService = new LexemeSwapServiceImpl();
            logger.info("Task 3: Swapping first and last lexemes in every sentence...");
            swapService.swapFirstAndLastLexemes(root);

            logger.info("Final reconstructed text after modifications:");
            logger.info("\n{}", root.reconstruct());


        } catch (Exception e) {
            logger.error("Error: ", e);
        }

        logger.info("Application finished.");
    }
}
