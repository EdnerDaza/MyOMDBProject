package com.daza.edner.myomdbproject.interfaces;

import com.daza.edner.myomdbproject.models.SearchEntity;

public interface OnMovieListener {
    void onItemClick(SearchEntity entity, int position);
}
