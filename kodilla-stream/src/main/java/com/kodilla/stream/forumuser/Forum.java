package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(001, "jan.nowak", 'M', 2000, 01, 01, 2));
        userList.add(new ForumUser(002, "kowalski.artur", 'M', 1978, 03, 30, 0));
        userList.add(new ForumUser(003, "marlena.dmowska", 'F', 1992, 05, 23, 10));
        userList.add(new ForumUser(004, "dawid.szpak", 'M', 1970, 11, 04, 5));
        userList.add(new ForumUser(005, "penelopa.adamska", 'F', 1995, 06, 14, 0));
        userList.add(new ForumUser(006, "ewelina.lisowska", 'F', 1998, 07, 23, 12));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}
