package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (capacity > this.registry.size()) {
            this.registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName) {
        for (int i = 0; i < this.registry.size(); i++) {
            if (this.registry.get(i).getFirstName().equals(firstName)) {
                this.registry.remove(i);
                return true;
            }
        }
        return false;
    }

    public Integer getChildrenCount() {
        return this.registry.size();
    }

    public Child getChild(String firstName) {
        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)) {
                return child;
            }
        }
        return null;
    }

    public String registryReport() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Registered children in %s:", this.name)).append(System.lineSeparator());
        List<Child> sortedRegistry = registry.stream()
                .sorted(Comparator.comparing(Child::getAge).thenComparing(Child::getFirstName).thenComparing(Child::getLastName))
                .collect(Collectors.toList());
        for (Child child : sortedRegistry) {
            sb.append("--").append(System.lineSeparator());
            sb.append(child.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
