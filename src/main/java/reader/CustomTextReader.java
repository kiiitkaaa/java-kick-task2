package reader;

import exception.TextException;

public interface CustomTextReader {
    String readText(String filePath) throws TextException;
}
