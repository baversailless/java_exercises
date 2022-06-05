// создать класс Person(iin, fio, dateOfBirth), переопределить в соответствии с правилами hashCode и equals в этом классе.
// создать объект нужной коллекции с элементами типа Person где будут хранится только уникальные элементы, в том же порядке что они добавлялись.
// продемонстрировать это с помощью добавления разных объектов но с одинаковым состоянием и распечатать коллекцию.
// создать объект нужной коллекции с уникальными элементами типа Person, где добавляя объекты они будут сортироваться по возрасту (от старшего к младшему), добавить несколько элементов в коллекцию и вывести результат
// создать и заполнить список с объектами типа Person, где есть дубликаты и с помощью StreamApi оставить только уникальные элементы и отсортировать по длине фио (по возрастанию или убыванию не важно) и вывести результат
package kz.dz14;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StreamAndCollection {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("155", "Akhalai Makhalai", LocalDate.of(2000, 12, 22)),
                new Person("205", "Muchahas Loi", LocalDate.of(1975, 1, 31)),
                new Person("211", "Something Cool", LocalDate.of(1998, 8, 14)),
                new Person("155", "Akhalai Makhalai", LocalDate.of(2000, 12, 22)),
                new Person("211", "Woow CrazyGirl", LocalDate.of(2002, 03, 27))
        );


        Set<Person> uniquePersons = new LinkedHashSet<>();
        uniquePersons.addAll(persons);
        System.out.println("The list of persons with unique iin: ");
        System.out.println(
                         uniquePersons.stream()
                        .map(Person::getFio)
                        .collect(Collectors.joining(", "))
        );
        System.out.println();


        Set<Person> orderedPersons = new TreeSet<>(Comparator.comparing(Person::getDateOfBirth));
        orderedPersons.addAll(uniquePersons);
        System.out.println("The list of persons with ordered dates of birth from oldest to youngest");
        System.out.println(
                orderedPersons.stream()
                        .map(Person::getFio)
                        .collect(Collectors.joining(", "))
        );

        List<String> streamPersons = persons.stream()
                .distinct()
                .map(Person::getFio)
                .collect(Collectors.toList());
        Comparator<String> comparator = (o1, o2) -> o1.length() - o2.length();
        System.out.println();
        System.out.println("Sorted by length of names unique list of persons");
        streamPersons.stream()
                .sorted(comparator)
                .forEach(System.out::println);


    }
}

class Person {
    private final String iin;
    private String fio;
    private LocalDate dateOfBirth;

    public Person(String iin, String fio, LocalDate dateOfBirth){
        this.iin = iin;
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
    }
    public String getFio(){
        return fio;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

    public String getIin() {
        return iin;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return Objects.equals(iin, person.iin);
    }

    @Override
    public int hashCode(){
        return iin.hashCode();
    }
}
