package com.adithya_sakaray.nameadder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adithya_sakaray.nameadder.ui.theme.NameAdderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NameAdderTheme {
                var name by remember {
                    mutableStateOf("")
                }

                var names by remember {
                    mutableStateOf(listOf<String>())
                }

                Column (
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        ){

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = name,
                            onValueChange = { text ->
                                name = text
                            },
                            modifier = Modifier.weight(1f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.LightGray
                            )
                        )
                        Spacer(modifier = Modifier.width(14.dp))
                        Button(onClick = {
                            if(name.isNotBlank()){
                                names += name
                                name = ""
                            }
                        }) {
                            Text(text = "Add")
                        }
                    }

                    LazyColumn(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        items(items = names) { currentName ->
                            Text(text = currentName,
                                fontSize = 20.sp,
                                modifier = Modifier.padding(10.dp)
                            )
                            Divider(color = Color.LightGray)
                        }
                    }
                }
                


            }
        }
    }
}

