package ru.innowise.danko.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student_groups", schema = "testdatabase")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class StudentGroups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @ManyToMany(mappedBy = "studentGroups")
    private Set<Student> students = new HashSet<>();

    /*@OneToOne(mappedBy = "studentGroups", fetch = FetchType.EAGER)*/
    @OneToMany(mappedBy = "studentGroups", fetch = FetchType.EAGER)
    private Collection<RecordBook> recordBookCollection;
}
