package com.noon.kevin.cylonalarms.repositorys;


import com.noon.kevin.cylonalarms.entity.Email;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository <Email,Long> {
    Email findBySiteNumber(Integer number);
}
