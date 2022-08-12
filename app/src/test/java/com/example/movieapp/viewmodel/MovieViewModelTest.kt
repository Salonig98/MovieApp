package com.example.movieapp.viewmodel

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

//    @Mock
//    private lateinit var viewModel: MovieViewModel
//
//    @Mock
//    private lateinit var repository: MovieRepository
//
//    @Mock
//    private lateinit var service : MovieService
//
//    @Before
//    fun setup() {
//        MockitoAnnotations.initMocks(this)
//        repository = MovieRepository(service)
//        viewModel = spy(MovieViewModel(repository))
//    }
//
//
//    @Test
//    fun `Verify livedata values changes on event`() {
//        assertNotNull(viewModel.getAllMovies())
//        viewModel.dataLoading.observeForever(observer)
//        verify(observer).onChanged(false)
//        viewModel.getAllQuotes()
//        verify(observer).onChanged(true)
//    }
//
//    @Test
//    fun `empty movie list test`() {
//        runBlocking {
//            Mockito.`when`(repository.getPopularMovies())
//                .thenReturn(Response.success(Response<Result>))
//            viewModel.getAllMovies()
//            val result = viewModel.movieList.value
//            Assert.assertEquals(listOf<Movie>(), result)
//        }
//    }
//

}