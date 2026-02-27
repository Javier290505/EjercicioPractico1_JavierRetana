/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjercicioPractico1_JavierRetana.Servicio.impl;

/**
 *
 * @author jareg
 */
import com.salonbelleza.salonbelleza.domain.Reserva;
import com.salonbelleza.salonbelleza.repository.ReservaRepository;
import com.salonbelleza.salonbelleza.service.ReservaService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReservaServicioImpl implements ReservaServicio {

    private final Reserva repo;

    public ReservaServicioImpl(Reserva repo) {
        this.repo = repo;
    }

    @Override
    public List<Reserva> listar() {
        return repo.findAll();
    }

    @Override
    public Reserva buscarPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Reserva guardar(Reserva reserva) {
        return repo.save(reserva);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}