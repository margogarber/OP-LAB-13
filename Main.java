public class Main {
    public static void main(String[] args) {
        Database db = new Database();


        Actor margotRobbie = new Actor("Margot Robbie");
        Actor ryanGosling = new Actor("Ryan Gosling");
        Actor emptyActor = new Actor("");


        try {
            db.addActor(margotRobbie);
            db.addActor(ryanGosling);
            db.addActor(emptyActor);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }


        Film barbie = new Film("Barbie");
        Film emptyFilm = new Film("  "); 
        Film nullFilm = null; 

        try {
            db.addFilm(barbie);
            db.addFilm(emptyFilm); 
        } catch (BusinessRuleViolationException e) {
            System.out.println("Caught BusinessRuleViolationException: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } finally {
            System.out.println("Film addition process completed.");
        }

        try {
            db.addFilm(nullFilm); 
        } catch (BusinessRuleViolationException e) {
            System.out.println("Caught BusinessRuleViolationException: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } finally {
            System.out.println("Another film addition process completed.");
        }

        System.out.println("Films in the database: " + db.getFilms());
        System.out.println("Actors in the database: " + db.getActors());
    }
}
