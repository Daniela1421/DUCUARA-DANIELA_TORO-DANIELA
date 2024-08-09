package DAO.Implements;

import Modelo.Odontologo;

import java.util.List;

public interface IDAO<T> {
    T guardar (T t);

    Odontologo buscarPorId(Integer id);

    List<T> listarTodos();
}
