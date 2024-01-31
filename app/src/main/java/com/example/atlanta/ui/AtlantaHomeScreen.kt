package com.example.atlanta.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.atlanta.R
import com.example.atlanta.data.AtlantaUiState
import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation
import com.example.atlanta.data.local.LocalRecommendationsDataProvider
import com.example.atlanta.ui.theme.AtlantaTheme
import com.example.atlanta.utils.AtlantaContentType

@Composable
fun CategoryList(
//    viewModel: AtlantaViewModel = viewModel(),
//    atlantaUiState: AtlantaUiState,
    onClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        Card(modifier = Modifier.clickable {
            onClick(Category.COFFEE)
        }) {
            Row(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
                Image(
                    painter = painterResource(R.drawable.coffee_icon),
                    contentDescription = "coffee icon",
                    modifier = modifier.size(32.dp)
                )
                Spacer(modifier = modifier.width(20.dp))
                Text(text = "Coffee Shops")
            }
        }
        Card(modifier = Modifier.clickable {
            onClick(Category.DOG_PARK)
        }) {
            Row(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
                Image(
                    painter = painterResource(R.drawable.dog_icon),
                    contentDescription = "dog icon",
                    modifier = modifier.size(32.dp)
                )
                Spacer(modifier = modifier.width(20.dp))
                Text(text = "Dog Parks")
            }
        }
        Card(modifier = Modifier.clickable {
            onClick(Category.MUSEUM)
        }) {
            Row(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
                Image(
                    painter = painterResource(R.drawable.museum_icon),
                    contentDescription = "museum icon",
                    modifier = modifier.size(32.dp)
                )
                Spacer(modifier = modifier.width(20.dp))
                Text(text = "Museums")
            }
        }
        Card(modifier = Modifier.clickable {
            onClick(Category.PIZZA)
        }) {
            Row(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
                Image(
                    painter = painterResource(R.drawable.pizza_icon),
                    contentDescription = "Pizza icon",
                    modifier = modifier.size(32.dp)
                )
                Spacer(modifier = modifier.width(20.dp))
                Text(text = "Pizza Restaurants")
            }
        }
        Card(modifier = Modifier.clickable {
            onClick(Category.SHOPPING_CENTER)
        }) {
            Row(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
                Image(
                    painter = painterResource(R.drawable.mall_icon),
                    contentDescription = "shopping icon",
                    modifier = modifier.size(32.dp)
                )
                Spacer(modifier = modifier.width(20.dp))
                Text(text = "Shopping Centers")
            }
        }
    }
}


@Composable
fun HomeAndRecommendationView(
    windowSize: WindowWidthSizeClass,
    onClick: (Category) -> Unit,
    selectedCategory: Category,
    onCardClick: (Recommendation?) -> Unit,
    modifier: Modifier = Modifier
){
    Row {
        CategoryList(onClick = onClick)
//        Spacer(modifier = modifier.weight(1f))
        RecommendationScreen(selectedCategory = selectedCategory, onClick = onCardClick)
    }
}

@Composable
fun HomeScreen(
    windowSize: WindowWidthSizeClass,
    onClick: (Category) -> Unit,
    selectedCategory: Category,
    onCardClick: (Recommendation?) -> Unit,
    modifier: Modifier = Modifier
) {
    if(windowSize == WindowWidthSizeClass.Expanded)
    {
        HomeAndRecommendationView(
            windowSize = windowSize,
            onClick = onClick,
            selectedCategory = selectedCategory,
            onCardClick = onCardClick
        )
    } else {
        CategoryList(onClick = onClick)
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AtlantaTheme {
        val onClick: (Category) -> Unit = {}
        CategoryList(onClick = onClick)
    }
}