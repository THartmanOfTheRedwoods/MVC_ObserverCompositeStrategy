public class HTMLViewStrategy implements ViewStrategy {
    @Override
    public void renderLeaf(String content, HttpResponse response) {
        response.appendToBody("<p>" + content + "</p>");
    }

    @Override
    public void renderCompositeStart(Component component, HttpResponse response) {
        response.appendToBody("<div>");
    }

    @Override
    public void renderCompositeEnd(Component component, HttpResponse response) {
        response.appendToBody("</div>");
    }
}
