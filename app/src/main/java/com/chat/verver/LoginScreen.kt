package com.chat.verver

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.*


import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.graphics.Color
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.ui.platform.LocalContext
import com.chat.verver.ui.theme.colorfocusing
import com.chat.verver.ui.theme.colorunfocus
import com.chat.verver.ui.theme.textcolor

@SuppressLint("UnusedBoxWithConstraintsScope")

@Composable

fun LoginScreen(navController: NavController){

    var username by remember { mutableStateOf("") }
    var password by remember {mutableStateOf("")}

    var passwordvisible by remember {mutableStateOf(false)}

    val fonttitr= FontFamily(Font(R.font.titr))
    val fontvazir= FontFamily(Font(R.font.vazirlight))

    var isError by remember { mutableStateOf(false) }

BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
    val screenHeight=maxHeight
    val screenWidth=maxWidth


    Column(

        modifier = Modifier.fillMaxSize().padding(horizontal = screenWidth * 0.1f).offset(y=-screenHeight*0.2f),
        verticalArrangement = Arrangement.Center,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ورورلاگین",
            fontSize = (screenHeight*0.03f).value.sp,
            textAlign = TextAlign.Center,
            fontFamily = fonttitr


        )


        Spacer(modifier = Modifier.height(screenHeight * 0.02f))


        OutlinedTextField(
            value = username,
            onValueChange = { username = it
                isError=false},
            label = { Text("نام کاربری" , color=if(isError)Color.Red else Color.Gray) },
            colors = OutlinedTextFieldDefaults.colors( focusedBorderColor = colorfocusing, unfocusedBorderColor = colorunfocus
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
           // textcolor=Color.Unspecified,
            textStyle = TextStyle(fontFamily = fontvazir, color = Color.Black)

        )


        Spacer(modifier = Modifier.height(screenHeight*0.02f))


        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("رمز کاربری" , color=if (isError)Color.Red else Color.Gray) },
colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = colorfocusing, unfocusedBorderColor = colorunfocus),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            visualTransformation=if(passwordvisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon={
                val icon=if(passwordvisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description=if(passwordvisible)"off" else "on"
                IconButton(onClick = {passwordvisible=!passwordvisible}) { Icon(imageVector = icon, contentDescription = description)}
            },



            modifier = Modifier.fillMaxWidth(),
          //  textcolor=Color.Unspecified,
            textStyle= TextStyle(fontFamily=fontvazir, color = Color.Black)
        )


        Spacer(modifier = Modifier.height(screenHeight*0.03f))

        val context=LocalContext.current
        Button(
            onClick = {
                isError=true

                if (password==username) {

                    isError=false

                    Toast.makeText(context,"ok", Toast.LENGTH_SHORT).show()
                    navController.navigate("home")

                }//if


            },


            modifier = Modifier.fillMaxWidth(),
            colors= ButtonDefaults.buttonColors(
                containerColor = colorfocusing,
                contentColor = Color.White,
            ),

        ){ Text("  ورود  ") }


    }// column
}//BoxWithconstraint
}
