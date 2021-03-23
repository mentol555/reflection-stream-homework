package reflect;

import javax.sql.ConnectionEventListener;
import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Homework1 {

    /**
     * Prints the declared methods of java.lang.String sorted by name.
     */
    public void streamPipeline1() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .sorted(Comparator.comparing(Arrays -> Arrays.getName()))
                .forEach(System.out::println);
    }

    /**
     *  Prints all distinct names of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline2() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .map(Arrays -> Arrays.getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with two or more parameters whose parameters are all of the same type, sorted by name.
     */
    public void streamPipeline3() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(Arrays -> Arrays.getParameterCount() >=2 )
                .sorted(Comparator.comparing(Arrays -> Arrays.getName()))
                .forEach(System.out::println);
    }

    /**
     * Prints all distinct return types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline4() {
        Arrays.stream(String.class.getDeclaredMethods())
                .map(Arrays -> Arrays.getReturnType().toString())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with at least one boolean parameter, sorted by name.
     */
    public void streamPipeline5() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(Arrays -> Arrays.getParameterCount() > 0)
                .filter(Arrays -> java.util.Arrays.toString(Arrays.getParameterTypes()).contains("boolean"))
                .sorted(Comparator.comparing(Arrays -> Arrays.getName()))
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String whose parameters are all of type int, sorted by name.
     */
    public void streamPipeline6() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(Arrays -> Arrays.getParameterCount() > 0)
                .filter(Arrays -> java.util.Arrays.stream(Arrays.getParameterTypes()).allMatch(c -> c == int.class))
                .sorted(Comparator.comparing(Arrays -> Arrays.getName()))
                .forEach(System.out::println);
    }

    /**
     * Returns the longest name of the declared methods of java.lang.String.
     */
    public String streamPipeline7() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .map(Arrays -> Arrays.getName())
                .max(Comparator.comparing(String::length))
                .get();
    }

    /**
     *  Returns the longest one from the names of the public declared methods of java.lang.String.
     */
    public String streamPipeline8() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .filter(Arrays -> Arrays.getModifiers() == Modifier.PUBLIC)
                .map(Arrays -> Arrays.getName())
                .max(Comparator.comparing(String::length))
                .get();
    }

    /**
     * Returns summary statistics about the number of parameters for the declared methods of java.lang.String.
     */
    public IntSummaryStatistics streamPipeline9() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .mapToInt(Arrays -> Arrays.getParameterCount())
                .summaryStatistics();
    }

    /**
     * Returns the maximum number of parameters accepted by the declared methods of java.lang.String.
     */
    public int streamPipeline10() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .mapToInt(Arrays -> Arrays.getParameterCount())
                .max().getAsInt();
    }

    /**
     * Returns the declared method of java.lang.String with the most number of parameters.
     */
    public Method streamPipeline11() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .max(Comparator.comparingInt(Arrays -> Arrays.getParameterCount()))
                .get();
    }

    /**
     * Prints all distinct parameter types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline12() {
        Arrays.stream(String.class.getDeclaredMethods())
                .flatMap(Arrays -> java.util.Arrays.stream(Arrays.getParameterTypes()))
                //sorted()
                .distinct()
                .forEach(System.out::println);
    }

}
