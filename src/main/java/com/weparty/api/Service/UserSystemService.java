package com.weparty.api.Service;

import com.weparty.api.Model.EventModel;
import com.weparty.api.Model.UserSystemModel;
import com.weparty.api.Repository.UserSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public Object update(Long id, UserSystemModel updatedUser) {
        Optional<UserSystemModel> userOptional = userSystemRepository.findById(Math.toIntExact(id));
        if (userOptional.isPresent()) {
            UserSystemModel existingUser = userOptional.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setDocument(updatedUser.getDocument());

            return userSystemRepository.save(existingUser);
        } else {
            return "not_found";
        }
    }

    public Object delete(Long id) {
        Optional<UserSystemModel> userOptional = userSystemRepository.findById(Math.toIntExact(id));
        if (userOptional.isPresent()) {
            userSystemRepository.deleteById(Math.toIntExact(id));
            return "user_deleted_true";
        } else {
            return "user_deleted_false";
        }
    }

    public Object findById(Long id) {
        try {
            Optional<UserSystemModel> perfilOptional = userSystemRepository.findById(Math.toIntExact(id));
            return perfilOptional;
        } catch (Exception e) {
            return  "not_found";
        }
    }

    public Object authenticate(String email, String password) {
        try {
            Optional<UserSystemModel> userOptional = userSystemRepository.findByEmailAndPassword(email, password);

            if (userOptional.isPresent()) {
                // Autenticação bem-sucedida
                return userOptional.get();
            } else {
                // Usuário não encontrado ou senha incorreta
                return "authentication_failed";
            }
        } catch (Exception e) {
            // Tratamento de exceção, se necessário
            return "error";
        }
    }
}
