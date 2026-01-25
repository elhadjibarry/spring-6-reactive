package guru.springframework.spring6reactive.guru.springframework.spring6reactiveexamples.repositories;

import guru.springframework.spring6reactive.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PersonRepositoryImpl implements PersonRepository {

    Person michael = Person.builder().id(1).firstName("Michael").lastName("Weston").build();
    Person fiona = Person.builder().id(2).firstName("Fiona").lastName("Glenanne").build();
    Person sam = Person.builder().id(3).firstName("Sam").lastName("Axe").build();
    Person jesse = Person.builder().id(4).firstName("Jesse").lastName("Porter").build();

    @Override
    public Mono<Person> getById(Integer id) {
        return switch (id) {
            case 1 -> Mono.just(michael);
            case 2 -> Mono.just(fiona);
            case 3 -> Mono.just(sam);
            case 4 -> Mono.just(jesse);
            default -> Mono.empty();
        };
    }

    @Override
    public Flux<Person> findAll() {
        return Flux.just(michael, fiona, sam, jesse);
    }
}