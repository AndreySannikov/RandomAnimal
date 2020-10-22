package ru.degus.randomanimal.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import kotlinx.android.synthetic.main.dog_fragment.*
import kotlinx.android.synthetic.main.dog_item.*
import ru.degus.randomanimal.DogAdapter
import ru.degus.randomanimal.DogItemTouchHelperCallback
import ru.degus.randomanimal.NotScrollingLayoutManager
import ru.degus.randomanimal.R
import ru.degus.randomanimal.util.OnSwipeTouchListener
import ru.degus.randomanimal.viewmodels.DogViewModel

class DogFragment : Fragment() {

    companion object {
        fun newInstance() = DogFragment()
    }

    private lateinit var viewModel: DogViewModel
    private val adapter = DogAdapter()
    private val manager = NotScrollingLayoutManager(context)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.dog_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DogViewModel::class.java)

        val touchCallback = DogItemTouchHelperCallback(adapter){
            viewModel.removeDog()
            viewModel.loadDogs()
        }
        val touchHelper = ItemTouchHelper(touchCallback)
        touchHelper.attachToRecyclerView(mainRecyclerView)

        mainRecyclerView.adapter = adapter
        mainRecyclerView.layoutManager = manager
        viewModel.dogs.observe(viewLifecycleOwner, Observer {
            adapter.setData(it ?: emptyList())
        })

    }

    override fun onResume() {
        viewModel.loadDogs()
        viewModel.loadDogs()
        viewModel.loadDogs()
        viewModel.loadDogs()

        super.onResume()
    }

}