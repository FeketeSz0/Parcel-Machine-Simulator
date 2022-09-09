package com.example.demo.modells;

import com.example.demo.Services.PostBoxService;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

@Data
@Entity
@NoArgsConstructor
public class PostBox {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;
    private Integer capacity;
    private Integer freeSpace;
    private Integer usedSpace;

    private Integer InQueue;


    public PostBox(String name, Integer capacity, Integer freeSpace, Integer usedSpace, Integer InQueue) {
        this.name = name;
        this.capacity = capacity;
        this.freeSpace = freeSpace;
        this.usedSpace = usedSpace;
        this.InQueue = InQueue;
    }
}
