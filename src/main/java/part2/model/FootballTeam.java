package part2.model;

/**
 * Created by Jakub on 1/9/2017.
 */
public class FootballTeam {
    private String name;

    private int goalsScored;

    private int goalsLost;

    public FootballTeam() {

    }

    public FootballTeam(String name, int goalsLost, int goalsScored) {
        this.name = name;
        this.goalsLost = goalsLost;
        this.goalsScored = goalsScored;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoalsLost() {
        return goalsLost;
    }

    public void setGoalsLost(int goalsLost) {
        this.goalsLost = goalsLost;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FootballTeam that = (FootballTeam) o;

        if (goalsScored != that.goalsScored) return false;
        if (goalsLost != that.goalsLost) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + goalsScored;
        result = 31 * result + goalsLost;
        return result;
    }
}
