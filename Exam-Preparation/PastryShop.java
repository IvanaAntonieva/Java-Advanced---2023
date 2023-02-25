import java.util.ArrayDeque;
import java.util.Scanner;

public class PastryShop {
    private static final int BISCUIT_VALUE = 25;
    private static final int CAKE_VALUE = 50;
    private static final int PASTRY_VALUE = 75;
    private static final int PIE_VALUE = 100;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> solids = new ArrayDeque<>();

        String[] liquidsInfo = scanner.nextLine().split("\\s+");
        String[] solidsInfo = scanner.nextLine().split("\\s+");

        for (String liquid : liquidsInfo) {
            liquids.offer(Integer.parseInt(liquid));
        }
        for (String solid : solidsInfo) {
            solids.push(Integer.parseInt(solid));
        }
        int biscuits = 0; int cakes = 0; int pastries = 0; int pies = 0;
        while (!liquids.isEmpty() && !solids.isEmpty()) {
            int solid = solids.peek();
            int sumIngredients = liquids.poll() + solids.pop();
            switch (sumIngredients) {
                case BISCUIT_VALUE:
                    biscuits++;
                    break;
                case CAKE_VALUE:
                    cakes++;
                    break;
                case PASTRY_VALUE:
                    pastries++;
                    break;
                case PIE_VALUE:
                    pies++;
                    break;
                default:
                    solids.push(solid+3);
            }
        }
        if (biscuits > 0 && cakes > 0 && pastries > 0 && pies > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            System.out.println(liquids.toString().replaceAll("[\\[\\]]", ""));
        }
        if (solids.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            System.out.println(solids.toString().replaceAll("[\\[\\]]", ""));
        }
        System.out.printf("Biscuit: %d%nCake: %d%nPie: %d%nPastry: %d", biscuits, cakes, pies, pastries);
    }
}
