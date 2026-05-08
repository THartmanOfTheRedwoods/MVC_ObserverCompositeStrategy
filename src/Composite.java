import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> children = new ArrayList<>();
    private String name;

    public Composite() {
        this.name = "";
    }

    public Composite(String name) {
        this.name = name;
    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void render(ViewStrategy strategy, HttpResponse response) {
        strategy.renderCompositeStart(this, response);
        for (Component child : children) {
            child.render(strategy, response);
        }
        strategy.renderCompositeEnd(this, response);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
