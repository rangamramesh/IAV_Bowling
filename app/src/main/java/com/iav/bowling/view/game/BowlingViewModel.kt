package com.iav.bowling.view.game

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.iav.bowling.repository.GameRepository
import com.iav.bowling.data.Throw
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Ramesh on 9/30/22.
 */
@HiltViewModel
class BowlingViewModel @Inject constructor(val game: GameRepository) : ViewModel() {

    val score = ObservableField<String>()

    fun addThrow(`throw`: Throw) {
        game.addThrow(`throw`)
        updateScore()
    }

    fun addThrows(throws: List<Throw>) {
        game.setThrows(throws)
        updateScore()
    }

    fun restartGame() {
        game.restart()
        updateScore()
    }

    fun updateScore() {
        score.set(game.score.toString())
        score.notifyChange()
    }


}