package com.krishhh.day5_unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.krishhh.day5_unitconverter.ui.theme.Day5_unitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Day5_unitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()

                }
            }
        }
    }
}

@Composable
fun UnitConverter(){

    var inputValue by remember {mutableStateOf("")}
    var outputValue by remember {mutableStateOf("")}
    var inputUnit by remember {mutableStateOf("Meters")}
    var outputUnit by remember {mutableStateOf("Meters")}
    var iExpanded by remember {mutableStateOf(false)}
    var oExpanded by remember {mutableStateOf(false)}
    var conversionFactor = remember {mutableStateOf(1.0)}
    var oConversionFactor = remember {mutableStateOf(1.0)}

    val customTextStyle = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontSize = 32.sp,
        color = Color.Red
    )


    fun convertUnits(){

        // ?: - elvis operator
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100.0 / oConversionFactor.value).roundToInt() / 100.0
        outputValue = result.toString()
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        // Here all the UI elements will be stacked below each other
        Text("Unit Converter", style = customTextStyle)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                // Here goes what should happen when the value of our Outlinedtextfield changes
                inputValue = it
                convertUnits()
            },
            label = {Text("Enter Value")}
            )
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            // Input Box
            Box{
                // Input Button
                Button(onClick = { iExpanded = true}) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")

                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false}) {
                    DropdownMenuItem(
                        text = {Text("Centimeters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Centimeters"
                            conversionFactor.value = 0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Meters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Meters"
                            conversionFactor.value = 1.0
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Inches")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Inches"
                            conversionFactor.value = 0.0254
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Feet")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Feet"
                            conversionFactor.value = 0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Millimeters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Millimeters"
                            conversionFactor.value = 0.001
                            convertUnits()
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Output Box
            Box{
                // Output Button
                Button(onClick = { oExpanded = true }) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")

                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(
                        text = {Text("Centimeters")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Centimeters"
                            oConversionFactor.value = 0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Meters")},
                        onClick = {
                            iExpanded = false
                            outputUnit = "Meters"
                            oConversionFactor.value = 1.0
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Inches")},
                        onClick = {
                            iExpanded = false
                            outputUnit = "Inches"
                            oConversionFactor.value = 0.0254
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Feet")},
                        onClick = {
                            iExpanded = false
                            outputUnit = "Feet"
                            oConversionFactor.value = 0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Millimeters")},
                        onClick = {
                            iExpanded = false
                            outputUnit = "Millimeters"
                            oConversionFactor.value = 0.001
                            convertUnits()
                        }
                    )
                }
            }
            // Here all the UI elements will be stacked next to each other

        }
        Spacer(modifier = Modifier.height(16.dp))
        // Result text
        Text(text = "Result: $outputValue $outputUnit",
             style = MaterialTheme.typography.headlineMedium
            )
    }
}


@Preview
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}