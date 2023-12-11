package org.example.finalexam.services;

import java.util.List;

public interface IService<O> {
    List<O> showAll();
    void create(O o);
    int findIndexById(int id);
    O findById(int id);
    O findByName(String str);
    void delete(int id);
    void update(int id, O o);
}
