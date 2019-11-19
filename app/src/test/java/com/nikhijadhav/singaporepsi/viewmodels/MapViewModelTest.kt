package com.nikhijadhav.singaporepsi.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nikhijadhav.singaporepsi.apis.SingaporePsiApi
import com.nikhijadhav.singaporepsi.models.Item
import com.nikhijadhav.singaporepsi.models.RegionMetadatum
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertFalse
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.CountDownLatch

@RunWith(MockitoJUnitRunner::class)
class MapViewModelTest {
    lateinit var mockMapViewModel: MapViewModel

    var mockInformationList = MutableLiveData<ArrayList<RegionMetadatum>>()

    lateinit var observerInformationList: Observer<MutableLiveData<ArrayList<RegionMetadatum>>>
    lateinit var rowInformationList: ArrayList<RegionMetadatum>
    var expectedSize = 100

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mockMapViewModel = mock(MapViewModel::class.java)

        observerInformationList =
            mock(Observer<MutableLiveData<ArrayList<RegionMetadatum>>> { t -> print("RegionalList " + t!!.value!!.size) }.javaClass)
        rowInformationList = Mockito.spy<ArrayList<RegionMetadatum>>(ArrayList())
        mockInformationList.value = rowInformationList

        mockInformationList.observeForever { observerInformationList }
        Mockito.`when`(mockMapViewModel.regionList).thenReturn(mockInformationList)
        Mockito.`when`(mockMapViewModel.regionList.value!!.size).thenReturn(100)
    }


    /**
     * Check for same expected and actual size of array list
     */
    @Test
    fun getInformationList_success() {
        assertEquals(expectedSize, mockMapViewModel.regionList.value!!.size)

    }

    /**
     * Check for different expected and actual size of array list.
     */

    @Test
    fun getInformationList_failure() {
        expectedSize = 1001
        assertFalse("getInformationList_failure ", mockMapViewModel.regionList.value!!.size == expectedSize)

    }

}