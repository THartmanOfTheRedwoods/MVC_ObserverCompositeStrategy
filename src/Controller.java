public class Controller {
    private ViewStrategy viewStrategy;

    public void setViewStrategy(ViewStrategy viewStrategy) {
        this.viewStrategy = viewStrategy;
    }

    public void renderView(Component view, HttpResponse response) {
        if (viewStrategy == null) {
            throw new IllegalStateException("No ViewStrategy set");
        }
        view.render(viewStrategy, response);
    }
}
