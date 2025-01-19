package pe.petstore.sales.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.auth.FirebaseAuth
import pe.petstore.sales.ui.initial.InitialScreen
import pe.petstore.sales.ui.login.LoginScreen
import pe.petstore.sales.ui.signup.SignUpScreen

@Composable
fun NavigationWrapper(navHosController: NavHostController, auth: FirebaseAuth) {
    NavHost(navController = navHosController, startDestination = "initial") {
        composable("initial") {
            InitialScreen(
                navigateToLogin = { navHosController.navigate("login") },
                navigationToSignUp = { navHosController.navigate("signUp") }

            )
        }
        composable("login") {
            LoginScreen(auth)
        }
        composable("signUp") {
            SignUpScreen(auth)
        }
    }
}