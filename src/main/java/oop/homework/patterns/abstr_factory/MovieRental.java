package oop.homework.patterns.abstr_factory;

import java.util.*;

public class MovieRental {
    private Map<Movie, List<Language>> moviesCatalog
            = new HashMap<Movie, List<Language>> () {{
                put(new Movie("Interstellar"), new ArrayList<Language>() {{
                    add(Language.ENGLISH);
                    add(Language.FRENCH);
                    add(Language.RUSSIAN);
                }});
                put(new Movie("Trainspotting"), new ArrayList<Language>() {{
                    add(Language.ENGLISH);
                    add(Language.NORWEGIAN);
                }});
                put(new Movie("Star Wars 3"), new ArrayList<Language>() {{
                    add(Language.ENGLISH);
                    add(Language.NORWEGIAN);
                    add(Language.UKRAINIAN);
                }});
    }};

    private static MovieRental INSTANCE = new MovieRental();

    public static MovieRental getInstance() {
        return INSTANCE;
    }

    public Movie rentMovie(String title, Language language) {
        Movie movie = moviesCatalog.keySet().stream()
                .filter(m -> title.equals(m.getTitle()))
                .findAny().orElseThrow(NoSuchElementException::new);

        if (!moviesCatalog.get(movie).contains(language)) {
            throw new NoSuchElementException();
        }
        movie.setLocalization(language);
        return movie;
    }
}
