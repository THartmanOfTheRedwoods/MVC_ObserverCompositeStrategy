public class Controller {
    private ViewStrategy viewStrategy;
    private HttpResponse response;

    public Controller(HttpResponse response) {
        this.response = response;
    }

    public void setViewStrategy(ViewStrategy viewStrategy) {
        this.viewStrategy = viewStrategy;
    }

    public void renderView(Component view) {
        if (viewStrategy == null) {
            throw new IllegalStateException("No ViewStrategy set");
        }
        view.render(viewStrategy, response);
    }
}
