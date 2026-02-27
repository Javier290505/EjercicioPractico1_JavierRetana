/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjercicioPractico1_JavierRetana.Servicio.impl;

/**
 *
 * @author jareg
 */

import com.salonbelleza.salonbelleza.domain.Servicio;
import com.salonbelleza.salonbelleza.repository.ServicioRepository;
import com.salonbelleza.salonbelleza.service.ServicioService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ServicioServicioImpl implements ServicioServicio {

    private final ServicioRepositorio repo;

    public ServicioServiceImpl(ServicioRepositorio repo) {
        this.repo = repo;
    }

    @Override
    public List<Servicio> listar() {
        return repo.findAll();
    }

    @Override
    public Servicio buscarPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Servicio guardar(Servicio servicio) {
        return repo.save(servicio);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
