package com.mobsky.recipechat.data.repository.mapper

import com.mobsky.recipechat.data.network.api.model.CompletionResponse
import com.mobsky.recipechat.data.repository.model.ProjectInfo

fun CompletionResponse?.toProjectInfo(): List<ProjectInfo> =
    this?.choices?.map {

    } ?: listOf()
    
