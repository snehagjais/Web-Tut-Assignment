package com.example.wishlist.apis.services;

import com.example.wishlist.apis.dao.WishListDAOImpl;
import com.example.wishlist.apis.model.Item;
import com.example.wishlist.apis.model.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

@Service
public class WishListService {

    @Autowired
    WishListDAOImpl wishListDAO;

    public List<WishList> fetchAllWishlistItems(int userId) {
        return wishListDAO.getAllWishListByUser(userId);
    }

    public void addItemToWishlist(Item item, int userId) {
        WishList wishList = new WishList();
        wishList.setUserId(userId);
        wishList.setItem(item);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        wishList.setCreateDate(dtf.format(now));

        wishListDAO.addItemToWishList(wishList);
    }
}
