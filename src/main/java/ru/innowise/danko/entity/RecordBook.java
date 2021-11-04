package ru.innowise.danko.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Table(name = "record_book", schema = "testdatabase")
public class RecordBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "graduation_year")
    private String graduationYear;

    @OneToOne(optional = false,mappedBy = "recordBook")
    private Student student;

    /*@OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="student_group_id")*/
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="student_group_id")
    private StudentGroups studentGroups;
}
