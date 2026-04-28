package entity;

import java.util.List;

public interface CustomTextComponent {
    String reconstruct();
    ComponentType getType();
    List<CustomTextComponent> getChildren();
    void add(CustomTextComponent component);
    void remove(CustomTextComponent component);
}
