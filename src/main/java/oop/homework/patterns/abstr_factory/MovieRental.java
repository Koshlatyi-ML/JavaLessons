package oop.homework.patterns.abstr_factory;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class MovieRental {
    private static Map<Movie, List<Language>> moviesCatalog;

    public static Movie rentMovie(String title, Language language) {
        Movie movie = moviesCatalog.keySet().stream()
                .filter(m -> title.equals(m.getTitle()))
                .findAny().orElseThrow(NoSuchElementException::new);
        movie.setLocalization(language);
        return movie;
    }
}
