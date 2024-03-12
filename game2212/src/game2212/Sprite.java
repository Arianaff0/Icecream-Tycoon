
public class Sprite {
hda;
}
public static int[] generateRandomArray(int length) {
    int[] array = new int[length];
    Random random = new Random();
    for (int i = 0; i < length; i++) {
        array[i] = random.nextInt(100); // Generates random integers between 0 and 99
    }
    return array;
}
}
