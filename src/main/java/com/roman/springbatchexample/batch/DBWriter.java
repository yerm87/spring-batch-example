package com.roman.springbatchexample.batch;

import com.roman.springbatchexample.model.User;
import com.roman.springbatchexample.repository.UserRepo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<User> {
    private final UserRepo userRepo;

    @Autowired
    public DBWriter(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public void write(List<? extends User> users) {
        System.out.println("Data was saved");
        userRepo.saveAll(users);
    }
}
