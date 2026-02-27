/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjercicioPractico1_JavierRetana.Controllers;

/**
 *
 * @author jareg
 */

import com.salonbelleza.salonbelleza.domain.Categoria;
import com.salonbelleza.salonbelleza.domain.Servicio;
import com.salonbelleza.salonbelleza.service.CategoriaService;
import com.salonbelleza.salonbelleza.service.ServicioService;
import java.math.BigDecimal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    private final ServicioServicio servicioServicio;
    private final CategoriaServicio categoriaServicio;

    public ServicioController(ServicioServicio servicioServicio, CategoriaServicio categoriaServicio) {
        this.servicioServicio = servicioServicio;
        this.categoriaServicio = categoriaServicio;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("servicios", servicioServicio.listar());
        return "servicios/list";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        Servicio s = new Servicio();
        s.setPrecio(new BigDecimal("0.00"));
        model.addAttribute("servicio", s);
        model.addAttribute("categorias", categoriaServicio.listar());
        model.addAttribute("categoriaId", null);
        return "servicios/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Servicio servicio,
                          @RequestParam("categoriaId") Integer categoriaId) {

        Categoria cat = categoriaServicio.buscarPorId(categoriaId);
        servicio.setCategoria(cat);
        servicioService.guardar(servicio);

        return "redirect:/servicios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Servicio s = servicioServicio.buscarPorId(id);

        model.addAttribute("servicio", s);
        model.addAttribute("categorias", categoriaServicio.listar());
        model.addAttribute("categoriaId", s.getCategoria() != null ? s.getCategoria().getId() : null);

        return "servicios/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        servicioServicio.eliminar(id);
        return "redirect:/servicios";
    }
}
