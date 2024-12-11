public class ConcreteObserver implements Observer {
    private Subject subject;
    private Component viewRoot;
    private Controller controller;

    public ConcreteObserver(Component viewRoot, Controller controller) {
        this.viewRoot = viewRoot;
        this.controller = controller;
    }

    @Override
    public void update() {
        System.out.println("Observer notified. Delegating rendering to controller...");
        renderView();
    }

    @Override
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    private void renderView() {
        // Add/Modify Child View content on Model(Subject) event updated(Notify).
        viewRoot.add(new Leaf("Cool, Model driven, Child View Stuff"));
        // Render to response.
        controller.renderView(viewRoot);
    }
}
