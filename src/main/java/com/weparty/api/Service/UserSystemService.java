package com.weparty.api.Service;

import com.weparty.api.Model.UserSystemModel;
import com.weparty.api.Repository.UserSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserSystemService {
    @Autowired
    private UserSystemRepository userSystemRepository;

    public List<UserSystemModel> index() {
        return (List<UserSystemModel>) userSystemRepository.findAll();
    }

    public Object store(UserSystemModel userSystemModel) {
        try{
            return userSystemRepository.save(userSystemModel);

        }catch(Exception e){
            return e;
        }
    }
}
