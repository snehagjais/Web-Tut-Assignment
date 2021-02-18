package com.example.wishlist.apis.controller;

import com.example.wishlist.apis.model.Item;
import com.example.wishlist.apis.model.WishList;
import com.example.wishlist.apis.services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    WishListService wishListService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<WishList>> getAllWishList(@PathParam("userId") String userId) {
        int user = Integer.parseInt(userId);
        List<WishList> list = wishListService.fetchAllWishlistItems(user);
        return new ResponseEntity<> (list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addToWishlist(@RequestBody Item item, @PathParam("userId") String userId) {
        int user = Integer.parseInt(userId);
        wishListService.addItemToWishlist(item, user);
        return new ResponseEntity<> (HttpStatus.OK);
    }
}
