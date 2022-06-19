package com.app_notes.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_note")
    private int idNote;
    private String titleNote;
    private String content;
    @Temporal(TemporalType.DATE)
    private Date editionDate;
    boolean isArchived;

    //Relationship

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "note_category",
            joinColumns = @JoinColumn(name = "id_note"),
            inverseJoinColumns = @JoinColumn(name = "id_category")
    )

    private List<Category> categories;
}
