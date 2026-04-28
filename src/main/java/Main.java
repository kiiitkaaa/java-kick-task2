import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parser.ParagraphParser;
import reader.impl.CustomTextReaderImpl;
import entity.CustomTextComponent;
import entity.TextComposite;
import entity.ComponentType;
import service.impl.DuplicateWordServiceImpl;
import service.impl.LexemeSwapServiceImpl;
import service.impl.SentenceSortServiceImpl;
import service.impl.TextCounterServiceImpl;
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

            TextCounterServiceImpl counter = new TextCounterServiceImpl();
            int[] counts = counter.countLettersAndSymbols(root);
            logger.info("Text Statistics -> Letters: {}, Total Symbols: {}", counts[0], counts[1]);

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
