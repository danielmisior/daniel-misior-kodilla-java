package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String mentorName;
    private int updateTaskCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void updateTask(TaskQueue taskQueue) {
        if (taskQueue.getTasks().size() == 1) {
            System.out.println(mentorName + ": New task created by " + taskQueue.getTaskCreator() + "\n" +
                    "(Total: " + taskQueue.getTasks().size() + " task)");
            updateTaskCount++;
        } else {
            System.out.println(mentorName + ": new task created by " + taskQueue.getTaskCreator() + "\n" +
                    "(Total: " + taskQueue.getTasks().size() + " tasks)");
            updateTaskCount++;
        }
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateTaskCount() {
        return updateTaskCount;
    }
}
