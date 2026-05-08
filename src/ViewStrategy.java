public interface ViewStrategy {
    void renderLeaf(String content, HttpResponse response);

    void renderCompositeStart(Component component, HttpResponse response);

    void renderCompositeEnd(Component component, HttpResponse response);
}
