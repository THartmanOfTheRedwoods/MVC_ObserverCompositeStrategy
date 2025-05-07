public class Controller {
    private ViewStrategy viewStrategy;
    private final HttpResponse response;

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
        // Delegates to passed in parameter "view" with strategy to render the view into the response.
        view.render(viewStrategy, response);
    }
}
