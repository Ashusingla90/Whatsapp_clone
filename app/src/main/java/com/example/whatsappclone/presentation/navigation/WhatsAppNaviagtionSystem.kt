package com.example.whatsappclone.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatsappclone.presentation.callscreen.CallScreen
import com.example.whatsappclone.presentation.communitiesscreen.CommunitiesScreen
import com.example.whatsappclone.presentation.homescreen.HomeScreen
import com.example.whatsappclone.presentation.profile.UserProfileScreen
import com.example.whatsappclone.presentation.splashscreen.SplashScreen
import com.example.whatsappclone.presentation.updatescreen.UpdateScreen
import com.example.whatsappclone.presentation.userregistrationscreen.UserRegistrationScreen
import com.example.whatsappclone.presentation.welcomescreen.WelcomeScreen
import com.example.whatsappclone.viewmodel.BaseViewModel

@Composable
fun WhatsAppNavigationSystem() {

    val navController = rememberNavController()

    NavHost(startDestination = Routes.SplashScreen, navController = navController){
        composable <Routes.SplashScreen>{
            SplashScreen(navController)
        }

        composable <Routes.WelcomeScreen>{
            WelcomeScreen(navController)
        }

        composable <Routes.UserRegistrationScreen>{
            UserRegistrationScreen(navController )
        }

        composable <Routes.HomeScreen>{
            val baseViewModel: BaseViewModel = hiltViewModel()
            HomeScreen(navController,baseViewModel)
        }


        composable <Routes.UpdateScreen>{
            UpdateScreen(navController)
        }

        composable <Routes.CommunitiesScreen>{
            CommunitiesScreen(navController)
        }
        composable <Routes.CallScreen>{
            CallScreen(navController)
        }
        
        composable<Routes.UserProfileScreen> {
            UserProfileScreen( navHostController = navController)
        }
    }
}

