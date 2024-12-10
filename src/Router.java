public class Router {
    // This is the client code for the Strategy pattern.
    public void routeRequest(HttpRequest request, HttpResponse response) {
        Controller controller = new Controller(); // This is the Context object of the strategy Pattern
        ConcreteSubject model = new ConcreteSubject();  // Subject implementation of Observer Pattern

        // This is a View item, and Observer, that needs to update based on Subject change
        ConcreteObserver observer = new ConcreteObserver();
        observer.setSubject(model);
        model.register(observer);

        // Here is where the client decides the strategy it will take based on input.
        if ("application/json".equals(request.getHeader("Accept"))) {
            controller.setViewStrategy(new JSONViewStrategy());
        } else {
            controller.setViewStrategy(new HTMLViewStrategy());
        }

        Composite view = new Composite();
        view.add(new Leaf("Welcome"));
        view.add(new Leaf("Content"));

        model.setState("Updated");
        controller.renderView(view, response);
    }
}
