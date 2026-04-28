package entity;

import java.util.List;
import java.util.ArrayList;

public class TextComposite extends AbstractComponent {
    private final List<CustomTextComponent> components = new ArrayList<>();

    public TextComposite(ComponentType type) {
        super(type);
    }

    @Override
    public void add(CustomTextComponent component) {
        components.add(component);
    }

    @Override
    public void remove(CustomTextComponent component) {
        components.remove(component);
    }

    @Override
    public List<CustomTextComponent> getChildren() {
        return new ArrayList<>(components);
    }

    @Override
    public String reconstruct() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < components.size(); i++) {
            CustomTextComponent component = components.get(i);

            if (component.getType() == ComponentType.PARAGRAPH) {
                if (i != 0) {
                    sb.append("\n");
                }
                sb.append("    ");
            }

            sb.append(component.reconstruct());

            if (i == components.size() - 1) continue;

            switch (component.getType()) {
                case LEXEME:
                case SENTENCE:
                    sb.append(" ");
                    break;
            }
        }

        return sb.toString();
    }
}
