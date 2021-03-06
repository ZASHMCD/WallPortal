package tk.zedlabs.wallaperapp2019.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import kotlinx.coroutines.CoroutineScope
import tk.zedlabs.wallaperapp2019.models.UnsplashImageDetails

class PopularDataSourceFactory(private val scope: CoroutineScope) : DataSource.Factory<Int, UnsplashImageDetails>() {

    private val popularPostLiveDataSource : MutableLiveData<PageKeyedDataSource<Int, UnsplashImageDetails>> = MutableLiveData()

    override fun create(): DataSource<Int, UnsplashImageDetails> {
        val popularDataSource = PopularDataSource(scope)
        popularPostLiveDataSource.postValue(popularDataSource)
        return popularDataSource
    }
    fun getPopularLiveDataSource() : MutableLiveData<PageKeyedDataSource<Int, UnsplashImageDetails>> {
        return popularPostLiveDataSource
    }

}