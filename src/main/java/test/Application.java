package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.*;

public class Application {

    private final static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args)  {
        //System.out.println("Hi");

        logger.info("Hi!!");

        List<String> list = asList("Кошка", "Конь", "Рыба", "Крокодил");
        /*list.stream()
                .filter(s -> s.toLowerCase().startsWith("к"))
                .sorted()
                .forEach(System.out::println);
*/
        Stream<String> stream = list.stream();
        // stream.filter(s -> s.toLowerCase().startsWith("к")).forEach(System.out::println);
        //stream.sorted().forEach(System.out::println);

        list = stream.filter(s -> s.toLowerCase().startsWith("к")).sorted().collect(Collectors.toList());

        System.out.println(list);



    }
}
