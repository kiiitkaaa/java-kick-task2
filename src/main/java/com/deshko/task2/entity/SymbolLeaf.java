package com.deshko.task2.entity;

import java.util.List;

public class SymbolLeaf extends AbstractComponent {
    private final char symbol;

    public SymbolLeaf(char symbol, ComponentType type) {
        super(type);
        this.symbol = symbol;
    }

    @Override
    public List<CustomTextComponent> getChildren() {
        throw new UnsupportedOperationException("List cannot have children");
    }

    @Override
    public String reconstruct() {
        return String.valueOf(symbol);
    }

    @Override
    public void add(CustomTextComponent component) {
        throw new UnsupportedOperationException("List cannot have children");
    }

    @Override
    public void remove(CustomTextComponent component) {
        throw new UnsupportedOperationException("List cannot have children");
    }

    @Override
    public int countLetters() {
        return Character.isLetter(symbol) ? 1 : 0;
    }

    @Override
    public int countSymbols() {
        return !Character.isWhitespace(symbol) ? 1 : 0;
    }
}
