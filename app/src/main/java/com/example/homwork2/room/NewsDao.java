package com.example.homwork2.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.homwork2.models.News;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface NewsDao {

    @Query("SELECT * FROM news ORDER BY createdAt DESC")
    List<News> getAll();

    @Insert
    void insert(News news);

    @Query("SELECT * FROM news ORDER BY  title ASC")
    List<News> sort();

    @Query("SELECT * FROM news WHERE title LIKE '%' || :search || '%'")
    List<News> setupSearch(String search);

    @Delete
    void Delete ( News  news) ;

}
