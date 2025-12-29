import android.widget.Space
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.greatminds.androidcodingchallenge.model.Article
import com.greatminds.androidcodingchallenge.ui.ArticlesUiState
import com.greatminds.androidcodingchallenge.ui.ArticlesViewModel

@Composable
fun ArticleScreen(viewModel: ArticlesViewModel = hiltViewModel()) {
    //collect state from VM
    val uiState by viewModel.uiState.collectAsState()

    when (val state = uiState) {
        is ArticlesUiState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is ArticlesUiState.Error -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column (horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Error: ${state.message}")
                    Button(onClick = { viewModel.fetchArticles() }) {
                        Text("Retr")
                    }
                }
            }
        }
        is ArticlesUiState.Empty -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("No article founf")
            }
        }
        is ArticlesUiState.Success -> {
            LazyColumn ( Modifier.fillMaxSize().padding(20.dp)) {
                items(state.items, key = {it.id}) {article ->
                    ArticleItem(article)
                    Spacer(Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
private fun ArticleItem(article: Article) {
    Card ( Modifier.fillMaxWidth()) {
        Text(article.title, style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(5.dp))
        Text(article.body, style = MaterialTheme.typography.bodySmall)
    }
}
