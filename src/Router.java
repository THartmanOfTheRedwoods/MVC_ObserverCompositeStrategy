public class Router {
    public void routeRequest(HttpRequest request, HttpResponse response) {
        Controller controller = new Controller(response); // The client creates the Strategy Context
        // The Model (or Observer Subject) for the Strategy renderer is also created.
        ConcreteSubject model = new ConcreteSubject();

        // Build Composite Application View
        // The root view, which is a Composite Pattern for the whole page is also created.
        // This will be the same for every route request.
        Composite rootView = new Composite();
        rootView.add(new Leaf("Welcome to our website!"));
        rootView.add(new Leaf("Here is some content."));

        // Based on user input, a strategy for rendering the view is chosen and set in the Controller(Strategy Context)
        if ("application/json".equals(request.getHeader("Accept"))) {
            controller.setViewStrategy(new JSONViewStrategy());
        } else {
            controller.setViewStrategy(new HTMLViewStrategy());
        }

        // The Observer(View) is linked to the root Composite Application View so it can be rendered
        ConcreteObserver observer = new ConcreteObserver(rootView, controller);
        observer.setSubject(model);
        model.register(observer);

        // Trigger model updates
        model.setState("New State");
        // Observer will automatically render the view through the controller upon notification
    }
}
