/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.*;

/**
 *
 * @author Administrator
 */
public class User extends Person{
    
    private String[] booksIssued;
    
    public User(String userName, String password, String email,
            String firstName, String lastName, String imagePath, String[] booksIssued){
        super(userName, password, email, firstName, lastName, imagePath);
        this.booksIssued = booksIssued;
    }
    
    public User(){
        super();
    }

    public String[] getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(String[] booksIssued) {
        this.booksIssued = booksIssued;
    }
    
    
}
