public class ConcreteObserver implements Observer {
    private Subject subject;

    @Override
    public void update() {
        System.out.println("Observer notified. State: " + subject.getState());
    }

    @Override
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
