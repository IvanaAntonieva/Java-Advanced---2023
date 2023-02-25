package Ex_07_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemonList;
    private List<Parents> parentsList;
    private List<Children> childrenList;
    private Car car;

    public Person() {
        this.pokemonList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }
    public List<Parents> getParentsList() {
        return parentsList;
    }
    public List<Children> getChildrenList() {
        return childrenList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company:").append(System.lineSeparator());
                if (company != null) {
                    sb.append(company).append(System.lineSeparator());
                }
                sb.append("Car: ").append(System.lineSeparator());
                if (car != null) {
                    sb.append(car).append(System.lineSeparator());
                }
                sb.append("Pokemon: ").append(System.lineSeparator());
        for (Pokemon pokemon : pokemonList) {
            sb.append(pokemon).append(System.lineSeparator());
        }
        sb.append("Parents: ").append(System.lineSeparator());
        for (Parents parent : parentsList) {
            sb.append(parent).append(System.lineSeparator());
        }
        sb.append("Children: ").append(System.lineSeparator());
        for (Children children:childrenList) {
            sb.append(children).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
