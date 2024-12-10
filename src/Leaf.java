public class Leaf implements Component {
    private String content;

    public Leaf(String content) {
        this.content = content;
    }

    @Override
    public void render(ViewStrategy strategy, HttpResponse response) {
        strategy.renderLeaf(content, response);
    }
}
