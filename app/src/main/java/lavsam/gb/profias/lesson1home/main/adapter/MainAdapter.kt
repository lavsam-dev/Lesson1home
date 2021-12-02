package lavsam.gb.profias.lesson1home.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lavsam.gb.profias.lesson1home.databinding.TranslationRecyclerviewItemBinding
import lavsam.gb.profias.lesson1home.model.data.Vocabulary

class MainAdapter (
    private var onListItemClickListener: OnListItemClickListener,
    private var data: List<Vocabulary>,
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    fun setData(data: List<Vocabulary>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TranslationRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(val binding: TranslationRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Vocabulary) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                binding.headerTextviewRecyclerItem.text = data.text
                binding.descriptionTextviewRecyclerItem.text = data.meanings?.first()?.translation?.translation
                itemView.setOnClickListener { openInNewWindow(data) }
            }
        }
    }

    private fun openInNewWindow(listItemData: Vocabulary) {
        onListItemClickListener.onItemClick(listItemData)
    }

    interface OnListItemClickListener {
        fun onItemClick(data: Vocabulary)
    }
}