/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjercicioPractico1_JavierRetana.Servicio.impl;

/**
 *
 * @author jareg
 */

import com.salonbelleza.salonbelleza.domain.Categoria;
import com.salonbelleza.salonbelleza.repository.CategoriaRepository;
import com.salonbelleza.salonbelleza.service.CategoriaService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServicioImpl implements CategoriaServicio {

    private final CategoriaRepositorio repo;

    public CategoriaServicioImpl(CategoriaRepositorio repo) {
        this.repo = repo;
    }

    @Override
    public List<Categoria> listar() {
        return repo.findAll();
    }

    @Override
    public Categoria buscarPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        return repo.save(categoria);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}