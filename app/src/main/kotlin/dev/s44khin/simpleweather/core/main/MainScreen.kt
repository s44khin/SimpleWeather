package dev.s44khin.simpleweather.core.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.util.fastForEach
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.s44khin.simpleweather.core.navigation.SimpleNavHost
import dev.s44khin.simpleweather.today.navigation.TodayNavigation
import dev.s44khin.simpleweather.today.navigation.todayNavigation
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.widgets.BottomNavigation
import dev.s44khin.simpleweather.uikit.widgets.BottomNavigationItem
import dev.s44khin.simpleweather.week.navigation.WeekNavigation
import dev.s44khin.simpleweather.week.navigation.weekNavigation

private val bottomNavigationItems = listOf(TodayNavigation, WeekNavigation)

@Composable
internal fun MainScreen(
    navHostController: NavHostController,
    onAction: (MainAction) -> Unit,
) {
    val asd = rememberNavController()
    SimpleTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = SimpleTheme.colors.root)
        ) {
            SimpleNavHost(
                navController = navHostController,
                startDestination = TodayNavigation
            ) {
                todayNavigation()
                weekNavigation()
            }

            BottomNavigation(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                val navBackStackEntry by navHostController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                bottomNavigationItems.fastForEach { item ->
                    BottomNavigationItem(
                        selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                        icon = item.icon,
                        label = item.label.resolve(),
                        onClick = { onAction(MainAction.OnBottomNavigationClicked(item)) }
                    )
                }
            }
        }
    }
}