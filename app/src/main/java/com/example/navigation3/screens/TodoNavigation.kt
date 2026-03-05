package com.example.navigation3.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.navigation3.navigation.Route

@Composable
fun TodoNavigation(
    modifier: Modifier = Modifier
) {
    val todoBackStack = rememberNavBackStack(
        //possible to setup if statement to skip (if login)
        Route.Todo.TodoList
    )
    NavDisplay(
        backStack = todoBackStack,
        modifier = modifier,
        entryProvider = entryProvider {
            entry<Route.Todo.TodoList> {
                TodoListScreen(
                    onTodoClick = {
                        todoBackStack.add(Route.Todo.TodoDetail(it))
                    }
                )
            }
            entry<Route.Todo.TodoDetail> { key ->
                TodoDetailScreen(
                    todo = key.todo
                )
            }
        }
    )
}