package com.iav.bowling.view.game

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iav.bowling.databinding.AdapterItemFrameBinding
import com.iav.bowling.data.Frame
import com.iav.bowling.data.ScoreType

/**
 * Created by Ramesh on 9/29/22.
 */

class FramesAdapter(private val frameList: Array<Frame?>) : RecyclerView.Adapter<FrameViewHolder>() {

    override fun getItemCount(): Int {
        return frameList.size
    }

    override fun onBindViewHolder(holder: FrameViewHolder, position: Int) {
        holder.bindData(frameList[position], position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrameViewHolder {
        return FrameViewHolder(
            AdapterItemFrameBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

}

class FrameViewHolder(private val itemViewBinding: AdapterItemFrameBinding) :
    RecyclerView.ViewHolder(itemViewBinding.root) {
    fun bindData(
        frameItem: Frame?, position: Int
    ) {
        itemViewBinding.position = position

        if (frameItem == null) {
            itemViewBinding.textHitScore1.text = ""
            itemViewBinding.textHitScore2.text = ""
            itemViewBinding.textHitScore3.text = ""
            itemViewBinding.textFrameScore.text = ""
            return
        }

        when (frameItem.scoreType) {
            ScoreType.STRIKE -> {

                if (position == 9) {
                    itemViewBinding.textHitScore1.text = "X"
                    itemViewBinding.textHitScore2.text =
                        (frameItem.throws.getOrNull(1)?.hits)?.toString() ?: ""
                } else {
                    itemViewBinding.textHitScore1.text = ""
                    itemViewBinding.textHitScore2.text = "X"
                }

                itemViewBinding.textHitScore3.text =
                    (frameItem.throws.getOrNull(2)?.hits)?.toString() ?: ""

            }
            ScoreType.SPARE -> {
                itemViewBinding.textHitScore1.text =
                    (frameItem.throws.getOrNull(0)?.hits)?.toString() ?: ""
                itemViewBinding.textHitScore2.text = "/"
                itemViewBinding.textHitScore3.text =
                    (frameItem.throws.getOrNull(2)?.hits)?.toString() ?: ""
            }
            ScoreType.NORMAL -> {
                itemViewBinding.textHitScore1.text =
                    (frameItem.throws.getOrNull(0)?.hits)?.toString() ?: ""
                itemViewBinding.textHitScore2.text =
                    (frameItem.throws.getOrNull(1)?.hits)?.toString() ?: ""
                itemViewBinding.textHitScore3.text =
                    (frameItem.throws.getOrNull(2)?.hits)?.toString() ?: ""
            }
        }

        itemViewBinding.textFrameScore.text = frameItem.score?.toString() ?: ""
        itemViewBinding.executePendingBindings()
    }
}
