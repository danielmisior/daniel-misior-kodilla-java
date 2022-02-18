package com.kodilla.testing.statistics;

import java.util.List;

public class StatisticsCounter {

    private Statistics statistics;

    public void calculateAdvStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public String showStatistics() {
        return "Number of users: " + getUsersQuantity() +
                "\n Number of posts: " + getPostsQuantity() +
                "\n Number of comments: " + getCommentsQuantity() +
                "\n Average of posts per user: " + getAveragePostsPerUser() +
                "\n Average of comments per user: " + getAverageCommentsPerUser() +
                "\n Average of comments per post: " + getAverageCommentsPerPost();
    }

    public List<String> getUsers() {
        return statistics.usersNames();
    }

    public int getUsersQuantity() {
        return statistics.usersNames().size();
    }

    public int getPostsQuantity() {
        return statistics.postsCount();
    }

    public int getCommentsQuantity() {
        return statistics.commentsCount();
    }

    public double getAveragePostsPerUser() {
        return (double) statistics.postsCount() / (double) statistics.usersNames().size();
    }

    public double getAverageCommentsPerUser() {
        return (double) statistics.commentsCount() / (double) statistics.usersNames().size();
    }

    public double getAverageCommentsPerPost() {
        return (double) statistics.commentsCount() / (double) statistics.postsCount();
    }
}
