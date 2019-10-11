package ru.itpark;

import java.util.Objects;

public class QueueService {
    private QueueElement current;

    //Testability
    public QueueElement getCurrent() {
        return current;
    }

    public Person serveCurrent() {
        QueueElement served = current;
        this.current = served.getNextElement();
        return served.getCustomer();
    }

    private QueueElement getLastElement() {
        QueueElement currentElement = current;
        while (!Objects.isNull(currentElement.getNextElement())) {
            currentElement = currentElement.getNextElement();
        }
        return currentElement;
    }

    public void addToQueue(Person person) {
        if (Objects.isNull(current)) {
            current = new QueueElement(person);
        } else {
            QueueElement newElement = new QueueElement(person);
            QueueElement lastElement = getLastElement();
            lastElement.setNextElement(newElement);
        }
    }

    public int countNumberOfElements() {
        if (Objects.isNull(current)) {
            return 0;
        }
        QueueElement currentElement = current;
        int counter = 1;
        while (!Objects.isNull(currentElement.getNextElement())) {
            counter += 1;
            currentElement = currentElement.getNextElement();
        }
        return counter;
    }
}
