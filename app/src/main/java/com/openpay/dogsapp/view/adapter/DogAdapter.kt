package com.openpay.dogsapp.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.openpay.dogsapp.R
import com.openpay.dogsapp.databinding.ItemDogBinding
import com.openpay.dogsapp.model.entities.Dog
import com.squareup.picasso.Picasso

class DogAdapter(private val context: Context) : RecyclerView.Adapter<DogViewHolder>() {

    var dogsList = mutableListOf<Dog>()

    @SuppressLint("NotifyDataSetChanged")
    fun setDogs(dogs: List<Dog>) {

        this.dogsList = dogs.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(inflater, context)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.apply {
            bind(dogsList[position])
        }
    }

    override fun getItemCount(): Int {
        return dogsList.size
    }
}

class DogViewHolder(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemDogBinding.bind(itemView)

    fun bind(dog: Dog) {
        binding.nameTextView.text = dog.dogName
        binding.descriptionTextView.text = context.getString(
            R.string.dog_description, dog.maxLifeExpectancy, dog.maxHeight - dog.minHeight
        )
        binding.ageTextView.text =
            context.getString(R.string.dog_age, dog.maxLifeExpectancy - dog.minLifeExpectancy)

        Picasso.get().load(dog.url).into(binding.avatarImageView)
    }
}
