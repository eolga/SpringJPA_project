import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {

    public static void main(String[] args) {
        System.out.println ("Hi");

        List<String> list = Arrays.asList("Кошка","Конь","Рыба","Крокодил");

        /*list.stream()
                .filter (s -> s.startsWith ("К"))
                .sorted()
                .forEach (System.out ::println);*/
        Stream<String> stream = list.stream();
        //stream.filter (s -> s.toLowerCase().startsWith ("К")).forEach(System.out::println);
        stream.sorted().forEach(System.out :: println);

    list = stream.collect(Collectors.toList());
    System.out.println(list);


    }

}