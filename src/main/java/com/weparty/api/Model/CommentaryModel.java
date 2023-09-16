package com.weparty.api.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Commentary")
public class CommentaryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "commentary_id", nullable = false)
    private Long commentaryId;

    @Column(name="text")
    private String text;

    @Column(name="CommentaryUserId")
    private Long CommentaryUserId;

    @Column(name="CommentaryEventId")
    private Long CommentaryEventId;

}
