package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    Todos todos = new Todos();
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

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
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {


        Task[] expected = {simpleTask, epic, meeting};
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

}