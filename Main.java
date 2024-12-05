public class Main {
    public static void main(String[] args) {
        Database db = new Database();

        // Створення акторів
        Actor margotRobbie = new Actor("Margot Robbie");
        Actor ryanGosling = new Actor("Ryan Gosling");
        Actor emptyActor = new Actor("");

        // Спроба додавання акторів
        try {
            db.addActor(margotRobbie);
            db.addActor(ryanGosling);
            db.addActor(emptyActor); // Викине IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }

        // Створення фільмів
        Film barbie = new Film("Barbie");
        Film emptyFilm = new Film("  "); // Некоректний фільм
        Film nullFilm = null; // Null-фільм

        // Спроба додавання фільмів
        try {
            db.addFilm(barbie);
            db.addFilm(emptyFilm); // Викине BusinessRuleViolationException
        } catch (BusinessRuleViolationException e) {
            System.out.println("Caught BusinessRuleViolationException: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } finally {
            System.out.println("Film addition process completed.");
        }

        try {
            db.addFilm(nullFilm); // Викине NullPointerException
        } catch (BusinessRuleViolationException e) {
            System.out.println("Caught BusinessRuleViolationException: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } finally {
            System.out.println("Another film addition process completed.");
        }

        // Перевірка бази даних
        System.out.println("Films in the database: " + db.getFilms());
        System.out.println("Actors in the database: " + db.getActors());
    }
}
