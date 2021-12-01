package com.example.jpaworkshoporiginal.data;

import com.example.jpaworkshoporiginal.model.AppUser;
import com.example.jpaworkshoporiginal.model.Details;

import java.util.Collection;

public interface DetailsDAO {
    Details findById(int id);
    Collection<Details> findAll();
    Details create(Details details);
    Details update(Details details);
    void delete(int id);
}
