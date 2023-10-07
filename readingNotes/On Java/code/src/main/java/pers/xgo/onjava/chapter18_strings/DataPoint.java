package pers.xgo.onjava.chapter18_strings;

public class DataPoint {
    private String location;
    private Double temperature;

    public DataPoint(String loc, Double temp) {
        location = loc;
        temperature = temp;
    }

    @Override
    public String toString() {
        return """
                Location: %s
                Temperature: %.2f
                """.formatted(location, temperature);
    }

    public static void main(String[] args) {
        var hill = new DataPoint("Hill", 45.2);
        var dale = new DataPoint("Dale", 65.2);
        System.out.print(hill);
        System.out.print(dale);
    }
}
