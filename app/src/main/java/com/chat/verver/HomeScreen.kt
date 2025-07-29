package com.chat.verver

import android.R.attr.translationZ
import androidx.annotation.AnyRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import coil.compose.AsyncImage
import kotlin.math.roundToInt

data class User(
    val name: String,
    val avatarRes: Int,
    val isOnline: Boolean
)

val avatars = listOf(
    R.drawable.avatar1,
    R.drawable.avatar2,
    R.drawable.avatar3,
    // ...
)




@Composable
fun HomeScreen(navController: NavController) {

var px: Int=50

    AvatarStack(0, px)
    px=px+20


}//fun





@Composable
fun AvatarStack( xX: Int, yY: Int){
    var index by remember {mutableStateOf(0)}
    var offsetX by remember { mutableStateOf(0f) }
    val animatadeOffsetX by animateFloatAsState(targetValue = offsetX, label = "offsetx animation")
    Box(modifier = Modifier.fillMaxSize()
        .pointerInput(Unit){detectHorizontalDragGestures(onDragEnd =  {  if (offsetX>15 && index>0) index-- else if(offsetX<-15 && index<2)index++
        offsetX=0f}, onHorizontalDrag = {change, dragAmount -> offsetX-=dragAmount} ) },

        contentAlignment = Alignment.Center


        // contentAlignment = Alignment.Center

        ){




                        AsyncImage(avatars[index],
                                                    contentDescription = "Avatar",
                                                    contentScale = ContentScale.Crop,
                                                    modifier = Modifier
                                                                       // .offset(x=xX.dp,y=yY.dp)
                                                                        .offset{IntOffset(animatadeOffsetX.roundToInt(),0)}
                                                                        .size(300.dp)
                                                                        .clip(CircleShape)


                                                                        .clickable{index=(index+1)%avatars.size}

                                                                        .border(width = 5.dp,
                                                    color = Color.Green, shape = CircleShape)


                        ) //AsyncImage

    }

}
