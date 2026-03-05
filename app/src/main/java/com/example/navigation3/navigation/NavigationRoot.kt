package com.example.navigation3.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.navigation3.auth.AuthNavigation
import com.example.navigation3.screens.TodoNavigation

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
){
    val rootBackStack = rememberNavBackStack(
        //possible to setup if statement to skip (if login)
        Route.Auth
    )
    NavDisplay(
        modifier = modifier,
        backStack = rootBackStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Route.Auth> {
                AuthNavigation(
                    onLogin = {
                        rootBackStack.remove(Route.Auth)
                        rootBackStack.add(Route.Todo)
                    }
                )
            }
            entry<Route.Todo> {
                TodoNavigation()
            }
        }
        //entry<Route.TodoList> {
        //                TodoListScreen(
        //                    onTodoClick = {
        //                        backStack.add(Route.TodoDetail(it))
        //                    }
        //                )
        //            }
        //            entry<Route.TodoDetail>{
        //                TodoDetailScreen(
        //                    todo = it.todo
        //                )
        //            }
    )
}