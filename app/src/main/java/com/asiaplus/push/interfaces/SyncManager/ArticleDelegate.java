package com.asiaplus.push.interfaces.SyncManager;
import com.asiaplus.push.model.Article;

/**
 * Created by christopher on 7/14/16.
 */
public interface ArticleDelegate {
    void didRetrieveArticle(Article article);
}