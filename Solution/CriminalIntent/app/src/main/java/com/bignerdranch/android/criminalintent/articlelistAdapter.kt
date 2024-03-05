package com.bignerdranch.android.criminalintent

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.criminalintent.databinding.ListItemCrimeBinding

class ArticleListAdapter(private val articles: List<Article>, private val onClick: (Article) -> Unit) : RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder>() {

    class ArticleViewHolder(view: View, val onClick: (Article) -> Unit) : RecyclerView.ViewHolder(view) {
        private val titleTextView: TextView = view.findViewById(R.id.article_title)
        private val descriptionTextView: TextView = view.findViewById(R.id.article_description)
        private var currentArticle: Article? = null

        init {
            view.setOnClickListener {
                currentArticle?.let {
                    onClick(it)
                }
            }
        }
        holder.itemView.setOnClickListener {
            val action = ArticleListFragmentDirections.actionArticleListFragmentToArticleDetailFragment(article.url)
            it.findNavController().navigate(action)
        }

        fun bind(article: Article) {
            currentArticle = article
            titleTextView.text = article.title
            descriptionTextView.text = article.description
        }
    }
}

