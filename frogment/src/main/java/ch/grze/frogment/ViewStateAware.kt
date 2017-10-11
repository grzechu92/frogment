package ch.grze.frogment

interface ViewStateAware {
    val isViewReady: Boolean
    fun onViewReady()
}
