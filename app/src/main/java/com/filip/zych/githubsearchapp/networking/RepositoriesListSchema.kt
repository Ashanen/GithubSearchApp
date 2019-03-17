package com.filip.zych.githubsearchapp.networking
import com.google.gson.annotations.SerializedName


data class RepositoriesListSchema(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val itemSchemas: List<ItemSchema>,
    @SerializedName("total_count")
    val totalCount: Int
)