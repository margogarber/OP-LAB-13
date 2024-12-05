import java.util.HashSet;

public class Actor implements Comparable<Actor> {
    private String name;
    private HashSet<Film> films;

    public Actor(String name) {
        this.name = name;
        this.films = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public HashSet<Film> getFilms() {
        return films;
    }

    public void addFilm(Film film) {
        if (film == null) {
            throw new NullPointerException("Film cannot be null.");
        }
        if (!films.contains(film)) {
            films.add(film);
            film.addActor(this); // Bi-directional link
        }
    }

    @Override
    public int compareTo(Actor other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
