package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    Task task = new Task(1);

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void shouldMatchSimpleTask() {
        String query = "Позвонить родителям";
        Assertions.assertTrue(simpleTask.matches(query));
    }

    @Test
    public void shouldMatchTask() {
        String query = "Позвонить родителям";
        Assertions.assertFalse(task.matches(query));
    }

    @Test
    public void shouldMatchEpic() {
        String query = "Молоко";
        Assertions.assertTrue(epic.matches(query));
    }

    @Test
    public void shouldMatchMeeting() {
        String query = "Приложение НетоБанка";
        Assertions.assertTrue(meeting.matches(query));
    }
}
