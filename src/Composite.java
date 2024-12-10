import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void render(ViewStrategy strategy, HttpResponse response) {
        strategy.renderCompositeStart(response);
        for (Component child : children) {
            child.render(strategy, response);
        }
        strategy.renderCompositeEnd(response);
    }
}
