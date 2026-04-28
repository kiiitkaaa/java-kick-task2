package entity;

public abstract class AbstractComponent implements CustomTextComponent {
    protected final ComponentType type;

    public AbstractComponent(ComponentType type) {
        this.type = type;
    }

    @Override
    public ComponentType getType() {
        return type;
    }
}
