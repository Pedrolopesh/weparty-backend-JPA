package com.weparty.api.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "UserConnections")
public class UserConnectionsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_connections_id", nullable = false)
    private Long userConnectionsId;

    @Column(name="userSystemId")
    private Long userSystemId;

}
