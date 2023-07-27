package com.app.learningkotlin.presentation.coin_detail


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.app.learningkotlin.R
import com.app.learningkotlin.presentation.Screen
import com.app.learningkotlin.presentation.coin_detail.components.CoinTag
import com.app.learningkotlin.presentation.coin_detail.components.Header
import com.app.learningkotlin.presentation.coin_detail.components.TeamListItem
import com.google.accompanist.flowlayout.FlowRow
import java.util.logging.Logger


@Composable
fun CoinDetailScreen(
    navController: NavController,
    viewModel: CoinDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val contextForToast = LocalContext.current.applicationContext

    Box(modifier = Modifier.fillMaxSize()) {



        state.coin?.let { coin ->

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    IconButton( modifier = Modifier
                        .size(30.dp),onClick = {
                        Toast.makeText(contextForToast, "Click!", Toast.LENGTH_SHORT).show()
                        Log.d("TAG","AAAAA")
                        navController.popBackStack()}) {
                        Icon(
                            painterResource(R.drawable.ic_back) ,contentDescription = "ic_black",
                            modifier= Modifier
                                .size(30.dp, 30.dp)
                                .padding(top = 5.dp, start = 5.dp)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coin?.rank}. ${coin?.name} (${coin?.symbol})",
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier.weight(8f)
                        )
                        Text(
                            text = if(coin?.isActive) "active" else "inactive",
                            color = if(coin?.isActive) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(CenterVertically)
                                .weight(2f)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = coin?.description,
                        style = MaterialTheme.typography.body2
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h3
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coin?.tags.forEach { tag ->
                            CoinTag( tag = tag)
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Team members",
                        style = MaterialTheme.typography.h3
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
                items(coin?.team) { teamMember ->
                    TeamListItem(
                        teamMember = teamMember,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                    )
                    Divider()
                }
            }
        }
        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}


