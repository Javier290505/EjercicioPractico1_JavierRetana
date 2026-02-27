/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package EjercicioPractico1_JavierRetana.Servicio;

/**
 *
 * @author jareg
 */

import com.salonbelleza.salonbelleza.domain.Categoria;
import java.util.List;

public interface CategoriaServicio {
    List<Categoria> listar();
    Categoria buscarPorId(Integer id);
    Categoria guardar(Categoria categoria);
    void eliminar(Integer id);
}
