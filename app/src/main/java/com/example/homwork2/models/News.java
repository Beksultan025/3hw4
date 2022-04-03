package com.example.homwork2.models;

import android.content.ServiceConnection;

import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

@Entity
public class News implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Comparator<News> newsComparator = new Comparator<News>() {
        @Override
        public int compare(News p1, News p2) {
            return p1.getTitle().compareTo(p2.getTitle());
        }
    };


    private String title;
    private long createdAt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public News(String title, long createdAt) {
        this.title = title;
        this.createdAt = createdAt;
    }

    public News() {
    }
}
