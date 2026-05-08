public interface Component {
    String getName();
    void setName(String set);
    void add(Component component);
    void remove(Component component);
    void render(ViewStrategy strategy, HttpResponse response);
}
