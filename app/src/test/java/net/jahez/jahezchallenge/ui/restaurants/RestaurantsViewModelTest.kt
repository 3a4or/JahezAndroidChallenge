package net.jahez.jahezchallenge.ui.restaurants

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import net.jahez.jahezchallenge.CoroutineTestRule
import net.jahez.jahezchallenge.data.entities.RestaurantsResponseItem
import net.jahez.jahezchallenge.data.network.BaseRepository
import net.jahez.jahezchallenge.getOrAwaitValue
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.junit.Assert.assertEquals

class RestaurantsViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = CoroutineTestRule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var baseRepository: BaseRepository

    private lateinit var restaurantsViewModel: RestaurantsViewModel

    @Before
    fun init() {
        MockitoAnnotations.openMocks(this)
        restaurantsViewModel = RestaurantsViewModel(baseRepository)
    }

    @Test
    fun getRestaurantsData_successWithData() {
        runBlocking {
            val returnList = listOf(RestaurantsResponseItem(0, 104.6, true, "3l", "image patch",
            "KFC", "discount", 9.1))
            Mockito.`when`(baseRepository.getRestaurants()).thenReturn(returnList)
        }
        restaurantsViewModel.getRestaurants()
        assertEquals(restaurantsViewModel.restaurantsList.getOrAwaitValue().size, 1)
    }

    @Test
    fun getRestaurantsData_successWithoutData() {
        runBlocking {
            val returnList = listOf<RestaurantsResponseItem>()
            Mockito.`when`(baseRepository.getRestaurants()).thenReturn(returnList)
        }
        restaurantsViewModel.getRestaurants()
        assertEquals(restaurantsViewModel.restaurantsList.getOrAwaitValue().size, 0)
    }
}