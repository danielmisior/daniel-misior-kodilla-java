package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().getTasks().add("To do");
        board.getInProgressList().getTasks().add("In progress");
        board.getDoneList().getTasks().add("Done");

        String toDoResult = board.getToDoList().getTasks().get(0);
        String inProgressResult = board.getInProgressList().getTasks().get(0);
        String doneResult = board.getDoneList().getTasks().get(0);

        //Then
        assertEquals(toDoResult, "To do");
        assertEquals(inProgressResult, "In progress");
        assertEquals(doneResult, "Done");

        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }
}
