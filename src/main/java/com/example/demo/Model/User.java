package com.example.demo.Model;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    
    private String name;
    @Column(unique = true)
    private String emailAddress;
     private String password;
  

    public String getPassword() {
        return this.password;
    }

   
    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy="user")
    private List<Movie> favouriteMovies;

    public Long getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setName(String Name) {
        this.name = Name;
    }
    public void setEmailAddress(String EmailAddress) {
        this.emailAddress = EmailAddress;
    }

    public List<Movie> getFavouriteMovies() {
        return this.favouriteMovies;
    }

    public void setFavouriteMovies(List<Movie> favouriteMovies) {
        this.favouriteMovies = favouriteMovies;
    }

    public boolean addToFavouriteList(Movie movie)
    {
        return this.favouriteMovies.add(movie);
    } 

    public boolean removeFromFavouriteList(Long movieId)
    {
       
        
        for (int i=0;i<favouriteMovies.size();i++)
        {
            if(favouriteMovies.get(i).getMovieId()==movieId)
            {
                favouriteMovies.remove(i);
            
                return true;
            }
            
        }
        return false;
    }
}