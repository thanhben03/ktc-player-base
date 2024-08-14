package vn.edu.likelion.player_manager_2.Service;


public interface BaseService<T> {
    T save(T t);
    void remove(int id);
    Iterable<T> findAll();
    T findById(int id);
}
