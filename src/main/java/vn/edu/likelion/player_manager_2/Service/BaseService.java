package vn.edu.likelion.player_manager_2.Service;


import vn.edu.likelion.player_manager_2.Entity.PlayerEntity;
import vn.edu.likelion.player_manager_2.Model.PlayerDTO;

public interface BaseService<T, K> {
    T save(T t);
    void remove(int id);
    Iterable<T> findAll();
    T findById(int id);
    T update(int id, K dto);
}
