package kr.ac.kumoh.s20191091.s24w13lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.s20191091.s24w13lazylist.ui.theme.S24W13LazyListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S24W13LazyListTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        MyList(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun MyList(modifier: Modifier = Modifier){
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ){
      items(30){
          SongItem(it)
      }
    }
}

@Composable
fun SongItem(index: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xffffffcc))
            .padding(16.dp)

    ) {
        TextTitle("노래 $index")
        TextSinger("이 노래를 부른 가수는 $index 입니다")
    }
}

@Composable
fun TextTitle(title: String) {
    Text(title, fontSize = 30.sp)
}

@Composable
fun TextSinger(singer: String) {
    Text(singer, fontSize = 20.sp)
}