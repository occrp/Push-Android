package com.asiaplus.push.interfaces.SyncManager;

import com.asiaplus.push.model.Article;

import java.util.ArrayList;

import retrofit.RetrofitError;

/**
 * Created by christopher on 7/14/16.
 */
public interface ArticlesDelegate
{
    void didRetrieveArticles(Object articles, ArrayList<String> categories, RetrofitError error);
}
