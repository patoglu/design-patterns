public class Main
{
    public static void main(String[] args)
    {


        int[][] data = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Satellite satellite = new Satellite(data);

        System.out.println("Spirally Clockwise");
        while (satellite.hasNext()){
            System.out.print(satellite.next() + " ");
        }
    }
}