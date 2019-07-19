package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private int id;
    private String title;
    private String description;
    private int year;
    private List<Genre> genres;
    private String picUrl;
    private Date createdDate;
    private String director;

}
