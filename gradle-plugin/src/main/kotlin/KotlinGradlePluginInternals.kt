package com.h0tk3y.kotlin.mpp.insight

import org.jetbrains.kotlin.gradle.plugin.KotlinTarget
import org.jetbrains.kotlin.gradle.plugin.KotlinTargetComponent
import org.jetbrains.kotlin.gradle.plugin.mpp.AbstractKotlinTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinVariant
import kotlin.reflect.full.declaredMemberProperties

fun KotlinTarget.getTargetComponents(): Iterable<KotlinTargetComponent> {
    this as AbstractKotlinTarget

    val kotlinComponentsProperty =
        AbstractKotlinTarget::class.declaredMemberProperties.single { it.name == "kotlinComponents" }

    @Suppress("UNCHECKED_CAST")
    return kotlinComponentsProperty.get(this) as Iterable<KotlinTargetComponent>
}