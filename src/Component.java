public interface Component {
    void add(Component component);
    void remove(Component component);
    void render(ViewStrategy strategy, HttpResponse response);
}
