package com.example.android.activities.menu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Border
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.painter.ImagePainter
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Scaffold
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.android.R
import com.example.android.activities.display.DisplayRecords
import com.example.android.activities.display.DisplayResidents
import com.example.android.activities.save.SaveResident
import com.example.android.activities.search.SearchResident
import com.example.android.ui.utils.darkThemeColors


class MenuResident : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                subMenu()

        }
    }

    companion object{
        var token : String = ""

        fun setLoginData(authToken : String){
            this.token = authToken
            Log.v("TOKEN", this.token)
        }
    }


    @Preview
    @Composable
    private fun subMenu(){

        MaterialTheme(colors = darkThemeColors) {

            Scaffold(bodyContent = {

                Image(
                        painter = ImagePainter(imageResource(id = R.drawable.menuresidents)),
                        alignment = Alignment.TopCenter
                )
                Image(
                        painter = ImagePainter(imageResource(id = R.drawable.conciergewallpaper)),
                        alignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                )

                Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalGravity = Alignment.CenterHorizontally
                ){
                    Button(
                            text = { Text("Display data Residents",
                                    color = darkThemeColors.onPrimary,
                                    style = MaterialTheme.typography.h6) },
                            backgroundColor = Color.Transparent,
                            border = Border(5.dp, darkThemeColors.secondary),
                            modifier = Modifier.size(300.dp, 100.dp).padding(0.dp, 10.dp),
                            shape = RoundedCornerShape(10.dp),
                            onClick = {
                                DisplayResidents.setLoginData(token)
                                val intent = Intent(this@MenuResident,
                                        DisplayResidents::class.java)
                                intent.putExtra("option", "all")
                                intent.putExtra("search", "")
                                startActivity(intent)
                            }
                    )

                    Button(
                            text = { Text("Registry",
                                    color = darkThemeColors.onPrimary,
                                    style = MaterialTheme.typography.h6) },
                            backgroundColor = Color.Transparent,
                            border = Border(5.dp, darkThemeColors.secondary),
                            modifier = Modifier.size(300.dp, 100.dp).padding(0.dp, 10.dp),
                            shape = RoundedCornerShape(10.dp),
                            onClick = {
                                SaveResident.setLoginData(token)
                                startActivity(
                                        Intent(this@MenuResident,
                                                SaveResident::class.java
                                        ))
                                    }
                    )
                    Button(
                            text = { Text("Search",
                                    color = darkThemeColors.onPrimary,
                                    style = MaterialTheme.typography.h6) },
                            backgroundColor = Color.Transparent,
                            border = Border(5.dp, darkThemeColors.secondary),
                            modifier = Modifier.size(300.dp, 100.dp).padding(0.dp, 10.dp),
                            shape = RoundedCornerShape(10.dp),
                            onClick = {
                                SearchResident.setLoginData(token)
                                startActivity(
                                        Intent(this@MenuResident,
                                                SearchResident::class.java
                                        ))
                            }
                    )
                }

            })

        }

    }




}
