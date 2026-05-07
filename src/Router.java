import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public class Router {
    public void routeRequest(HttpExchange exchange) throws IOException {
        HttpRequest request = new HttpRequest(exchange);
        HttpResponse response = new HttpResponse(exchange);

        Controller controller = new Controller(response);
        Subject model = new ConcreteSubject();

        // Build Composite Application View — unchanged
        Component rootView = new Composite();
        rootView.add(new Leaf("Welcome to our website!"));
        rootView.add(new Leaf("Here is some content."));

        // Choose strategy based on Accept header, and set the matching Content-Type
        if ("application/json".equals(request.getHeader("Accept"))) {
            controller.setViewStrategy(new JSONViewStrategy());
            response.setContentType("application/json; charset=UTF-8");
        } else {
            controller.setViewStrategy(new HTMLViewStrategy());
            response.setContentType("text/html; charset=UTF-8");
        }

        // Wire Observer — unchanged
        Observer observer = new ConcreteObserver(rootView, controller);
        observer.setSubject(model);
        model.register(observer);

        // Trigger model update → notifies observer → controller renders view into response
        model.setState("New State");

        // NOW flush the buffered response body to the real HTTP connection
        response.send();
    }
}