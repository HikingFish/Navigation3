package com.example.navigation3.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.navigation3.screens.TodoDetailScreen
import com.example.navigation3.screens.TodoListScreen

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
){
    val backStack = rememberNavBackStack(
        Route.TodoList
    )
    Scaffold (
        modifier = modifier,
        bottomBar = {
            TodoNavigationBar(
                selectedKey = Route.TodoList,
                onSelectKey = {
                    // TODO: Select key
                }
            )
        }
    ) { innerPadding ->
            NavDisplay(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                backStack = backStack,
                entryDecorators = listOf(
                    rememberSaveableStateHolderNavEntryDecorator(),
                    rememberViewModelStoreNavEntryDecorator()
                ),
                entryProvider = entryProvider {
                    entry<Route.TodoList> {
                        TodoListScreen(
                            onTodoClick = {
                                backStack.add(Route.TodoDetail(it))
                            }
                        )
                    }
                    entry<Route.TodoFavorite> {
                        TodoListScreen(
                            onTodoClick = {
                                backStack.add(Route.TodoDetail(it))
                            }
                        )
                    }
                    entry<Route.TodoDetail> {
                        TodoDetailScreen(
                            todo = it.todo
                        )
                    }
                    entry<Route.Settings> {
                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Settings")
                        }
                    }
                }
            )
    }

}