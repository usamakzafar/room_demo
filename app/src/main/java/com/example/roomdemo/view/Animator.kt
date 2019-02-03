package com.example.roomdemo.view

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.view.View
import android.view.animation.DecelerateInterpolator

/**
 * Created by uzafar
 * on 31 Jan, 2019
 * at 12:31 PM
 */
class Animator {

    private val animations = ArrayList<ValueAnimator>()


    private val stretchIn = PropertyValuesHolder.ofFloat(View.SCALE_X, 0.5f, 1f)
    private val flyIn = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, -400f, 0f)
    private val flyInTop = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, -400f, 0f)
    private val fadeIn = PropertyValuesHolder.ofFloat(View.ALPHA, 0f, 1f)


    fun setFlyInLeft(view: View) {
        val anim = ObjectAnimator.ofPropertyValuesHolder(view, stretchIn,flyIn,fadeIn).apply {
            duration = 600
            startDelay = 500
            interpolator = DecelerateInterpolator()
        }
        animations.add(anim)
    }

    fun setFlyInTop(view: View) {
        val anim = ObjectAnimator.ofPropertyValuesHolder(view, stretchIn,flyInTop,fadeIn).apply {
            duration = 600
            startDelay = 500
            interpolator = DecelerateInterpolator()
        }
        animations.add(anim)
    }

    fun startAnimations() {
        animations.forEach { it.start() }
    }

    fun reverseAnimations() {
        animations.forEach { it.reverse() }
    }
}