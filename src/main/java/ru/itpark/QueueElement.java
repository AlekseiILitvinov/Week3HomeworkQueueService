package ru.itpark;

public class QueueElement {
    private Person customer;
    private QueueElement nextElement;

    public QueueElement(Person customer) {
        this.customer = customer;
    }

    public QueueElement getNextElement() {
        return nextElement;
    }

    public void setNextElement(QueueElement nextElement) {
        this.nextElement = nextElement;
    }
}
