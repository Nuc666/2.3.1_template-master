package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

   void editUser(User modifiedUser, Long id);

   void deleteUser(User user);

   User getUser(Long id);


}
