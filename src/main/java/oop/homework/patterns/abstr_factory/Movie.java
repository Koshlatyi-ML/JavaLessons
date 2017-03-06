package oop.homework.patterns.abstr_factory;

import java.util.Objects;

public class Movie{
    private String title;
    private Soundtrack soundtrack = new Soundtrack();
    private Subtitles subtitles = new Subtitles();

    Movie(String title, Language language) {
        this.title = title;
        this.soundtrack.setLanguage(language);
        this.subtitles.setLanguage(language);
    }

    Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Soundtrack getSoundtrack() {
        return soundtrack;
    }

    public Subtitles getSubtitles() {
        return subtitles;
    }

    public void setLocalization(Language language) {
        if (language == null) {
            throw new IllegalArgumentException();
        }
        this.subtitles.setLanguage(language);
        this.soundtrack.setLanguage(language);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(getTitle(), movie.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }

    static class Soundtrack {
        Language language;

        public void setLanguage(Language language) {
            this.language = language;
        }

        public Language getLanguage() {
            return language;
        }
    }

    static class Subtitles {
        Language language;

        public void setLanguage(Language language) {
            this.language = language;
        }

        public Language getLanguage() {
            return language;
        }
    }
}
