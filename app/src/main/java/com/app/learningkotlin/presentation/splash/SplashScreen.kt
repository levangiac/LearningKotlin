package com.app.learningkotlin.presentation.splash


import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.app.learningkotlin.R
import com.app.learningkotlin.presentation.Screen
import com.app.learningkotlin.presentation.ui.theme.ColorBackgroundLauncher
import com.app.learningkotlin.presentation.ui.theme.DarkGray
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
 var startAnimation by remember { mutableStateOf(false) }
 val alphaAnim = animateFloatAsState(
  targetValue = if (startAnimation) 1f else 0f,
  animationSpec = tween(
   durationMillis = 3000
  )
 )
 val systemUiController = rememberSystemUiController()
 val useDarkIcons = isSystemInDarkTheme()
 LaunchedEffect(key1 = true) {
  startAnimation = true
  delay(4000)
  navController.popBackStack()
  navController.navigate(Screen.CoinListScreen.router)
  systemUiController.setSystemBarsColor(color = DarkGray,
   darkIcons = useDarkIcons)
  systemUiController.setNavigationBarColor(color = DarkGray,
   darkIcons = useDarkIcons)
 }
 Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha:Float) {
 Box(modifier = Modifier
  .background(ColorBackgroundLauncher)
  .fillMaxSize(),
  contentAlignment = Alignment.Center
 )
 {
  Image(
   painter = painterResource(R.drawable.ic_launcher),
   contentDescription = "LogoIcon",
   modifier = Modifier
    .fillMaxSize()
    .alpha(alpha = alpha),
  )
 }
}
@Composable
@Preview
fun SplashScreenPreview() {
 Splash(alpha = 1f)
}
