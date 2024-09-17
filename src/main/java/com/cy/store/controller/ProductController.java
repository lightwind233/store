package com.cy.store.controller;

import com.cy.store.entity.Comment;
import com.cy.store.entity.Product;
import com.cy.store.service.IProductService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController extends BaseController {
    @Autowired
    private IProductService productService;

    @RequestMapping("hot_list")
    public JsonResult<List<Product>> getHotList() {
        List<Product> data = productService.findHotList();
        return new JsonResult<List<Product>>(OK, data);
    }

    @RequestMapping("{id}/details")
    public JsonResult<Product> getById(@PathVariable("id") Integer id) {
        Product data = productService.findById(id);
        return new JsonResult<Product>(OK, data);
    }
    @RequestMapping("/{id}/comments")
    public JsonResult<List<Comment>> getComments(@PathVariable("id") Integer id) {
        List<Comment> data = productService.findComments(id);
        return new JsonResult<List<Comment>>(OK,data );
    }
    @RequestMapping("/{uid}/{productId}/findUserComment")
    public JsonResult<List<Comment>> findUserComment(@PathVariable("uid") Integer uid,@PathVariable("productId")Integer productId) {
        List<Comment> data = productService.findUserComments(uid,productId);
        for(Comment comment:data){
            System.out.println(comment);
        }
        return new JsonResult<List<Comment>>(OK,data );
    }
}
