public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // double[] array = {7, 7, 7};
        // NumStatsArr test = new NumStatsArr(array);
        // System.out.println(test.toString());
        // System.out.println(test.average());
        // System.out.println(test.range());
        // System.out.println(test.sortStatus());

        String[] newArr = {"cat", "cat", "cat", "cat"};
        StringStatsArr words = new StringStatsArr(newArr);
        // System.out.println(words.toString());
        // System.out.println(words.averageLength());
        // System.out.println(words.search("rat"));
        System.out.println(words.sortStatus());

        //System.out.println(words.sortStatus());
    }
}
