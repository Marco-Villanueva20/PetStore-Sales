package pe.petstore.sales

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import pe.petstore.sales.ui.navigation.NavigationWrapper
import pe.petstore.sales.ui.theme.PetStoreTheme

class MainActivity : ComponentActivity() {

    private lateinit var navHosController: NavHostController
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        //enableEdgeToEdge()
        setContent {
            navHosController = rememberNavController()
            PetStoreTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    NavigationWrapper(navHosController, auth)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser: FirebaseUser? = auth.currentUser
        if (currentUser != null) {
            Log.i("MyApp", "Navegar a la home")
        } else {
            Log.i("MyApp", "Usuario KO")
        }
    }
}

