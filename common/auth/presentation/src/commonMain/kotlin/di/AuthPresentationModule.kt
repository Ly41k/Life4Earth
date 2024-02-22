package di

import login.LoginViewModel
import org.koin.dsl.module

val authPresentationModule = module {
    factory { LoginViewModel() }
}