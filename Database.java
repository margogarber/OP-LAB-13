import java.util.*;

public class Database {
    private HashSet<Film> films;
    private HashSet<Actor> actors;

    public Database() {
        films = new HashSet<>();
        actors = new HashSet<>();
    }

    public void addFilm(Film film) throws BusinessRuleViolationException {
        if (film == null) {
            throw new NullPointerException("Film cannot be null.");
        }
        if (film.getTitle().trim().isEmpty()) {
            throw new BusinessRuleViolationException("Film title cannot be empty.");
        }
        if (!films.contains(film)) {
            films.add(film);
        }
    }

    public void addActor(Actor actor) {
        if (actor == null) {
            throw new NullPointerException("Actor cannot be null.");
        }
        if (actor.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Actor name cannot be empty.");
        }
        if (!actors.contains(actor)) {
            actors.add(actor);
        }
    }

    public HashSet<Actor> getActors() {
        return actors;
    }

    public HashSet<Film> getFilms() {
        return films;
    }
}
