package com.deshko.task2.reader;

import com.deshko.task2.exception.TextException;

public interface CustomTextReader {
    String readText(String filePath) throws TextException;
}
