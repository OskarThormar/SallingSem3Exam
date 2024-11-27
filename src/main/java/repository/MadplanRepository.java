package repository;

import model.Madplan;

import java.util.List;

public class MadplanRepository {
    private Madplan madplan;
    private List<Madplan> madplanList;

    public MadplanRepository(Madplan madplan) {
        this.madplan = madplan;
    }

    public MadplanRepository() {
        madplan = new Madplan();
    }

    public double calculatePrice() {
        return 1;
    }

    public List<Madplan> getMadplan() {
        return madplanList;
    }

    public Madplan findNameById(int id) {
        return madplanList.get(id);
    }

    public void createMadplan(Madplan madplan) {

    }

    public void editMadplan(Madplan madplan) {

    }

    public void deleteMadplan(Madplan madplan) {

    }

}
