package com.javaee.bitlab.db;

import com.javaee.bitlab.db.models.Task;

import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Task> tasks = new ArrayList<>();
    private static long taskId = 6L;

    static {
        tasks.add(new Task(1L, "create web app in JAVA EE", "Создайте конструктор, геттеры и сеттеры. Внутри класса DBManager.java, создайте статический список задач(static ArrayList).", false, "2023-03-31"));
        tasks.add(new Task(2L, "cleaning", "Состояние ответа на задание\tОтветы на задание еще не представлены", false, "2023-07-21"));
        tasks.add(new Task(3L, "swimming", "Щитник серый, или элазмуха берёзовая, или эласмуха берёзовая (лат.  ), — вид клопов рода  из семейства древесных щитников (array). Широко распространённый и обычный лесной палеарктический вид. Встречается от Европы до Сибири и Дальнего", false, "2023-04-11"));
        tasks.add(new Task(4L, "work", "Востока, а также в Закавказье, Турции, Казахстане, Монголии и Китае. Клопы среднего размера, длина тела имаго может достигать 6—9 миллиметров. Окраска варьирует: красновато-коричневая, серо-зелёная с тёмными отметинами. Самцы меньше самок. Питаются на различных древесных растениях, в том числе на берёзе, ольхе, буке, падубе, ели и других. Высасывают соки плодов и семян, в результате чего снижается их всхожесть.", false, "2023-05-21"));
        tasks.add(new Task(5L, "eating", "Для вида зафиксирована материнская забота (поведение по охране яиц и личинок-нимф). После яйцекладки самка стоит над кладкой яиц и защищает её на протяжении всего развития яиц. Репертуар защитного поведения самок, стоящих над пакетом яиц, включает в себя взмахи крыльями", false, "2023-01-23"));
    }

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static void addTask(Task task) {
        task.setId(taskId);
        tasks.add(task);
        taskId++;
    }

    public static Task getTask(Long id) {
        return tasks.stream().filter(task -> task.getId() == id).findAny().orElse(null);
    }

    public static void updateTask(Long taskId, boolean done, String deadline, String description, String name) {
        Task task = getTask(taskId);
        task.setDone(done);
        task.setDeadline(deadline);
        task.setDescription(description);
        task.setName(name);
    }

    public static void deleteTask(Long id) {
        tasks.removeIf(task -> task.getId() == id);
    }
}
