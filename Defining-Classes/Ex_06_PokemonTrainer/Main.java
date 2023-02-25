package Ex_06_PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Pokemon>> pokemonByTrainers = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("Tournament")) {
            //"{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}"
            String[] lineData = line.split("\\s+");
            String trainerName = lineData[0];
            String pokemonName = lineData[1];
            String pokemonElement = lineData[2];
            int pokemonHealth = Integer.parseInt(lineData[3]);
            Pokemon currentPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            pokemonByTrainers.putIfAbsent(trainerName, new ArrayList<>());
            pokemonByTrainers.get(trainerName).add(currentPokemon);
            line = scanner.nextLine();
        }
        List<Trainer> trainerList = pokemonByTrainers.entrySet()
                .stream()
                .map(t -> new Trainer(t.getKey(), t.getValue()))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            for (Trainer trainer:trainerList) {
                trainer.commandExecuting(command);
            }
            command = scanner.nextLine();
        }
        trainerList.stream()
                .sorted(Comparator.comparingInt(Trainer::getBadges).reversed())
                .forEach(System.out::println);
    }
}
