public class ConcreteObserver implements Observer {
    private Subject subject;
    private final Component viewRoot;
    private final Controller controller;

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
        // This is where we would use this.subject, or parameters passed to this.update() to create a child Component
        // based off the model/subject changes. Then add it to the viewRoot below. In this case we just add a MADE UP
        // string, pretending to do the model state changes.
        viewRoot.add(new Leaf("Cool, Model driven, Child View Stuff"));
        viewRoot.add(new Leaf(subject.getState().toString()));
        // Render to response.
        controller.renderView(viewRoot);
    }
}
