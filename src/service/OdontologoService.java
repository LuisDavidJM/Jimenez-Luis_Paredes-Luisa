package service;

import dao.OdontologoDAOH2;
import dao.PacienteDAOH2;
import dao.iDao;
import model.Odontologo;
import model.Paciente;

import java.util.List;

public class OdontologoService {

    //relacion de asociacion directa con el DAO
    private static iDao<Odontologo> OdontologoiDao;

        public OdontologoService() {
            OdontologoiDao= new OdontologoDAOH2();
    }
    public Odontologo guardarOdontologo(Odontologo odontologo){
        return OdontologoiDao.guardar(odontologo);
    }

    public static List<Odontologo> buscarTodo(){
        return OdontologoiDao.buscarTodos();
    }
}
