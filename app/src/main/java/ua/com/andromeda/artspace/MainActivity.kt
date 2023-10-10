package ua.com.andromeda.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.com.andromeda.artspace.model.ArtWork
import ua.com.andromeda.artspace.repository.ArtWorkRepository
import ua.com.andromeda.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtWorkLayout()
                }
            }
        }
    }
}

@Composable
fun ArtWorkLayout() {
    val artWorkRepository by remember { mutableStateOf(ArtWorkRepository()) }
    var currentArtWork by remember { mutableStateOf(artWorkRepository.findOne()) }
    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
        ArtWorkInfo(
            value = currentArtWork,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
                .wrapContentWidth()
        ) {
            Button(
                onClick = {
                    currentArtWork = artWorkRepository.findPrev(currentArtWork)
                },
                modifier = Modifier
                    .fillMaxWidth(.5f)
                    .height(50.dp)
            ) {
                Text(text = "⬅️ Previous", fontSize = 22.sp)
            }
            Button(
                onClick = {
                    currentArtWork = artWorkRepository.findNext(currentArtWork)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Next ➡️", fontSize = 22.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtWorkLayout()
    }
}

@Composable
fun ArtWorkInfo(value: ArtWork, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(value.id),
        contentDescription = "Some description",
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(.5f)
    )
    Text(
        text = value.title,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    )
    Text(
        text = "${value.author} (${value.year})",
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    )
}
