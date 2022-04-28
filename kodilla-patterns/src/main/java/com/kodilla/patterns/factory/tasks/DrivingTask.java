package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {

    private final String taskName;
    private final String where;
    private final String using;
    private boolean taskCompleted = true;

    public DrivingTask(final String taskName, final String where, final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() {
        if(taskCompleted) {
            System.out.println("Task " + taskName + " has been completed.");
        } else {
            System.out.println("Task " + taskName + " could not be completed.");
            taskCompleted = false;
        }
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return taskCompleted;
    }
}
