package com.practica.dev.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.practica.dev.model.*;


@NoRepositoryBean
public interface IBaseRepository<E extends Base, ID extends Serializable> extends JpaRepository<E, ID>{

}
