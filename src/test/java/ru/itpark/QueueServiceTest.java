package ru.itpark;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueServiceTest {

    @Test
    void serveCurrentNoNext() {
        QueueService service = new QueueService();
        Person person = new Person("Adam");
        service.addToQueue(person);

        Person actual = service.serveCurrent();
        assertEquals(person, actual);
    }

    @Test
    void serveCurrentMoveToNext() {
        QueueService service = new QueueService();
        Person personOne = new Person("Adam");
        service.addToQueue(personOne);
        Person personTwo = new Person("Ben");
        service.addToQueue(personTwo);

        service.serveCurrent();
        Person actual = service.getCurrent().getCustomer();
        assertEquals(personTwo, actual);
    }

    @Test
    void countNumberOfElements() {
        QueueService service = new QueueService();
        Person personOne = new Person("Adam");
        service.addToQueue(personOne);
        Person personTwo = new Person("Ben");
        service.addToQueue(personTwo);
        service.addToQueue(new Person("Cody"));

        int actual = service.countNumberOfElements();
        assertEquals(3,actual);
    }

    @Test
    void countNumberOfElementsZero() {
        QueueService service = new QueueService();

        int actual = service.countNumberOfElements();
        assertEquals(0,actual);
    }
}