package com.example.news_app_jetpack_compose_mvvm.presentation.onboarding


/*This is a sealed class created to mention all onboarding screens events.
    This class instance is read by home-screen view-model and all events will be
    handled accordingly.
    currently there is only get started event which is triggered when user
    click on get started button on screen 3 of onboarding screen
    Use of this sealed class ensures there is room for adding more events
    to home screen in future.
 */
sealed class OnBoardingEvent {
     object OnGetStartedEvent:OnBoardingEvent()

}