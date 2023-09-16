package com.weparty.api.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Like")
public class LikeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "like_id", nullable = false)
    private Long likeId;

    @Column(name="type")
    private String type;

    @Column(name="likeUserId")
    private Long likeUserId;

    @Column(name="likeEventId")
    private Long likeEventId;
}
