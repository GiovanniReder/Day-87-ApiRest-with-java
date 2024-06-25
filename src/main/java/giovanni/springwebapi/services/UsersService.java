package giovanni.springwebapi.services;

import giovanni.springwebapi.entities.User;
import giovanni.springwebapi.exceptions.NotFoundException;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
@Getter
@Service
public class UsersService {
    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public User saveUser(User body){
        Random rndm = new Random();
        body.setId(rndm.nextInt(1 , 10000));
        this.userList.add(body);
        return body;
    }

    public User findById(int id){
        User found = null;
        for(User user: this.userList){
            if (user.getId() == id) found = user;
        }
        if (found == null) throw new NotFoundException(id);
        else return found;
    }

    public User findByIdAndUpdate(int id, User updatedUser){
        User found = null;
        for(User user: this.userList){
            if (user.getId() == id)
                found = user;
            found.setName(updatedUser.getName());
            found.setSurname(updatedUser.getSurname());
        }
        if (found == null) throw new NotFoundException(id);
      else   return found;
    }

    public void findByIdAndDelete(int id){
        Iterator<User> iterator = this.userList.iterator();
        while (iterator.hasNext()){
            User current = iterator.next();
            if (current.getId() == id){
                iterator.remove();
            }
        }

}
}
