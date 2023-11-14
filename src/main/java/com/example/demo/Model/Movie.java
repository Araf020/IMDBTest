package com.example.demo.Model;


import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movieId;
    private String title;
    private String category;
    private Date releaseDate;
    private double budget;
    private String description;

    @ManyToOne
    @JoinColumn(name="userId", nullable=false)
    private User user;

    @OneToMany(mappedBy = "movie")
    private List<Actor> castList;

    public List<Actor> getCastList() {
        return this.castList;
    }

    public void setCastList(List<Actor> castList) {
        this.castList = castList;
    }

    public Long getMovieId() {
        return this.movieId;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getBudget() {
        return this.budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean addToCastList(Actor actor)
    {
        return this.castList.add(actor);
    } 

    public boolean removeFromCastList(Long actorID)
    {
       
        
        for (int i=0;i<castList.size();i++)
        {
            if(castList.get(i).getActorId()==actorID)
            {
                castList.remove(i);
            
                return true;
            }
            
        }
        return false;
    }

    

    



}

