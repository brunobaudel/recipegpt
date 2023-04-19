package com.mobsky.recipechat.data.repository.model

import kotlin.math.ln
import kotlin.math.pow

data class ProjectInfo(
    val id: String = "",
    val repositoryName: String = "",
    val starsCount: Int = 0,
    val forkCount: Int = 0,
    val photoUser: String = "",
    val authorName: String = "",
    val load: LoadStateProjectInfo = LoadStateProjectInfo.NoLoad
) {

    fun getForkCountFormat(): String = getFormatedNumber(forkCount.toLong())

    fun getStarCountFormat(): String = getFormatedNumber(starsCount.toLong())

    private fun getFormatedNumber(count: Long): String {
        if (count < 1000) return "" + count
        val exp = (ln(count.toDouble()) / ln(1000.0)).toInt()
        return String.format("%.1f %c", count / 1000.0.pow(exp.toDouble()), "kMGTPE"[exp - 1])
    }
}

sealed class LoadStateProjectInfo{
    object Load : LoadStateProjectInfo()
    object Shimmer: LoadStateProjectInfo()
    object NoLoad: LoadStateProjectInfo()
}
