package ru.netology.afisha;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    @Test
    public void сonstructorWithLimit() {
        PosterManager servis = new PosterManager(5);

        Assertions.assertEquals(5, servis.getLimit());
    }

    @Test
    void сonstructorMoreWithLimit() {
        PosterManager servis = new PosterManager(6);

        Assertions.assertEquals(6, servis.getLimit());
    }

    @Test
    void сonstructorLessWithLimit() {
        PosterManager servis = new PosterManager(4);

        Assertions.assertEquals(4, servis.getLimit());
    }


    @Test
    public void creatingFirstMovie() {
        PosterManager servis = new PosterManager();

        servis.save("Бладшот");
        servis.save("Вперед");
        servis.save("Отель Белград");

        String[] expected = {"Бладшот", "Вперед", "Отель Белград"};
        String[] actual = servis.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void outputMinimumNumberOfFilms() {
        PosterManager servis = new PosterManager();

        servis.save("Бладшот");
        servis.save("Вперед");
        servis.save("Отель Белград");

        String[] expected = {"Отель Белград", "Вперед", "Бладшот"};
        String[] actual = servis.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void outputLimitNumberOfFilms() {
        PosterManager servis = new PosterManager();

        servis.save("Бладшот");
        servis.save("Вперед");
        servis.save("Отель Белград");
        servis.save("Джентльмены");
        servis.save("Человек-Невидимка");


        String[] expected = {"Человек-Невидимка", "Джентльмены", "Отель Белград", "Вперед", "Бладшот"};
        String[] actual = servis.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void outputMoreLimit() {
        PosterManager servis = new PosterManager();

        servis.save("Бладшот");
        servis.save("Вперед");
        servis.save("Отель Белград");
        servis.save("Джентльмены");
        servis.save("Человек-Невидимка");
        servis.save("Тролли.Мировой тур");

        String[] expected = {"Тролли.Мировой тур", "Человек-Невидимка", "Джентльмены", "Отель Белград", "Вперед"};
        String[] actual = servis.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }


}
