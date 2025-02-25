package ru.netology.afisha;

import java.util.concurrent.atomic.AtomicInteger;

public class PosterManager {
    private String[] films = new String[0];
    private int limit;

    public PosterManager() {
        this.limit = 5;
    }

    public PosterManager (int limit){
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void save(String film) {
        String[] tmp = new String[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    public String[] findAll() {
        return films;
    }

    public String[] findLast() {
        int resultLength;
        if (films.length < limit) {
            resultLength = films.length;
        } else {
            resultLength = limit;
        }
        String[] result = new String[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = films[films.length - 1 - i];  // заполняем result из массива, что лежит в поле
            // в обратном порядке
        }
        return result;
    }
}
