package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    Todos todos = new Todos();
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
    SimpleTask simpleTask2 = new SimpleTask(2, "Позвонить друзьям");


    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @BeforeEach
    public void setup() {

        todos.add(simpleTask);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldAddFourTasksOfDifferentType() {


        Task[] expected = {simpleTask, simpleTask2, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMeeting() {
        String query = "Приложение НетоБанка";
        Task[] actual = todos.search(query);
        Task[] expected = {meeting};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindEpic() {
        String query = "Молоко";
        Task[] actual = todos.search(query);
        Task[] expected = {epic};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindSimpleTask() {
        String query = "Позвонить родителям";
        Task[] actual = todos.search(query);
        Task[] expected = {simpleTask};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindMultiple() {
        String query = "Позвонить";
        Task[] actual = todos.search(query);
        Task[] expected = {simpleTask, simpleTask2};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindNothing() {
        String query = "Пойти гулять";
        Task[] actual = todos.search(query);
        Task[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}