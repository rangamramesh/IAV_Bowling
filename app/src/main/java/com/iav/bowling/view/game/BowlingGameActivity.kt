package com.iav.bowling.view.game

import android.annotation.SuppressLint
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.iav.bowling.R
import com.iav.bowling.databinding.ActivityBowlingBinding
import com.iav.bowling.data.Throw
import com.iav.bowling.view.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BowlingGameActivity : BaseActivity() {


    private val viewModel: BowlingViewModel by viewModels()
    private var binding: ActivityBowlingBinding? = null


    override fun initDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bowling)
        binding?.viewModel = viewModel
    }

    override fun initializeData() {
        binding?.frameRecyclerView?.adapter = FramesAdapter(viewModel.game.frames)
        updateButtons()
        viewModel.updateScore()
    }

    fun onClickValue(view: View) {
        val value = view.tag.toString().toInt()

        viewModel.addThrow(Throw(value))
        updateRecyclerView()
        updateButtons()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateRecyclerView() {
        binding?.frameRecyclerView?.adapter?.notifyDataSetChanged()
        binding?.frameRecyclerView?.smoothScrollToPosition(viewModel.game.frames.filterNotNull().size)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun onClickRestart(view: View) {
        viewModel.restartGame()
        updateRecyclerView()
        updateButtons()
    }

    private fun updateButtons() {
        val possibleHits = viewModel.game.getPossibleHits()
        binding?.scoreButtonsLayout?.childCount?.let { count ->
            for (i in 0 until count) {
                binding?.scoreButtonsLayout?.getChildAt(i)?.isEnabled = possibleHits >= i
            }
        }

    }
}
