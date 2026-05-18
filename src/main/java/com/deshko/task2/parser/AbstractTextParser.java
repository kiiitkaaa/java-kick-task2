package com.deshko.task2.parser;

public abstract class AbstractTextParser implements TextParser {
    protected TextParser nextParser;

    public AbstractTextParser(TextParser nextParser) {
        this.nextParser = nextParser;
    }
}
