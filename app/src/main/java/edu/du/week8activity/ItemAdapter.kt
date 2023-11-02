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
    }

    private val context: Context = context

    private inner class TypeOneViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
            private var currentItem: ListItem? = null

            fun bind(item: ListItem) {
                currentItem = item

                val uri: Uri = Uri.parse("https://robohash.org/" + item.name + "?size=200x200")
                itemView.findViewById<TextView>(R.id.item_title).text = item.name
                loadImage(context, itemView.findViewById(R.id.item_image), uri)
            }

        }

    private inner class TypeTwoViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private var currentItem: ListItem? = null

        fun bind(item: ListItem) {
            currentItem = item

            val uri: Uri = Uri.parse("https://robohash.org/" + item.name + "?size=200x200")
            itemView.findViewById<TextView>(R.id.item_title).text = item.name
            loadImage(context, itemView.findViewById(R.id.item_image), uri)
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
        } else {
            return TypeTwoViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_type_two, parent, false))
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
        } else {
            (holder as TypeTwoViewHolder).bind(items[position])
        }
    }

}
