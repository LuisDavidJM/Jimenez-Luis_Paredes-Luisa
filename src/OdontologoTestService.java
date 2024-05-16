import dao.BD;
import dao.OdontologoDAOH2;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import service.OdontologoService;
import service.PacienteService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OdontologoTestService {
    @Test
    public void buscarUnOdontologo(){
        BD.crearTablas();
        OdontologoService odontologoService= new OdontologoService();
        // Probar el método buscarTodos
        List<Odontologo> odontologos = OdontologoService.buscarTodo();
        assertEquals(2, ((List<?>) odontologos).size());

        // Verificar los valores
        Odontologo odontologo1 = odontologos.get(0);
        assertEquals("1234", odontologo1.getMatricula());
        assertEquals("Luis", odontologo1.getNombre());
        assertEquals("Jimenez", odontologo1.getApellido());

        Odontologo odontologo2 = odontologos.get(1);
        assertEquals("4321", odontologo1.getMatricula());
        assertEquals("Luisa", odontologo1.getNombre());
        assertEquals("Paredes", odontologo1.getApellido());

    }
}
