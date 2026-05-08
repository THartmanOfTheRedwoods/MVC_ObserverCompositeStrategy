import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public abstract class BaseRouteHandler implements RouteHandler {

    @Override
    public final void handle(HttpExchange exchange) throws IOException {
        HttpRequest request = new HttpRequest(exchange);
        HttpResponse response = new HttpResponse(exchange);
        Controller controller = new Controller(response);

        // Content negotiation is shared infrastructure — lives here, not in every subclass
        if ("application/json".equals(request.getHeader("Accept"))) {
            controller.setViewStrategy(new JSONViewStrategy());
            response.setContentType("application/json; charset=UTF-8");
        } else {
            controller.setViewStrategy(new HTMLViewStrategy());
            response.setContentType("text/html; charset=UTF-8");
        }

        Subject model = createModel();
        Component rootView = buildView();

        Observer observer = new ConcreteObserver(rootView, controller);
        observer.setSubject(model);
        model.register(observer);

        // Subclass decides what state change triggers the render
        handleRequest(request, model);

        response.send();
    }

    // --- Template methods — subclasses define what varies ---

    /** Return the model (Subject) for this route. */
    protected abstract Subject createModel();

    /** Build and return the initial Composite view tree for this route. */
    protected abstract Component buildView();

    /** Trigger the model state change that fires the observer and renders the view. */
    protected abstract void handleRequest(HttpRequest request, Subject model);
}