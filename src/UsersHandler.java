public class UsersHandler extends BaseRouteHandler {

    @Override
    protected Subject createModel() {
        return new ConcreteSubject(); // swap for a UsersSubject when there is one
    }

    @Override
    protected Component buildView() {
        Component root = new Composite();  // This would be a Root Theme Template Composite for a consistent look
        //root.add(new Leaf("Users"));

        Component list = new Composite("Users");
        list.add(new Leaf("Alice"));
        list.add(new Leaf("Bob"));
        root.add(list);

        return root;
    }

    @Override
    protected void handleRequest(HttpRequest request, Subject model) {
        model.setState("Users fetched");
    }
}