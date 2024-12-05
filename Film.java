import java.util.HashSet;

public class Film implements Comparable<Film> {
    private String title;
    private HashSet<Actor> actors;

    public Film(String title) {
        this.title = title;
        this.actors = new HashSet<>();
    }

    public String getTitle() {
        return title;
    }

    public HashSet<Actor> getActors() {
        return actors;
    }

    public void addActor(Actor actor) {
        if (actor == null) {
            throw new NullPointerException("Actor cannot be null.");
        }
        if (!actors.contains(actor)) {
            actors.add(actor);
            actor.addFilm(this); // Bi-directional link
        }
    }

    @Override
    public int compareTo(Film other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return title;
    }
}
