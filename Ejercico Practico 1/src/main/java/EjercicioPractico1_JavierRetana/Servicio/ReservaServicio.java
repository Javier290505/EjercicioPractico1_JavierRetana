/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjercicioPractico1_JavierRetana.Servicio;

/**
 *
 * @author jareg
 */

import com.salonbelleza.salonbelleza.domain.Reserva;
import java.util.List;

public interface ReservaServicio {
    List<Reserva> listar();
    Reserva buscarPorId(Integer id);
    Reserva guardar(Reserva reserva);
    void eliminar(Integer id);
}