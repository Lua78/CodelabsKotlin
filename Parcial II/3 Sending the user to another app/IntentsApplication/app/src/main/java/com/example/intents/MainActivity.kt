package com.example.intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.intents.ui.theme.IntentsTheme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    IntentExamples(
                        modifier = Modifier.padding(innerPadding),
                        onOpenUrl = { openUrl("https://developer.android.com/training/basics/intents/sending") },
                        onOpenApp = { openApp("com.google.android.youtube") },
                        onCalendarEvent = { calendar() },
                        onShareText = { shareText("Probando Intents.") }
                    )
                }
            }
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun openApp(packageName: String) {
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        if (intent != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "La aplicación no está instalada", Toast.LENGTH_LONG).show()
        }
    }

    private fun shareText(text: String) {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, text)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Compartir con"))
    }
    private fun calendar() {
        val intent = Intent(Intent.ACTION_INSERT)
            .setData(CalendarContract.Events.CONTENT_URI)
            .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getDateTimeMillis(2021, 0, 23, 7, 30))
            .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, getDateTimeMillis(2021, 0, 23, 10, 30))
            .putExtra(CalendarContract.Events.TITLE, "Intents")
            .putExtra(CalendarContract.Events.EVENT_LOCATION, "Grabacion de notas hasta el 17 ;o")
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    private fun getDateTimeMillis(year: Int, month: Int, day: Int, hour: Int, minute: Int): Long {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour, minute)
        return calendar.timeInMillis
    }
}

@Composable
fun IntentExamples(
    modifier: Modifier = Modifier,
    onOpenUrl: () -> Unit,
    onOpenApp: () -> Unit,
    onShareText: () -> Unit,
    onCalendarEvent: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(onClick = onOpenUrl) {
            Text("Abrir URL")
        }
        Button(onClick = onOpenApp) {
            Text("Abrir Aplicación")
        }
        Button(onClick = onShareText) {
            Text("Compartir Texto")
        }
        Button(onClick = onCalendarEvent) {
            Text("Agregar al calendario")
        }
        Greeting(name = "Luis")
    }
}
@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.padding(vertical = 8.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun IntentExamplesPreview() {
    IntentsTheme {
        IntentExamples(
            onOpenUrl = {},
            onOpenApp = {},
            onShareText = {},
            onCalendarEvent = {}
        )
    }
}
