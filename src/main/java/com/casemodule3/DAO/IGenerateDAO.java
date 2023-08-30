package com.casemodule3.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IGenerateDAO<E> {
    List<E> findAll();
    E findOne(int id);
    void create(E e);
    void delete(int id);
    void update(E e);
}
