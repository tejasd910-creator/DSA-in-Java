import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class FractionalKnapsack {

    public static double getMaxValue(Item[] items, int capacity) {

        // Sort items by value/weight ratio in descending order
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                double r1 = (double) a.value / a.weight;
                double r2 = (double) b.value / b.weight;
                return Double.compare(r2, r1);
            }
        });

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                // Take whole item
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                // Take fraction of item
                totalValue += ((double) item.value / item.weight) * capacity;
                break;
            }
        }

        return totalValue;
    }
}
