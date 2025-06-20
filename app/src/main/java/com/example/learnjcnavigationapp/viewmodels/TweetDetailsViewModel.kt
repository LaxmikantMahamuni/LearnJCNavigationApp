package com.example.learnjcnavigationapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learnjcnavigationapp.models.TweetListItem
import com.example.learnjcnavigationapp.repository.TweetsyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetDetailsViewModel @Inject constructor(private val repository: TweetsyRepository): ViewModel() {
    val tweets: StateFlow<List<TweetListItem>>
        get() = repository.tweets

   init {
       viewModelScope.launch {
           repository.getTweets("android")
       }
   }
}