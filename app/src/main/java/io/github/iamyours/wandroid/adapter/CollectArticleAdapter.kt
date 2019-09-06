package io.github.iamyours.wandroid.adapter

import io.github.iamyours.wandroid.R
import io.github.iamyours.wandroid.databinding.ItemCollectArticleBinding
import io.github.iamyours.wandroid.util.RouterUtil
import io.github.iamyours.wandroid.vo.ArticleVO

class CollectArticleAdapter :
    DataBoundAdapter<ArticleVO, ItemCollectArticleBinding>() {
    override fun initView(binding: ItemCollectArticleBinding, item: ArticleVO) {
        binding.vo = item
        binding.root.setOnClickListener {
            RouterUtil.navWeb(item, it.context) { collect ->
                if (!collect) {
                    mData.remove(item)
                    notifyDataSetChanged()
                }

            }
        }
    }

    override val layoutId: Int
        get() = R.layout.item_collect_article
}