package com.app.learningkotlin.presentation.coin_detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.learningkotlin.R
import com.app.learningkotlin.R.drawable
import com.app.learningkotlin.data.remote.dto.TeamMember
import com.app.learningkotlin.presentation.screens.Splash


@Composable
fun TeamListItem(
    teamMember: TeamMember,
    modifier: Modifier = Modifier,

) {

       Column(
           modifier = modifier,
           verticalArrangement = Arrangement.Center
       ) {
           Text(
               text = teamMember.name,
               style = MaterialTheme.typography.h4
           )
           Spacer(modifier = Modifier.height(4.dp))
           Text(
               text = teamMember.position,
               style = MaterialTheme.typography.body2,
               fontStyle = FontStyle.Italic
           )
       }

}