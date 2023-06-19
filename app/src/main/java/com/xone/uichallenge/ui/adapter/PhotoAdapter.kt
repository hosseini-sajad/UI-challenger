package com.xone.uichallenge.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.xone.uichallenge.R
import com.xone.uichallenge.models.ModelClass

class PhotoAdapter(
    private val photos: List<List<ModelClass.ModelClassItem>>,
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_ONE -> PhotoViewHolderOne(
                layoutInflater.inflate(
                    R.layout.item_list_1,
                    parent,
                    false
                )
            )

            VIEW_TYPE_TWO -> PhotoViewHolderTwo(
                layoutInflater.inflate(
                    R.layout.item_list_2,
                    parent,
                    false
                )
            )

            VIEW_TYPE_THERE -> PhotoViewHolderTwo(
                layoutInflater.inflate(
                    R.layout.item_list_2,
                    parent,
                    false
                )
            )

            VIEW_TYPE_FOUR -> PhotoViewHolderThree(
                layoutInflater.inflate(
                    R.layout.item_list_3,
                    parent,
                    false
                )
            )

            else -> PhotoViewHolderOne(layoutInflater.inflate(R.layout.item_list_1, parent, false))
        }
    }

    override fun getItemCount() = photos.size

    override fun getItemViewType(position: Int) = position % 4

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = photos[position]
        (holder as Bind).onBind(list)
    }

    class PhotoViewHolderOne constructor(itemView: View) : RecyclerView.ViewHolder(itemView), Bind {
        private val firstPhoto = itemView.findViewById<AppCompatImageView>(R.id.firstImage)
        private val secondPhoto = itemView.findViewById<AppCompatImageView>(R.id.secondImage)
        private val thirdPhoto = itemView.findViewById<AppCompatImageView>(R.id.thirdImage)

        override fun onBind(list: List<ModelClass.ModelClassItem>) {
            Glide.with(firstPhoto.context)
                .load(list[0].urls.regular)
//                .override(250, 250)
                .into(firstPhoto)

            Glide.with(secondPhoto.context)
                .load(list[1].urls.regular)
                //                .override(250, 250)
                .into(secondPhoto)

            Glide.with(thirdPhoto.context)
                .load(list[2].urls.regular)
                //                .override(250, 250)
                .into(thirdPhoto)
        }
    }

    class PhotoViewHolderTwo constructor(itemView: View) : RecyclerView.ViewHolder(itemView), Bind {
        private val firstPhoto = itemView.findViewById<AppCompatImageView>(R.id.firstImage)
        private val secondPhoto = itemView.findViewById<AppCompatImageView>(R.id.secondImage)
        private val thirdPhoto = itemView.findViewById<AppCompatImageView>(R.id.thirdImage)

        override fun onBind(list: List<ModelClass.ModelClassItem>) {
            Glide.with(firstPhoto.context)
                .load(list[0].urls.regular)
                //                .override(250, 250)
                .into(firstPhoto)

            Glide.with(secondPhoto.context)
                .load(list[1].urls.regular)
                //                .override(250, 250)
                .into(secondPhoto)

            Glide.with(thirdPhoto.context)
                .load(list[2].urls.regular)
                //                .override(250, 250)
                .into(thirdPhoto)
        }
    }

    class PhotoViewHolderThree constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
        Bind {
        private val firstPhoto = itemView.findViewById<AppCompatImageView>(R.id.firstImage)
        private val secondPhoto = itemView.findViewById<AppCompatImageView>(R.id.secondImage)
        private val thirdPhoto = itemView.findViewById<AppCompatImageView>(R.id.thirdImage)


        override fun onBind(list: List<ModelClass.ModelClassItem>) {
            Glide.with(firstPhoto.context)
                .load(list[0].urls.regular)
                //                .override(250, 250)
                .into(firstPhoto)

            Glide.with(secondPhoto.context)
                .load(list[1].urls.regular)
                //                .override(250, 250)
                .into(secondPhoto)

            Glide.with(thirdPhoto.context)
                .load(list[2].urls.regular)
                //                .override(250, 250)
                .into(thirdPhoto)
        }
    }

    companion object {
        const val VIEW_TYPE_ONE = 0
        const val VIEW_TYPE_TWO = 1
        const val VIEW_TYPE_THERE = 2
        const val VIEW_TYPE_FOUR = 3
    }

    interface Bind {
        fun onBind(list: List<ModelClass.ModelClassItem>)
    }
}