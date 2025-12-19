package com.greatminds.androidcodingchallenge.model

// UI Model
data class Article(
  val id: String = "",
  val title: String = "",
  val body: String = "",
  val userId: String = "",
  val isExpanded: Boolean = false
)
