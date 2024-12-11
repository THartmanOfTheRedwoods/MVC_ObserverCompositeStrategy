public class Leaf implements Component {
    private String content;

    public Leaf(String content) {
        this.content = content;
    }

    @Override
    public void add(Component component) { } // Dummy method used for Composite, but meaningless to leaf classes

    @Override
    public void remove(Component component) { } // Dummy method used for Composite, but meaningless to leaf classes

    @Override
    public void render(ViewStrategy strategy, HttpResponse response) {
        strategy.renderLeaf(content, response);
    }
}
