package entity;

import java.util.List;
import java.util.Collections;

public class SymbolLeaf extends AbstractComponent {
    private final char symbol;

    public SymbolLeaf(char symbol, ComponentType type) {
        super(type);
        this.symbol = symbol;
    }

    @Override
    public List<CustomTextComponent> getChildren() {
        return Collections.emptyList();
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
}
