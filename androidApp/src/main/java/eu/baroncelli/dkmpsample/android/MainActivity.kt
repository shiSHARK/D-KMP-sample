package com.fieldontrack.kmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fieldontrack.kmm.android.composables.MainComposable
import com.fieldontrack.kmm.android.composables.styling.MyMaterialTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model = (application as DKMPApp).model
        setContent {
            MyMaterialTheme {
                MainComposable(model)
            }
        }
    }
}