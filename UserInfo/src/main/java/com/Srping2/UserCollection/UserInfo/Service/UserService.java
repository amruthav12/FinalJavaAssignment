package com.Srping2.UserCollection.UserInfo.Service;

import com.Srping2.UserCollection.UserInfo.Entity.User;
import com.Srping2.UserCollection.UserInfo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    //now do dependency injection
    @Autowired
    //now there is a interface in repository package.
            //this method just reads the database and prints to the view.
            UserRepository repository;
    public List<User> getAllUsers(){
        List<User> UserList = (List<User>) repository.findAll();
        if(UserList.size()<0){
            return UserList;
        }
        else{
            return new ArrayList<User>();
        }
    }
    public User getUserByID(Long id) throws Exception{
        Optional <User> usr =repository.findById(id);
    if(usr.isPresent()){
    return usr.get();
    }else{
    throw new Exception();
    }
}
    public User CreateOrUpdate(User entity){
        if(entity.getId() == -1){
            entity = repository.save(entity);
            return entity;
        }else{
            Optional<User> user = repository.findById(entity.getId());
            if(user.isPresent()){
                User usr = user.get();
                usr.setEmail(entity.getEmail());
                usr.setFirstName(entity.getFirstName());
                usr.setLastName(entity.getLastName());
                usr = repository.save(usr);
                return usr;
            }else{
                entity = repository.save(entity);
                return entity;
            }
        }
    }

    //delete
    public void deleteEmployeeById(Long id) throws Exception{
        Optional<User> user = repository.findById(id);
        if(user.isPresent()){
            repository.deleteById(id);
        }else{
            throw new Exception("No record found");
        }
    }


}
