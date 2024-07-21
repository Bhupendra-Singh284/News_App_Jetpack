package com.example.news_app_jetpack_compose_mvvm.presentation.main_activity

import android.os.Bundle
import android.util.Log
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.datastore.dataStoreFile
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.example.news_app_jetpack_compose_mvvm.presentation.navigation.NavigationGraph
import com.example.news_app_jetpack_compose_mvvm.presentation.onboarding.OnBoardingViewModel
import com.example.news_app_jetpack_compose_mvvm.presentation.onboarding.OnBoardingEvent.OnGetStartedEvent
import com.example.news_app_jetpack_compose_mvvm.presentation.onboarding.OnBoardingScreen
import com.example.news_app_jetpack_compose_mvvm.ui_theme.News_app_jetpack_compose_mvvmTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val mainViewModel by viewModels<MainActivityViewModel>()
        installSplashScreen().apply {
            setKeepOnScreenCondition(condition = {
                mainViewModel._splashCondition.value })
        }

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            News_app_jetpack_compose_mvvmTheme(dynamicColor = false){ // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        NavigationGraph(startDestination = mainViewModel._startDestination.value)
                }
            }
        }
    }
}

