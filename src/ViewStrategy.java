public interface ViewStrategy {
    void renderLeaf(String content, HttpResponse response);

    void renderCompositeStart(HttpResponse response);

    void renderCompositeEnd(HttpResponse response);
}
