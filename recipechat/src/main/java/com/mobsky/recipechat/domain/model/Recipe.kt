package com.mobsky.recipechat.domain.model

data class Recipe(
    val caloriesPerServing: Int = 0,
    val cookTime: String = "",
    val directions: List<String> = listOf(),
    val ingredients: List<Ingredient> = listOf(),
    val prepTime: String = "",
    val title: String = "",
    val totalCalories: Int = 0,
    val yield: String = ""
)
