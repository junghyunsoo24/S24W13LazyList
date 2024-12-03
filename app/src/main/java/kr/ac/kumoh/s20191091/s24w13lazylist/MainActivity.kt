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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kr.ac.kumoh.s20191091.s24w13lazylist.model.Song
import kr.ac.kumoh.s20191091.s24w13lazylist.ui.theme.S24W13LazyListTheme
import kr.ac.kumoh.s20191091.s24w13lazylist.viewmodel.SongViewModel

import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.items

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
fun MainScreen(viewModel: SongViewModel = viewModel()) {
    val listSong by viewModel.songs.observeAsState()

    repeat(30) { index ->
        viewModel.add(Song(index * 3, "생각이나", "정동하"))
        viewModel.add(Song(index * 3 + 1 , "사랑에 연습이 있었다면", "임재현"))
        viewModel.add(Song(index * 3 + 2, "사랑은 늘 도망가", "임영웅"))
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        listSong?.let {
            //if (listSong != null) {
            MyList(
                modifier = Modifier.padding(innerPadding),
                list = it
            )
        }?: run {
            Text(
                "리스트가 없습니다",
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}

@Composable
fun MyList(modifier: Modifier = Modifier, list: List<Song>){
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ){
        items(list) { song ->
            SongItem(song)
        }
    }
}

@Composable
fun SongItem(song: Song) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xffffffcc))
            .padding(16.dp)

    ) {
        TextTitle(song.title)
        TextSinger("이 노래를 부른 가수는 ${song.singer} 입니다")
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