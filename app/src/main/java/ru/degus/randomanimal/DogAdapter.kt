package ru.degus.randomanimal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.degus.randomanimal.databinding.DogItemBinding
import ru.degus.randomanimal.models.Animal
import ru.degus.randomanimal.viewmodels.DogItemViewModel

class DogAdapter : RecyclerView.Adapter<DogHolder>() {

    private val viewModel = DogItemViewModel()

    val data: List<Animal>
        get() = viewModel.data

    fun setData(dogs: List<Animal>) {
        viewModel.data = dogs
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogHolder =
        DogHolder.create(parent)

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: DogHolder, position: Int) {
        holder.bind(viewModel, position)
    }
}

class DogHolder(private val binding: DogItemBinding) : RecyclerView.ViewHolder(binding.root), ItemTouchViewHolder {
    fun bind(viewModel: DogItemViewModel, position: Int) {
        binding.setVariable(BR.viewModel, viewModel)
        binding.setVariable(BR.position, position)
        binding.executePendingBindings()
    }

    override fun onItemSelected() {

    }

    override fun onItemCleared() {

    }
    companion object {
        fun create(parent: ViewGroup): DogHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding: DogItemBinding =
                DataBindingUtil.inflate(inflater, R.layout.dog_item, parent, false)
            return DogHolder(binding)
        }
    }

}