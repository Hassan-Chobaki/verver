package com.chat.verver


import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chat.verver.utils.isUserLoggedIn
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController:NavController){
val FontColor=colorResource(R.color.font_color)
    val context= LocalContext.current
    LaunchedEffect(key1=true)
    {
        delay(2000)
        if(isUserLoggedIn(context))
        {
            navController.navigate("main"){popUpTo ("splash"){inclusive=true} }
        }
        else
        {
            navController.navigate("login"){popUpTo("splash"){inclusive=true} }
        }
    }//LUNCHEDEFFECT

    Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center)
    {Text(text="ورور" , style = TextStyle(color = Color(FontColor.hashCode()), fontSize = 100.sp))}




}


fun isUserLogedIn(context: Context) : Boolean
{
    val sharedPref=context.getSharedPreferences("verver_Prefs", MODE_PRIVATE)
    return sharedPref.getBoolean("is_loged_in",false)
}