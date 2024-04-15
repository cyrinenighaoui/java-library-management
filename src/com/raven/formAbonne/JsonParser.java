package com.raven.formAbonne;


import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.raven.formAbonne.Book;
import java.lang.reflect.Type;
import java.util.List;

public class JsonParser {
    public static List<Book> parseBooks(String json) {
        Gson gson = new Gson();
        Type bookListType = new TypeToken<List<Book>>(){}.getType();
        return gson.fromJson(json, bookListType);
    }
}
