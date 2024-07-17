package com.example.news_app_jetpack_compose_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.news_app_jetpack_compose_mvvm.presentation.onboarding.OnBoardingScreen
import com.example.news_app_jetpack_compose_mvvm.presentation.onboarding.components.OnBoardingPage
import com.example.news_app_jetpack_compose_mvvm.presentation.onboarding.Page
import com.example.news_app_jetpack_compose_mvvm.ui.theme.News_app_jetpack_compose_mvvmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            News_app_jetpack_compose_mvvmTheme(dynamicColor = false){ // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting(stringResource(id = R.string.onboarding_description1))
                    OnBoardingScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    News_app_jetpack_compose_mvvmTheme {
        Greeting("Android")
    }
}