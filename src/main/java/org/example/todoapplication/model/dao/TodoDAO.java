package org.example.todoapplication.model.dao;

import org.example.todoapplication.model.Todo;

import java.sql.SQLException;
import java.util.List;

public interface TodoDAO {
    void insertTodo(Todo todo) throws SQLException;

    Todo selectTodo(long todoId);

    List<Todo> selectAllTodos();

    boolean deleteTodo(int id) throws SQLException;

    boolean updateTodo(Todo todo) throws SQLException;
}
