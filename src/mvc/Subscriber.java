package mvc;

public interface Subscriber {
    public void update();

    void update(String msg, Object oldState, Object newState);
}
