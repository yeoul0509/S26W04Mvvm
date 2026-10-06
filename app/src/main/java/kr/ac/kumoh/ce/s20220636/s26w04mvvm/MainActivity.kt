package kr.ac.kumoh.ce.s20220636.s26w04mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.launch
import kr.ac.kumoh.ce.s20220636.s26w04mvvm.ui.theme.S26W04MvvmTheme

class MainActivity : ComponentActivity() {
    private val counterViewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S26W04MvvmTheme {
                MainScreen(counterViewModel)
            }
        }
    }
}

@Composable
fun MainScreen(
    viewModel: CounterViewModel
) {
    // 유튜버: StateFlow
    // 구독자: collectAsStateWithLifecycle()
    // 실시간으로 받아낸 최신 상태 객체: counterState
    val counterState by viewModel.counter.collectAsStateWithLifecycle()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Counter(
            modifier = Modifier.padding(innerPadding),
            count = counterState.count,
            onIncrement = { viewModel.incrementCount() },
            onDecrement = { viewModel.decrementCount() },
            onReset = { viewModel.resetCount() },
        )
    }
}

