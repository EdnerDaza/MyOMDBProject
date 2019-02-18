package com.daza.edner.myomdbproject.ui.list;

import com.daza.edner.myomdbproject.data.models.SearchEntity;

public interface MovieListListener {
    void onItemClick(SearchEntity entity, int position);
}
