package com.deshko.task2.util;

import com.deshko.task2.entity.CustomTextComponent;
import com.deshko.task2.entity.ComponentType;
import com.deshko.task2.entity.TextComposite;
import java.util.List;
import java.util.ArrayList;

public final class ComponentUtil {
    private ComponentUtil () {}

    public static List<CustomTextComponent> getComponentsByType(CustomTextComponent component, ComponentType type) {
        List<CustomTextComponent> result = new ArrayList<>();
        if (component.getType() == type) {
            result.add(component);
        } else if (component instanceof TextComposite) {
            for (CustomTextComponent child : component.getChildren()) {
                result.addAll(getComponentsByType(child, type));
            }
        }
        return result;
    }
}
