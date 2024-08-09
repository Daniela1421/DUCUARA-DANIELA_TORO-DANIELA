package Servicio;

import DAO.Implements.IDAO;
import Modelo.Odontologo;

import java.util.List;

public class OdontologoServicio {
    private IDAO<Odontologo> idao;

    public OdontologoServicio(IDAO<Odontologo> idao) {
        this.idao = idao;
    }

    public Odontologo guardar(Odontologo odontologo){
        return idao.guardar(odontologo);
    }

    public List<Odontologo> listarTodos(){
        return idao.listarTodos();
    }
}
