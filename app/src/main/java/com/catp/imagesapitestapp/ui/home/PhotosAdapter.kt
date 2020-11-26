package com.catp.imagesapitestapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.catp.imagesapitestapp.data.model.db.Photo
import com.catp.imagesapitestapp.databinding.PhotoItemBinding
import javax.inject.Inject

class PhotosAdapter @Inject constructor(
    private val data: MutableList<Photo> = mutableListOf(),
    private val itemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<PhotoViewHolder>() {


    fun setData(newData: List<Photo>) {
        Differ.setItems(data, newData)
        val diff = DiffUtil.calculateDiff(Differ)
        data.clear()
        data.addAll(newData)
        diff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            PhotoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = data[position]
        holder.bind(photo)
        holder.itemBinding.likeImage.setOnClickListener {
            itemClickListener.onClick(photo)
        }
    }

    override fun getItemCount(): Int =
        data.size

    object Differ : DiffUtil.Callback() {
        lateinit var old: List<Photo>
        lateinit var new: List<Photo>
        fun setItems(old: List<Photo>, new: List<Photo>) {
            this.old = old
            this.new = new
        }

        override fun getOldListSize(): Int = old.size

        override fun getNewListSize(): Int = new.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            areContentsTheSame(oldItemPosition, newItemPosition)

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            old[oldItemPosition] == new[newItemPosition]


    }
}