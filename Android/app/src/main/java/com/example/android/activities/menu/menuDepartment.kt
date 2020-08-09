package com.example.android.activities.menu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.padding
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.android.activities.display.displayDepartments
import com.example.android.activities.search.searchDepartment
import com.example.android.ui.utils.darkThemeColors


class menuDepartment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                topBar()
                subMenu()
            }
        }
    }

    @Preview
    @Composable
    private fun topBar() =
            MaterialTheme( colors = darkThemeColors) {
                TopAppBar(
                        title =
                        {
                            Text(text = "Departamentos",
                                    style = MaterialTheme.typography.h5)
                        },
                        backgroundColor = darkThemeColors.primary,
                        elevation = 0.dp
                )
            }

    @Composable
    private fun subMenu() =
        Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalGravity = Alignment.CenterHorizontally
        ){
            Button(
                    text = { Text("Display Data") },
                    backgroundColor = darkThemeColors.onPrimary,
                    modifier = Modifier.padding(0.dp,10.dp),
                    onClick = {
                        val display = Intent(this@menuDepartment,
                                displayDepartments::class.java)
                        val b = Bundle()
                        b.putString("option", "all")
                        display.putExtras(b)
                        startActivity(display)
                        finish()
                    }
            )
            Button(
                    text = { Text("Registrar") },
                    backgroundColor = darkThemeColors.onPrimary,
                    modifier = Modifier.padding(0.dp,10.dp),
                    onClick = {
                    }
            )
            Button(
                    text = { Text("Buscar") },
                    backgroundColor = darkThemeColors.onPrimary,
                    modifier = Modifier.padding(0.dp,10.dp),
                    onClick = {
                        startActivity(
                            Intent(
                                this@menuDepartment,
                                searchDepartment::class.java
                            )
                        )
                    }
            )
        }

}
