package com.example.LR3_Rest.services.base;


import com.example.LR3_Rest.dto.base.BaseDto;
import com.example.LR3_Rest.entities.base.BaseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService <E extends BaseEntity<I>, D extends BaseDto, I> {
    E findById(I id);
    List<E> findAll();
    void save(D dto);
    void delete(I id);
    void update(E entity);
}
