
package com.shenawynkov.test.di






import com.shenawynkov.test.BaseApp
import com.shenawynkov.test.ui.HomeFragment
import com.shenawynkov.test.ui.ListFragment
import com.shenawynkov.test.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepoModule::class, FactoryModule::class])
interface ApplicationComponent {

    fun  inject(app: BaseApp)

    fun inject(activity: MainActivity)
    fun inject(fragment: HomeFragment)
    fun inject(fragment: ListFragment)

}