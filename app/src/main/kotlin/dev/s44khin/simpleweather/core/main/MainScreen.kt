package dev.s44khin.simpleweather.core.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import dev.s44khin.simpleweather.common.core.navigation.commonNavigation
import dev.s44khin.simpleweather.core.navigation.SimpleNavHost
import dev.s44khin.simpleweather.settings.core.navigation.SettingsNavigation
import dev.s44khin.simpleweather.settings.core.navigation.settingsNavigation
import dev.s44khin.simpleweather.today.core.navigation.TodayNavigation
import dev.s44khin.simpleweather.today.core.navigation.todayNavigation
import dev.s44khin.simpleweather.uikit.theme.SimpleTheme
import dev.s44khin.simpleweather.uikit.widgets.BottomNavigation
import dev.s44khin.simpleweather.uikit.widgets.BottomNavigationItem
import dev.s44khin.simpleweather.week.navigation.WeekNavigation
import dev.s44khin.simpleweather.week.navigation.weekNavigation

private val bottomNavigationItems = listOf(TodayNavigation, WeekNavigation, SettingsNavigation)

@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
internal fun MainScreen(
    state: MainUiState,
    navHostController: NavHostController,
    bottomSheetNavigator: BottomSheetNavigator,
    onAction: (MainAction) -> Unit,
) {
    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator,
        sheetBackgroundColor = Color.Transparent,
        sheetElevation = 0.dp,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = SimpleTheme.colors.root)
        ) {
            SimpleNavHost(
                navController = navHostController,
                startDestination = TodayNavigation,
            ) {
                commonNavigation()
                todayNavigation()
                weekNavigation()
                settingsNavigation()
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
                        alwaysShowLabel = state.alwaysShowLabel,
                        onClick = { onAction(MainAction.OnBottomNavigationClicked(item)) }
                    )
                }
            }
        }
    }
}