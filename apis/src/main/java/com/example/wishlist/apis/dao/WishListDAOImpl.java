package com.example.wishlist.apis.dao;

import com.example.wishlist.apis.model.WishList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;

@Repository("wishlistdao")
@Transactional
public class WishListDAOImpl {

    @Autowired
    EntityManager entityManager;

    public List<WishList> getAllWishListByUser(int userId) {
        Session session = entityManager.unwrap( Session.class );
        List<WishList> wishList = (List<WishList>) session.createQuery("select w from WishList w where w.userId =:userid ")
                .setParameter("userid", userId).list();

        return wishList;
    }

    public void addItemToWishList(WishList wishList) {
        Session session = entityManager.unwrap( Session.class );
        session.persist(wishList);
    }
}
