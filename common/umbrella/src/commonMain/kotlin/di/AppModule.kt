package di

import org.koin.dsl.module

fun appModule(configuration: PlatformConfiguration) = module {
    single<PlatformConfiguration> { configuration }
    includes(authPresentationModule)
}
