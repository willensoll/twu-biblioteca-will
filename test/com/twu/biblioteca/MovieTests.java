package com.twu.biblioteca;
import com.twu.biblioteca.classes.Movie;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieTests {
    private Movie testMovie;

    @Before
    public void setUp() {
        testMovie = new Movie("Up", "Pete Docter", 2009, "4.7");
    }

    @Test
    public void movie_has_name_value() {
        assertThat(testMovie.getName(), is("Up"));
    }

    @Test
    public void movie_has_author_value() {
        assertThat(testMovie.getAuthor(), is("Pete Docter"));
    }

    @Test
    public void movie_has_publishedDate_value() {
        assertThat(testMovie.getPublishYear(), is(2009));
    }

    @Test
    public void movie_has_star_rating_value() {
        assertThat(testMovie.getStarRating(), is("4.7"));
    }
}