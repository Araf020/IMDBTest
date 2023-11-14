package com.example.demo.Filter;

public class SearchFilter {
    public Long id;
    public String title;
    public String category;
    public String castName;

    public boolean searchByTitle;
    public boolean searchByCategory;
    public boolean searchByCast;
    public boolean searchById;

    public SearchFilter()
    {
        searchByTitle = false;
        searchByCategory = false;
        searchByCast = false;
        searchById = false;
    }
}
