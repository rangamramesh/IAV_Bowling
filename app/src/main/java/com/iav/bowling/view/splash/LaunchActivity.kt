package com.iav.bowling.view.splash

import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.iav.bowling.R
import com.iav.bowling.databinding.ActivityLaunchBinding
import com.iav.bowling.utils.Constants.SPLASH_SCREEN_VISIBLE_TIME_MS
import com.iav.bowling.view.BaseActivity
import com.iav.bowling.view.game.BowlingGameActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchActivity : BaseActivity() {
    private var dataBinding: ActivityLaunchBinding? = null

    override fun initDataBinding() {
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_launch)
    }

    override fun initializeData() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, BowlingGameActivity::class.java))
        }, SPLASH_SCREEN_VISIBLE_TIME_MS)
    }

}