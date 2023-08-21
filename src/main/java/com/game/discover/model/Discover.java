package com.game.discover.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Discover {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long idUser1;
    private long idUser2;
}
