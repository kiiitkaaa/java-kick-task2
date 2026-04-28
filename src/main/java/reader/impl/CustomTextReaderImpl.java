package reader.impl;

import reader.CustomTextReader;
import exception.TextException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class CustomTextReaderImpl implements CustomTextReader {
    private static final Logger logger = LogManager.getLogger(CustomTextReaderImpl.class);

    @Override
    public String readText(String filePath) throws TextException {
        if (filePath == null) {
            logger.error("File path is null");
            throw new TextException("File path cannot be null");
        }

        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            logger.error("File not found: {}", filePath);
            throw new TextException("File not found:" + filePath);
        }

        try {
            String content = Files.readString(path);
            logger.info("File successfully read. Length: {} characters", content.length());
            return content;
        } catch (IOException e) {
            logger.error("Error reading file: {}", filePath, e);
            throw new TextException("Error reading file", e);
        }
    }
}
