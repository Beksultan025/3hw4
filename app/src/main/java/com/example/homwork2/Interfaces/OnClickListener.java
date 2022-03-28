package com.example.homwork2.Interfaces;

import com.example.homwork2.models.News;

public interface OnClickListener {
    void onItemClick(int position);
    void onItemLongClick(int position, News news);
}
