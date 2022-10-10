package web.dao;



import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void add(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public void editUser(User modifiedUser, Long id) {
        User currentUser = getUser(id);
        if (currentUser.getFirstName() != null) {
            currentUser.setFirstName(modifiedUser.getFirstName());
        }
        if (currentUser.getLastName() != null) {
            currentUser.setLastName(modifiedUser.getLastName());
        }
        if (currentUser.getEmail() != null) {
            currentUser.setEmail(modifiedUser.getEmail());
        }

        entityManager.persist(currentUser);
    }

    public void deleteUser(Long id) {
        entityManager.remove(getUser(id));
    }

    public User getUser(Long id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id =: id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

}
