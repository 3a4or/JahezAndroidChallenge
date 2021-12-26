package net.jahez.jahezchallenge.ui.restaurants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import net.jahez.jahezchallenge.MyApp
import net.jahez.jahezchallenge.R
import net.jahez.jahezchallenge.data.entities.RestaurantsResponseItem
import net.jahez.jahezchallenge.databinding.ItemRestaurantBinding

class RestaurantsAdapter : ListAdapter<RestaurantsResponseItem, RestaurantsAdapter.ItemViewHolder>(diff){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemRestaurantBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(itemBinding)
    }

    override fun onBindViewHolder(itemViewHolder: ItemViewHolder, position: Int) {
        itemViewHolder.bind(getItem(position))
    }

    class ItemViewHolder(private val mBinding: ItemRestaurantBinding)
        : RecyclerView.ViewHolder(mBinding.root) {
        fun bind(item: RestaurantsResponseItem) {
            mBinding.item = item
            Glide.with(MyApp.appContext).load(item.image)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(mBinding.imgThumb)
            mBinding.executePendingBindings()
        }
    }

    companion object {
        val diff by lazy {
            object : DiffUtil.ItemCallback<RestaurantsResponseItem?>() {
                override fun areItemsTheSame(oldItem: RestaurantsResponseItem, newItem: RestaurantsResponseItem): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: RestaurantsResponseItem, newItem: RestaurantsResponseItem): Boolean {
                    return oldItem == newItem
                }
            }
        }
    }
}