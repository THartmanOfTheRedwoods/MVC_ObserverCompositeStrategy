public interface Subject {
    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObservers();

    Object getState();

    void setState(Object state);
}
