package com.example.atlanta.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.atlanta.data.Recommendation
import com.example.atlanta.data.Category
import com.example.atlanta.data.local.LocalRecommendationsDataProvider
import com.example.atlanta.ui.theme.AtlantaTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendationScreen(
    recommendation: Recommendation,
    selectedCategory: Category,
    modifier: Modifier = Modifier
){
    Scaffold (topBar =
    { CenterAlignedTopAppBar(title = {
        Text(stringResource(recommendation.categoryName))
    }) }
    ) {
        Column(modifier = Modifier.padding(it)) {
            RecommendationList(selectedCategory = selectedCategory)
        }
    }

}
@Composable
fun RecommendationList(
    selectedCategory: Category,
    modifier: Modifier = Modifier
) {
    val filteredRecommendations =
        LocalRecommendationsDataProvider.allRecommendations.filter { it.category == selectedCategory }
    LazyColumn() {
        items(filteredRecommendations) { recommendation ->
                RecommendationCard(recommendation = recommendation)
        }
    }
}
@Composable
fun RecommendationCard(
    recommendation: Recommendation,
    modifier: Modifier = Modifier
){
    Card {
        Row (modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)){
            Image(
                painter = painterResource(recommendation.avatar),
                contentDescription = stringResource(recommendation.name),
                modifier = modifier.size(76.dp)
            )
            Spacer(modifier = modifier.width(20.dp))
            Text(stringResource(recommendation.name))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecommendationScreenPreview() {
    AtlantaTheme {
        val selectedCategory = Category.Coffee
        val recommendations = LocalRecommendationsDataProvider.allRecommendations.filter { it.category == selectedCategory }
        val recommendation = recommendations.first()
        RecommendationScreen(recommendation = recommendation, selectedCategory = selectedCategory)
    }
}

