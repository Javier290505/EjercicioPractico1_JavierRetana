/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package EjercicioPractico1_JavierRetana.Repositorio;

/**
 *
 * @author jareg
 */

import com.salonbelleza.salonbelleza.domain.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Servicio extends JpaRepository<Servicio, Integer> {}
