package edu.du.week8activity

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ItemAdapter(context: Context, private var items: ArrayList<ListItem>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
        const val VIEW_TYPE_THREE = 3
        const val VIEW_TYPE_FOUR = 4
    }

    private val context: Context = context

    private inner class TypeOneViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
            private var currentItem: ListItem? = null

            fun bind(item: ListItem) {
                currentItem = item

                val uri: Uri = Uri.parse("https://robohash.org/" + item.name + "?set=set4")
                itemView.findViewById<TextView>(R.id.item_title).text = item.name
                loadImage(context, itemView.findViewById(R.id.item_image), uri)
            }

        }

    private inner class TypeTwoViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private var currentItem: ListItem? = null

        fun bind(item: ListItem) {
            currentItem = item

            val uri: Uri = Uri.parse("https://robohash.org/" + item.name + "?set=set4")
            itemView.findViewById<TextView>(R.id.item_title).text = item.name
            loadImage(context, itemView.findViewById(R.id.item_image), uri)
        }

    }

    private inner class TypeThreeViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private var currentItem: ListItem? = null

        fun bind(item: ListItem) {
            currentItem = item

            val uri: Uri = Uri.parse("https://robohash.org/" + item.name + "?set=set1")
            itemView.findViewById<TextView>(R.id.item_title).text = item.name
            loadImage(context, itemView.findViewById(R.id.item_image), uri)
        }

    }

    private inner class TypeFourViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private var currentItem: ListItem? = null

        fun bind(item: ListItem) {
            currentItem = item

            val uri: Uri = Uri.parse("https://robohash.org/" + item.name + "?set=set2")
            val uri2: Uri = Uri.parse("https://robohash.org/" + item.name + "?set=set3")
            itemView.findViewById<TextView>(R.id.item_title).text = item.name
            loadImage(context, itemView.findViewById(R.id.item_image), uri)
            loadImage(context, itemView.findViewById(R.id.item_image2), uri2)
        }

    }

    fun loadImage(context: Context, imageView: ImageView, uri: Uri) {
        Glide
            .with(context)
            .load(uri)
            .centerCrop()
            .into(imageView)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_ONE) {
            return TypeOneViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_type_one, parent, false))
        } else if (viewType == VIEW_TYPE_TWO) {
            return TypeTwoViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_type_two, parent, false))
        } else if (viewType == VIEW_TYPE_THREE) {
            return TypeThreeViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_type_three, parent, false))
        } else {
            return TypeFourViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_type_four, parent, false))
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (items[position].viewType == VIEW_TYPE_ONE) {
            (holder as TypeOneViewHolder).bind(items[position])
        }
        else if (items[position].viewType == VIEW_TYPE_TWO) {
            (holder as TypeTwoViewHolder).bind(items[position])
        }
        else if (items[position].viewType == VIEW_TYPE_THREE) {
            (holder as TypeThreeViewHolder).bind(items[position])
        }
        else {
            (holder as TypeFourViewHolder).bind(items[position])
        }
    }

}
