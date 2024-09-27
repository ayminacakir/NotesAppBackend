package org.example.notesappbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "folderName", nullable = false)
    //nullable bu alanın boş bırakılamayacağını gösterir mutlaka her notun bir foldertexi olacak
    private String folderName;

    @Column(name = "noteTitle", nullable = false)
    private String noteTitle;

    @Column(name = "noteText", nullable = false)
    private String noteText;

    private List<File> files;
    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}


