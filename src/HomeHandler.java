public class HomeHandler extends BaseRouteHandler {

    @Override
    protected Subject createModel() {
        return new ConcreteSubject();
    }

    @Override
    protected Component buildView() {
        Component root = new Composite();  // This would be a Root Theme Template Composite for a consistent look
        root.add(new Leaf("Welcome to our website!"));
        root.add(new Leaf("Here is some content."));
        return root;
    }

    @Override
    protected void handleRequest(HttpRequest request, Subject model) {
        model.setState("Home page loaded");
    }
}