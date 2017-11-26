package ch08.sec09;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingIntoMaps {

    public static class Person {
        private int id;
        private String name;

        public Person(int id, String name) { this.id = id; this.name = name; }
        public int getId() { return id; }
        public String getName() { return name; }
        public String toString() { return getClass().getName() +
              "[id=" + id + ",name=" + name + "]";
        }
    }

    public static Stream<Person> people() {
        return Stream.of(new Person(1001, "Peter 1001-1"), new Person(1001, "Peter 1002"), new Person(1002, "Paul"), new Person(1003,
                "Mary"));
    }

    public static void main(String[] args) throws IOException {


        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = locales.collect(Collectors.toMap(
                Locale::getDisplayLanguage,
                Locale::getDisplayLanguage,
                (existingValue, newValue) -> existingValue));
        System.out.println("languageNames: " + languageNames);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryLanguageSets = locales.collect(
                Collectors.toMap(
                        Locale::getDisplayCountry,
                        l -> Collections.singleton(l.getDisplayLanguage()),
                        (a, b) -> { // union of a and b
                            Set<String> union = new HashSet<>(a);
                            union.addAll(b);
                            return union;
                }));
        System.out.println("countryLanguageSets: " + countryLanguageSets);
    }
}
