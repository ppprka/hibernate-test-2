package ru.innowise.danko.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student", schema = "testdatabase")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "student_students_group", schema = "testdatabase",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_group_id") }
    )
    private Set<StudentGroups> studentGroups = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_book_id")
    private RecordBook recordBook;
}
