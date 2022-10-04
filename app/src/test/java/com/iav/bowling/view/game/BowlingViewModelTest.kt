package com.iav.bowling.view.game

import com.iav.bowling.repository.GameRepository
import com.iav.bowling.TestData
import com.iav.bowling.data.Throw
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test


/**
 * Created by Ramesh on 10/3/22.
 */
class BowlingViewModelTest {

    private var viewModel: BowlingViewModel? = null

    private val game = GameRepository()

    @Before
    fun setUp() {
        viewModel = BowlingViewModel(game)
    }


    @Test
    fun testGameScoreByAddingThrowOneByOne() {
        addThrowOneByOne()
        assert((viewModel?.score?.get() ?: "0").equals("133", ignoreCase = true))
        TestCase.assertEquals(10, game.frames.filterNotNull().size)
    }

    @Test
    fun testGameScoreByAddingAllThrowsData() {
        viewModel?.addThrows(TestData.exampleGameThrows)
        assert((viewModel?.score?.get() ?: "0").equals("133", ignoreCase = true))
        TestCase.assertEquals(10, game.frames.filterNotNull().size)
    }

    @Test
    fun testGameRestart() {
        viewModel?.addThrows(TestData.exampleGameThrows)
        assert((viewModel?.score?.get() ?: "0").equals("133", ignoreCase = true))
        TestCase.assertEquals(10, game.frames.filterNotNull().size)
        TestCase.assertEquals(3, game.frames.filterNotNull().last().throws.size)
        viewModel?.restartGame()
        TestCase.assertEquals(0, game.frames.filterNotNull().size)
    }

    private fun addThrowOneByOne() {
        viewModel?.addThrow(Throw(1))
        viewModel?.addThrow(Throw(4))
        viewModel?.addThrow(Throw(4))
        viewModel?.addThrow(Throw(5))
        viewModel?.addThrow(Throw(6))
        viewModel?.addThrow(Throw(4))
        viewModel?.addThrow(Throw(5))
        viewModel?.addThrow(Throw(5))
        viewModel?.addThrow(Throw(10))
        viewModel?.addThrow(Throw(0))
        viewModel?.addThrow(Throw(1))
        viewModel?.addThrow(Throw(7))
        viewModel?.addThrow(Throw(3))
        viewModel?.addThrow(Throw(6))
        viewModel?.addThrow(Throw(4))
        viewModel?.addThrow(Throw(10))
        viewModel?.addThrow(Throw(2))
        viewModel?.addThrow(Throw(8))
        viewModel?.addThrow(Throw(6))
    }

}