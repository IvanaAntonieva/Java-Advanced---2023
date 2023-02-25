package shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (capacity > data.size()) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name) && this.data.get(i).getCaretaker().equals(caretaker)) {
              return this.data.get(i);
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
        return this.data.stream()
                .max(Comparator.comparingInt(Animal::getAge))
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The shelter has the following animals:")
                .append(System.lineSeparator());
        this.data.forEach(animal ->
                sb.append(animal.getName())
                        .append(" ")
                        .append(animal.getCaretaker())
                        .append(System.lineSeparator()));
        return sb.toString();
    }
}
